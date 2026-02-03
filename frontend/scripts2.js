let isTyping = false;
let uploadedImages = []; // Store uploaded images

function showUploadModal() {
    document.getElementById('uploadOverlay').style.display = 'flex';
}

function hideUploadModal() {
    document.getElementById('uploadOverlay').style.display = 'none';
}

function handleFileUpload(event) {
    const file = event.target.files[0];
    if (file) {
        hideUploadModal();
        
        // Create image preview
        const reader = new FileReader();
        reader.onload = function(e) {
            const imageUrl = e.target.result;
            uploadedImages.push({
                file: file,
                url: imageUrl,
                name: file.name
            });
            
            // Add image message to chat
            addImageMessage(file.name, imageUrl, 'user');
            
            // Send to backend for analysis
            sendImageToBackend(file, imageUrl);
        };
        reader.readAsDataURL(file);
    }
}

async function sendImageToBackend(file, imageUrl) {
    showTypingIndicator();
    
    try {
        // TODO: Replace this URL with your actual backend endpoint
        const backendUrl = 'YOUR_BACKEND_URL/analyze-oct';
        
        const formData = new FormData();
        formData.append('image', file);
        
        const response = await fetch(backendUrl, {
            method: 'POST',
            body: formData
        });
        
        if (response.ok) {
            const result = await response.json();
            hideTypingIndicator();
            addMessage(result.analysis || result.message, 'bot');
        } else {
            throw new Error('Backend analysis failed');
        }
    } catch (error) {
        console.error('Error sending to backend:', error);
        hideTypingIndicator();
        // Fallback response for demo purposes
        addMessage("I can see your OCT scan has been uploaded. Please ensure your backend is connected to get AI analysis results.", 'bot');
    }
}

async function sendMessageToBackend(message) {
    try {
        // TODO: Replace this URL with your actual backend endpoint
        const backendUrl = 'YOUR_BACKEND_URL/chat';
        
        const response = await fetch(backendUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                message: message,
                context: uploadedImages.length > 0 ? 'has_uploaded_images' : 'no_images'
            })
        });
        
        if (response.ok) {
            const result = await response.json();
            return result.response || result.message;
        } else {
            throw new Error('Backend chat failed');
        }
    } catch (error) {
        console.error('Error sending to backend:', error);
        // Fallback response for demo purposes
        return "I'm here to help with OCT analysis. Please ensure your backend is connected for AI-powered responses.";
    }
}

function handleKeyPress(event) {
    if (event.key === 'Enter') {
        sendMessage();
    }
}

async function sendMessage() {
    const input = document.getElementById('messageInput');
    const message = input.value.trim();
    
    if (message && !isTyping) {
        addMessage(message, 'user');
        input.value = '';
        
        showTypingIndicator();
        
        // Send to backend
        const response = await sendMessageToBackend(message);
        hideTypingIndicator();
        addMessage(response, 'bot');
    }
}

function addMessage(text, sender) {
    const messagesContainer = document.getElementById('chatMessages');
    
    const messageContainer = document.createElement('div');
    messageContainer.className = `message-container ${sender}-message-container`;
    
    const avatar = document.createElement('div');
    avatar.className = `message-avatar ${sender}-message-avatar`;
    avatar.innerHTML = sender === 'bot' ? '<i class="fas fa-robot"></i>' : '<i class="fas fa-user"></i>';
    
    const bubble = document.createElement('div');
    bubble.className = `message-bubble ${sender}-message-bubble`;
    bubble.textContent = text;
    
    messageContainer.appendChild(avatar);
    messageContainer.appendChild(bubble);
    
    messagesContainer.appendChild(messageContainer);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
}

function addImageMessage(fileName, imageUrl, sender) {
    const messagesContainer = document.getElementById('chatMessages');
    
    const messageContainer = document.createElement('div');
    messageContainer.className = `message-container ${sender}-message-container`;
    
    const avatar = document.createElement('div');
    avatar.className = `message-avatar ${sender}-message-avatar`;
    avatar.innerHTML = sender === 'bot' ? '<i class="fas fa-robot"></i>' : '<i class="fas fa-user"></i>';
    
    const bubble = document.createElement('div');
    bubble.className = `message-bubble ${sender}-message-bubble image-message-bubble`;
    
    // Create image element
    const img = document.createElement('img');
    img.src = imageUrl;
    img.alt = fileName;
    img.className = 'uploaded-image';
    img.onclick = () => openImageModal(imageUrl, fileName);
    
    const caption = document.createElement('p');
    caption.textContent = `📎 ${fileName}`;
    caption.className = 'image-caption';
    
    bubble.appendChild(img);
    bubble.appendChild(caption);
    
    messageContainer.appendChild(avatar);
    messageContainer.appendChild(bubble);
    
    messagesContainer.appendChild(messageContainer);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
}

function openImageModal(imageUrl, fileName) {
    // Create modal for full-size image view
    const modal = document.createElement('div');
    modal.className = 'image-modal-overlay';
    modal.innerHTML = `
        <div class="image-modal">
            <div class="image-modal-header">
                <h3>${fileName}</h3>
                <button onclick="this.closest('.image-modal-overlay').remove()">
                    <i class="fas fa-times"></i>
                </button>
            </div>
            <img src="${imageUrl}" alt="${fileName}" class="modal-image">
        </div>
    `;
    
    modal.onclick = (e) => {
        if (e.target === modal) {
            modal.remove();
        }
    };
    
    document.body.appendChild(modal);
}

function showTypingIndicator() {
    isTyping = true;
    const messagesContainer = document.getElementById('chatMessages');
    
    const typingContainer = document.createElement('div');
    typingContainer.className = 'message-container';
    typingContainer.id = 'typingIndicator';
    
    const avatar = document.createElement('div');
    avatar.className = 'message-avatar bot-message-avatar';
    avatar.innerHTML = '<i class="fas fa-robot"></i>';
    
    const bubble = document.createElement('div');
    bubble.className = 'message-bubble bot-message-bubble';
    bubble.innerHTML = '<div style="display: flex; gap: 4px;"><div style="width: 8px; height: 8px; background: #a0aec0; border-radius: 50%; animation: typing 1.4s infinite;"></div><div style="width: 8px; height: 8px; background: #a0aec0; border-radius: 50%; animation: typing 1.4s infinite 0.2s;"></div><div style="width: 8px; height: 8px; background: #a0aec0; border-radius: 50%; animation: typing 1.4s infinite 0.4s;"></div></div>';
    
    typingContainer.appendChild(avatar);
    typingContainer.appendChild(bubble);
    
    messagesContainer.appendChild(typingContainer);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
    
    // Add typing animation CSS
    if (!document.getElementById('typingAnimation')) {
        const style = document.createElement('style');
        style.id = 'typingAnimation';
        style.textContent = `
            @keyframes typing {
                0%, 60%, 100% { transform: translateY(0); }
                30% { transform: translateY(-10px); }
            }
        `;
        document.head.appendChild(style);
    }
}

function hideTypingIndicator() {
    isTyping = false;
    const indicator = document.getElementById('typingIndicator');
    if (indicator) {
        indicator.remove();
    }
}

// Authentication functions
function checkAuthAndShowUpload() {
    const userData = localStorage.getItem('userData');
    if (!userData) {
        alert('Please login or register to upload OCT images');
        window.location.href = 'register.html';
        return;
    }
    showUploadModal();
}

function logout() {
    localStorage.removeItem('userData');
    localStorage.removeItem('authToken');
    location.reload();
}

function checkFirstTimeVisitor() {
    const userData = localStorage.getItem('userData');
    const hasVisitedBefore = localStorage.getItem('hasVisitedBefore');
    
    if (!userData && !hasVisitedBefore) {
        // First time visitor with no credentials
        localStorage.setItem('hasVisitedBefore', 'true');
        // Optionally redirect to register page or show a welcome modal
        // window.location.href = 'register.html';
    }
}

// Close upload modal when clicking outside
document.getElementById('uploadOverlay').addEventListener('click', function(e) {
    if (e.target === this) {
        hideUploadModal();
    }
});

// Initialize page
document.addEventListener('DOMContentLoaded', function() {
    console.log('OCT AI Assistant loaded. Ready for backend integration.');
    console.log('Please update the backend URLs in dashboard-script.js:');
    console.log('1. sendImageToBackend() - for image analysis');
    console.log('2. sendMessageToBackend() - for chat responses');
    
    // Check if user is first time visitor
    checkFirstTimeVisitor();
    
    // Check authentication status
    const userData = localStorage.getItem('userData');
    
    if (userData) {
        const user = JSON.parse(userData);
        
        // Show user info and hide auth buttons
        document.getElementById('userInfo').style.display = 'block';
        document.getElementById('authActions').style.display = 'none';
        document.getElementById('loggedInStatus').style.display = 'flex';
        
        // Update user display
        document.getElementById('userName').textContent = user.fullName;
        document.getElementById('userType').textContent = user.userType;
        
        // Update avatar with initials
        const initials = user.fullName.split(' ').map(name => name.charAt(0)).join('').substring(0, 2);
        document.getElementById('userAvatar').textContent = initials;
        
        // Enable chat input and buttons
        document.getElementById('messageInput').disabled = false;
        document.getElementById('messageInput').placeholder = 'Ask about OCT analysis, upload an image, or describe symptoms...';
        document.getElementById('sendBtn').disabled = false;
        document.getElementById('uploadBtn').disabled = false;
        
        // Update welcome text
        document.getElementById('welcomeText').textContent = `Welcome back, ${user.fullName}! I'm here to help you analyze retinal OCT images and provide detailed insights. You can:`;
        document.getElementById('ctaText').textContent = 'Upload an OCT image or ask me anything to get started!';
    } else {
        // Show auth buttons and hide user info
        document.getElementById('userInfo').style.display = 'none';
        document.getElementById('authActions').style.display = 'flex';
        document.getElementById('loggedInStatus').style.display = 'none';
        
        // Keep chat input disabled
        document.getElementById('messageInput').disabled = true;
        document.getElementById('sendBtn').disabled = true;
        document.getElementById('uploadBtn').disabled = true;
    }
});
