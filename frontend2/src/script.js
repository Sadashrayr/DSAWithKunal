// DOM Elements
const sidebar = document.getElementById('sidebar');
const sidebarToggle = document.getElementById('sidebarToggle');
const newChatBtn = document.getElementById('newChatBtn');
const messagesContainer = document.getElementById('messagesContainer');
const messageInput = document.getElementById('messageInput');
const sendBtn = document.getElementById('sendBtn');
const attachBtn = document.getElementById('attachBtn');
const fileInput = document.getElementById('fileInput');
const imageModal = document.getElementById('imageModal');
const previewImage = document.getElementById('previewImage');
const imageDetails = document.getElementById('imageDetails');
const closeModal = document.getElementById('closeModal');
const cancelUpload = document.getElementById('cancelUpload');
const analyzeImage = document.getElementById('analyzeImage');
const historyList = document.getElementById('historyList');

// Authentication Elements
const loginModal = document.getElementById('loginModal');
const registerModal = document.getElementById('registerModal');
const loginHeaderBtn = document.getElementById('loginHeaderBtn');
const registerHeaderBtn = document.getElementById('registerHeaderBtn');
const authButtons = document.getElementById('authButtons');
const userMenu = document.getElementById('userMenu');
const closeLoginModal = document.getElementById('closeLoginModal');
const closeRegisterModal = document.getElementById('closeRegisterModal');
const switchToRegister = document.getElementById('switchToRegister');
const switchToLogin = document.getElementById('switchToLogin');
const loginForm = document.getElementById('loginForm');
const registerForm = document.getElementById('registerForm');
const loginBtn = document.getElementById('loginBtn');
const registerBtn = document.getElementById('registerBtn');
const logoutBtn = document.getElementById('logoutBtn');
const userMenuLogout = document.getElementById('userMenuLogout');

// User Profile Elements
const userName = document.getElementById('userName');
const userType = document.getElementById('userType');
const userMenuName = document.getElementById('userMenuName');
const userMenuType = document.getElementById('userMenuType');

// State Management
let currentChatId = null;
let chatHistory = [];
let currentImageFile = null;
let currentImageData = null;
let isAnalyzing = false;
let currentUser = null;
let isLoggedIn = false;
let guestChatHistory = []; // Store guest chat messages temporarily

// Mock AI responses for guest users
const mockAIResponses = [
    "I understand you're interested in OCT analysis. As an AI assistant specialized in retinal imaging, I can help explain various retinal conditions and OCT interpretation techniques. However, for detailed image analysis and personalized medical advice, please consider logging in or consulting with a qualified ophthalmologist.",
    
    "OCT (Optical Coherence Tomography) is a powerful imaging technique that provides cross-sectional views of the retina. Common findings include drusen, fluid accumulation, and retinal layer changes. For specific image analysis and clinical recommendations, I'd recommend creating an account to access full features.",
    
    "Retinal conditions like macular degeneration, diabetic retinopathy, and macular edema can be well-visualized with OCT imaging. Each condition has characteristic patterns and features. Would you like me to explain any specific retinal condition? For image upload and analysis, please log in to access those features.",
    
    "I can provide general information about OCT imaging and retinal anatomy. The retina has multiple layers including the RPE, photoreceptors, and various nuclear layers. OCT helps visualize these structures and detect abnormalities. For personalized analysis, please consider registering for an account.",
    
    "Thank you for your question about retinal imaging. I'm designed to help with OCT analysis and can provide educational information about various retinal conditions. For full functionality including image upload and detailed analysis, please log in or create an account."
];

// Chart instance
let currentChart = null;

// Initialize the application
document.addEventListener('DOMContentLoaded', function() {
    initializeApp();
    loadChatHistory();
    setupEventListeners();
    checkAuthStatus();
});

function initializeApp() {
    // Auto-resize textarea
    messageInput.addEventListener('input', function() {
        this.style.height = 'auto';
        this.style.height = Math.min(this.scrollHeight, 120) + 'px';
        
        // Enable/disable send button
        sendBtn.disabled = !this.value.trim() && !currentImageFile;
    });

    // Enable send button when image is selected
    updateSendButtonState();
}

function setupEventListeners() {
    // Sidebar toggle
    sidebarToggle.addEventListener('click', toggleSidebar);
    
    // New chat
    newChatBtn.addEventListener('click', startNewChat);
    
    // Send message
    sendBtn.addEventListener('click', sendMessage);
    messageInput.addEventListener('keydown', function(e) {
        if (e.key === 'Enter' && !e.shiftKey) {
            e.preventDefault();
            sendMessage();
        }
    });
    
    // File upload
    attachBtn.addEventListener('click', () => {
        if (!isLoggedIn) {
            alert('Please login to upload and analyze OCT images.');
            showLoginModal();
            return;
        }
        fileInput.click();
    });
    fileInput.addEventListener('change', handleFileSelect);
    
    // Modal controls
    closeModal.addEventListener('click', closeImageModal);
    cancelUpload.addEventListener('click', closeImageModal);
    analyzeImage.addEventListener('click', confirmImageAnalysis);
    
    // Close modal on backdrop click
    imageModal.addEventListener('click', function(e) {
        if (e.target === imageModal) {
            closeImageModal();
        }
    });

    // Authentication Event Listeners
    loginHeaderBtn.addEventListener('click', showLoginModal);
    registerHeaderBtn.addEventListener('click', showRegisterModal);
    closeLoginModal.addEventListener('click', hideLoginModal);
    closeRegisterModal.addEventListener('click', hideRegisterModal);
    switchToRegister.addEventListener('click', switchToRegisterModal);
    switchToLogin.addEventListener('click', switchToLoginModal);
    loginForm.addEventListener('submit', handleLogin);
    registerForm.addEventListener('submit', handleRegister);
    logoutBtn.addEventListener('click', handleLogout);
    userMenuLogout.addEventListener('click', handleLogout);

    // Close modals on backdrop click
    loginModal.addEventListener('click', function(e) {
        if (e.target === loginModal) {
            hideLoginModal();
        }
    });

    registerModal.addEventListener('click', function(e) {
        if (e.target === registerModal) {
            hideRegisterModal();
        }
    });
}

// Authentication Functions
function showLoginModal() {
    loginModal.style.display = 'flex';
    document.getElementById('loginEmail').focus();
}

function showRegisterModal() {
    registerModal.style.display = 'flex';
    document.getElementById('registerName').focus();
}

function hideLoginModal() {
    loginModal.style.display = 'none';
    loginForm.reset();
}

function hideRegisterModal() {
    registerModal.style.display = 'none';
    registerForm.reset();
}

function switchToRegisterModal() {
    hideLoginModal();
    showRegisterModal();
}

function switchToLoginModal() {
    hideRegisterModal();
    showLoginModal();
}

// Mock authentication functions (since no backend)
async function handleLogin(e) {
    e.preventDefault();
    
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;
    
    setButtonLoading(loginBtn, true);
    
    // Simulate API call delay
    setTimeout(() => {
        // Mock successful login
        currentUser = {
            id: 'user_' + Date.now(),
            name: email.split('@')[0].charAt(0).toUpperCase() + email.split('@')[0].slice(1),
            email: email,
            specialty: 'Ophthalmologist'
        };
        isLoggedIn = true;
        updateUIForLoggedInUser();
        hideLoginModal();
        
        // Store user data in localStorage
        localStorage.setItem('currentUser', JSON.stringify(currentUser));
        localStorage.setItem('isLoggedIn', 'true');
        
        addMessage('ai', `Welcome back, ${currentUser.name}! I'm ready to help you with OCT image analysis and retinal condition discussions.`);
        
        setButtonLoading(loginBtn, false);
    }, 1500);
}

async function handleRegister(e) {
    e.preventDefault();
    
    const name = document.getElementById('registerName').value;
    const email = document.getElementById('registerEmail').value;
    const specialty = document.getElementById('registerSpecialty').value;
    const password = document.getElementById('registerPassword').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    
    if (password !== confirmPassword) {
        alert('Passwords do not match!');
        return;
    }
    
    if (password.length < 6) {
        alert('Password must be at least 6 characters long!');
        return;
    }
    
    setButtonLoading(registerBtn, true);
    
    // Simulate API call delay
    setTimeout(() => {
        // Mock successful registration
        currentUser = {
            id: 'user_' + Date.now(),
            name: name,
            email: email,
            specialty: specialty
        };
        isLoggedIn = true;
        updateUIForLoggedInUser();
        hideRegisterModal();
        
        // Store user data in localStorage
        localStorage.setItem('currentUser', JSON.stringify(currentUser));
        localStorage.setItem('isLoggedIn', 'true');
        
        addMessage('ai', `Welcome to OCT AI Assistant, ${currentUser.name}! I'm excited to help you with retinal OCT analysis and provide insights based on your specialty as a ${specialty}.`);
        
        setButtonLoading(registerBtn, false);
    }, 1500);
}

async function handleLogout() {
    currentUser = null;
    isLoggedIn = false;
    guestChatHistory = []; // Clear guest chat history
    updateUIForLoggedOutUser();
    
    // Clear localStorage
    localStorage.removeItem('currentUser');
    localStorage.removeItem('isLoggedIn');
    
    // Reset chat
    startNewChat();
}

function updateUIForLoggedInUser() {
    authButtons.style.display = 'none';
    userMenu.style.display = 'flex';
    logoutBtn.style.display = 'block';
    
    // Update user info in sidebar
    userName.textContent = currentUser.name;
    userType.textContent = currentUser.specialty;
    
    // Update user info in header menu
    userMenuName.textContent = currentUser.name;
    userMenuType.textContent = currentUser.specialty;
}

function updateUIForLoggedOutUser() {
    authButtons.style.display = 'flex';
    userMenu.style.display = 'none';
    logoutBtn.style.display = 'none';
    
    // Reset user info in sidebar
    userName.textContent = 'Guest User';
    userType.textContent = 'Not logged in';
}

function checkAuthStatus() {
    const storedUser = localStorage.getItem('currentUser');
    const storedLoginStatus = localStorage.getItem('isLoggedIn');
    
    if (storedUser && storedLoginStatus === 'true') {
        currentUser = JSON.parse(storedUser);
        isLoggedIn = true;
        updateUIForLoggedInUser();
    } else {
        updateUIForLoggedOutUser();
    }
}

function setButtonLoading(button, loading) {
    const btnText = button.querySelector('.btn-text');
    const btnSpinner = button.querySelector('.btn-spinner');
    
    if (loading) {
        btnText.style.display = 'none';
        btnSpinner.style.display = 'block';
        button.disabled = true;
    } else {
        btnText.style.display = 'block';
        btnSpinner.style.display = 'none';
        button.disabled = false;
    }
}

function toggleSidebar() {
    sidebar.classList.toggle('collapsed');
}

function startNewChat() {
    currentChatId = generateChatId();
    guestChatHistory = []; // Clear guest chat history
    messagesContainer.innerHTML = `
        <div class="welcome-message">
            <div class="ai-avatar">
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M9 12l2 2 4-4"/>
                    <path d="M21 12c-1 0-3-1-3-3s2-3 3-3 3 1 3 3-2 3-3 3"/>
                    <path d="M3 12c1 0 3-1 3-3s-2-3-3-3-3 1-3 3 2 3 3 3"/>
                    <path d="M12 3c0 1-1 3-3 3s-3-2-3-3 1-3 3-3 3 2 3 3"/>
                    <path d="M12 21c0-1 1-3 3-3s3 2 3 3-1 3-3 3-3-2-3-3"/>
                </svg>
            </div>
            <div class="welcome-content">
                <h2>${isLoggedIn ? `Welcome back, ${currentUser.name}!` : 'Welcome to OCT AI Assistant'}</h2>
                <p>I'm here to help you analyze retinal OCT images and provide detailed insights. You can:</p>
                <ul>
                    <li>Upload OCT images for automated analysis ${!isLoggedIn ? '(Login required)' : ''}</li>
                    <li>Ask questions about retinal conditions</li>
                    <li>Get clinical recommendations and insights</li>
                    <li>Discuss findings and treatment options</li>
                </ul>
                <p>${isLoggedIn ? 'Upload an OCT image or ask me anything to get started!' : 'You can chat as a guest, but <strong>login or register</strong> to save conversations and upload OCT images!'}</p>
            </div>
        </div>
    `;
    currentImageFile = null;
    currentImageData = null;
    updateSendButtonState();
}

async function sendMessage() {
    const text = messageInput.value.trim();
    
    if (!text && !currentImageFile) return;
    
    // Disable send button during processing
    sendBtn.disabled = true;
    
    try {
        // Add user message
        if (text) {
            addMessage('user', text);
            
            // Store in guest history if not logged in
            if (!isLoggedIn) {
                guestChatHistory.push({
                    sender: 'user',
                    content: text,
                    timestamp: new Date()
                });
            }
        }
        
        // Handle image upload and analysis (only for logged in users)
        if (currentImageFile && isLoggedIn) {
            await handleImageUploadAndAnalysis();
        } else if (text) {
            // Send text message (works for both guest and logged in users)
            await sendTextMessage(text);
        }
        
    } catch (error) {
        console.error('Error sending message:', error);
        addMessage('ai', 'I apologize, but I encountered an error processing your request. Please try again.');
    } finally {
        // Clear input and reset state
        messageInput.value = '';
        messageInput.style.height = 'auto';
        currentImageFile = null;
        updateSendButtonState();
    }
}

async function sendTextMessage(text) {
    try {
        showTypingIndicator();
        
        // Simulate processing delay
        await new Promise(resolve => setTimeout(resolve, 1000 + Math.random() * 2000));
        
        hideTypingIndicator();
        
        let response;
        if (isLoggedIn) {
            // For logged in users, provide more detailed responses
            response = generateDetailedResponse(text);
        } else {
            // For guest users, provide general responses
            response = generateGuestResponse(text);
            
            // Add guest notice
            addGuestNotice();
        }
        
        addMessage('ai', response);
        
        // Store in guest history if not logged in
        if (!isLoggedIn) {
            guestChatHistory.push({
                sender: 'ai',
                content: response,
                timestamp: new Date()
            });
        }
        
    } catch (error) {
        hideTypingIndicator();
        console.error('Text message error:', error);
        addMessage('ai', 'I apologize, but I encountered an issue processing your question. Please try again.');
    }
}

function generateDetailedResponse(text) {
    const lowerText = text.toLowerCase();
    
    if (lowerText.includes('oct') || lowerText.includes('optical coherence tomography')) {
        return "OCT (Optical Coherence Tomography) is an excellent imaging modality for retinal analysis. It provides high-resolution cross-sectional images of retinal layers, allowing us to detect subtle changes in conditions like macular degeneration, diabetic retinopathy, and macular edema. Would you like me to analyze a specific OCT image or discuss particular findings?";
    }
    
    if (lowerText.includes('macular degeneration') || lowerText.includes('amd')) {
        return "Age-related Macular Degeneration (AMD) shows characteristic OCT findings including drusen (hyperreflective deposits beneath the RPE), geographic atrophy, and in wet AMD, choroidal neovascularization with associated fluid. Key OCT features include subretinal fluid, intraretinal fluid, and pigment epithelial detachments. Early detection through OCT is crucial for timely treatment.";
    }
    
    if (lowerText.includes('diabetic retinopathy') || lowerText.includes('diabetic')) {
        return "Diabetic retinopathy on OCT typically shows macular edema with intraretinal cysts, hard exudates appearing as hyperreflective foci, and in advanced cases, tractional changes. The central macular thickness measurement is crucial for monitoring treatment response. Anti-VEGF therapy monitoring often relies on OCT findings.";
    }
    
    if (lowerText.includes('fluid') || lowerText.includes('edema')) {
        return "Retinal fluid on OCT can be classified as subretinal fluid (between neurosensory retina and RPE), intraretinal fluid (cystic spaces within retinal layers), or sub-RPE fluid. Each type has different clinical implications and treatment approaches. The location and extent of fluid help guide therapeutic decisions.";
    }
    
    return "Thank you for your question about retinal imaging. As your OCT AI assistant, I can help analyze various retinal conditions, interpret OCT findings, and provide clinical insights. Feel free to upload an OCT image for detailed analysis or ask about specific retinal pathologies you'd like to discuss.";
}

function generateGuestResponse(text) {
    // Return a random mock response for guest users
    return mockAIResponses[Math.floor(Math.random() * mockAIResponses.length)];
}

function addGuestNotice() {
    // Add a notice for guest users about limited functionality
    const noticeDiv = document.createElement('div');
    noticeDiv.className = 'guest-notice';
    noticeDiv.innerHTML = `
        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <circle cx="12" cy="12" r="10"/>
            <line x1="12" y1="8" x2="12" y2="12"/>
            <line x1="12" y1="16" x2="12.01" y2="16"/>
        </svg>
        <span>You're chatting as a guest. Login to save conversations and upload OCT images for analysis.</span>
    `;
    
    messagesContainer.appendChild(noticeDiv);
    scrollToBottom();
}

async function handleImageUploadAndAnalysis() {
    try {
        // Show typing indicator
        showTypingIndicator();
        
        // Simulate image processing
        await new Promise(resolve => setTimeout(resolve, 2000));
        
        // Mock image data
        const imageData = {
            filename: currentImageFile.name,
            url: URL.createObjectURL(currentImageFile),
            metadata: {
                size: currentImageFile.size,
                type: currentImageFile.type,
                uploadTime: new Date()
            }
        };
        
        // Display the full image with analysis
        addFullImageDisplay(imageData);
        
        hideTypingIndicator();
        
        // Mock analysis response
        const analysisResponse = "I've analyzed your OCT image and can see the retinal layer structure. The image shows good visualization of the retinal layers. For a complete clinical interpretation, I would need additional clinical context. Key areas to evaluate include the foveal contour, presence of any fluid, and integrity of the photoreceptor layers.";
        
        addMessage('ai', analysisResponse);
        
        // Mock confidence data for chart
        const confidenceData = [
            { condition: 'Normal', confidence: 65, color: '#10a37f' },
            { condition: 'Mild Changes', confidence: 25, color: '#f59e0b' },
            { condition: 'Pathological', confidence: 10, color: '#ef4444' }
        ];
        
        updateAnalysisChart(confidenceData);
        
    } catch (error) {
        hideTypingIndicator();
        console.error('Image analysis error:', error);
        addMessage('ai', 'I apologize, but I encountered an error analyzing your image. Please try again with a different image format.');
    }
}

function addMessage(sender, content, timestamp = new Date()) {
    const messageDiv = document.createElement('div');
    messageDiv.className = `message ${sender}`;
    
    const avatar = sender === 'user' ? 
        `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/>
            <circle cx="12" cy="7" r="4"/>
        </svg>` :
        `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M9 12l2 2 4-4"/>
            <path d="M21 12c-1 0-3-1-3-3s2-3 3-3 3 1 3 3-2 3-3 3"/>
            <path d="M3 12c1 0 3-1 3-3s-2-3-3-3-3 1-3 3 2 3 3 3"/>
            <path d="M12 3c0 1-1 3-3 3s-3-2-3-3 1-3 3-3 3 2 3 3"/>
            <path d="M12 21c0-1 1-3 3-3s3 2 3 3-1 3-3 3-3-2-3-3"/>
        </svg>`;
    
    messageDiv.innerHTML = `
        <div class="message-avatar">
            ${avatar}
        </div>
        <div class="message-content">
            <div class="message-text">${content}</div>
            <div class="message-time">${formatTime(timestamp)}</div>
        </div>
    `;
    
    messagesContainer.appendChild(messageDiv);
    scrollToBottom();
}

function addFullImageDisplay(imageData) {
    const displayDiv = document.createElement('div');
    displayDiv.className = 'full-image-display';
    displayDiv.id = 'currentImageDisplay';
    
    displayDiv.innerHTML = `
        <div class="image-section">
            <h3>
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <rect x="3" y="3" width="18" height="18" rx="2" ry="2"/>
                    <circle cx="8.5" cy="8.5" r="1.5"/>
                    <polyline points="21,15 16,10 5,21"/>
                </svg>
                Uploaded OCT Image
            </h3>
            <img src="${imageData.url}" alt="OCT Scan" class="full-oct-image" id="fullOctImage">
            <div class="image-metadata">
                <div class="metadata-row">
                    <span class="metadata-label">File Name:</span>
                    <span class="metadata-value">${imageData.filename}</span>
                </div>
                <div class="metadata-row">
                    <span class="metadata-label">Upload Time:</span>
                    <span class="metadata-value">${formatTime(new Date())}</span>
                </div>
                <div class="metadata-row">
                    <span class="metadata-label">Status:</span>
                    <span class="metadata-value">Analyzed</span>
                </div>
            </div>
        </div>
        <div class="analysis-section">
            <h3>
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <path d="M9 11H5a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h4"/>
                    <path d="M15 11h4a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2h-4"/>
                    <path d="M12 2v20"/>
                    <path d="M8 6l4-4 4 4"/>
                    <path d="M8 18l4 4 4-4"/>
                </svg>
                Analysis Results
            </h3>
            <div class="chart-container" id="analysisChartContainer">
                <div class="chart-title">Confidence Analysis</div>
                <div class="chart-wrapper">
                    <canvas id="analysisChart"></canvas>
                </div>
                <div class="chart-legend" id="analysisLegend">
                    <div style="text-align: center; color: #8e8ea0; padding: 20px;">
                        Analysis complete
                    </div>
                </div>
            </div>
        </div>
    `;
    
    messagesContainer.appendChild(displayDiv);
    scrollToBottom();
}

function updateAnalysisChart(confidenceData) {
    const chartCanvas = document.getElementById('analysisChart');
    const legendContainer = document.getElementById('analysisLegend');
    
    if (!chartCanvas || !legendContainer) return;
    
    // Destroy existing chart if it exists
    if (currentChart) {
        currentChart.destroy();
    }
    
    // Create new chart
    const ctx = chartCanvas.getContext('2d');
    currentChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: confidenceData.map(item => item.condition),
            datasets: [{
                data: confidenceData.map(item => item.confidence),
                backgroundColor: confidenceData.map(item => item.color),
                borderColor: confidenceData.map(item => item.color + '80'),
                borderWidth: 2,
                hoverOffset: 15,
                hoverBorderWidth: 3
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    display: false
                },
                tooltip: {
                    backgroundColor: 'rgba(0, 0, 0, 0.9)',
                    titleColor: 'white',
                    bodyColor: 'white',
                    borderColor: 'rgba(255, 255, 255, 0.2)',
                    borderWidth: 1,
                    cornerRadius: 8,
                    callbacks: {
                        label: function(context) {
                            return `${context.label}: ${context.parsed.toFixed(1)}%`;
                        }
                    }
                }
            },
            animation: {
                animateRotate: true,
                animateScale: true,
                duration: 1500,
                easing: 'easeInOutQuart'
            }
        }
    });
    
    // Update legend
    legendContainer.innerHTML = '';
    confidenceData.forEach((item) => {
        const legendItem = document.createElement('div');
        legendItem.className = 'legend-item';
        
        legendItem.innerHTML = `
            <div class="legend-color" style="background-color: ${item.color}"></div>
            <span class="legend-text">${item.condition}</span>
            <span class="legend-value">${item.confidence.toFixed(1)}%</span>
        `;
        
        legendContainer.appendChild(legendItem);
    });
}

function showTypingIndicator() {
    const typingDiv = document.createElement('div');
    typingDiv.className = 'typing-indicator';
    typingDiv.id = 'typingIndicator';
    
    typingDiv.innerHTML = `
        <div class="message-avatar">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <path d="M9 12l2 2 4-4"/>
                <path d="M21 12c-1 0-3-1-3-3s2-3 3-3 3 1 3 3-2 3-3 3"/>
                <path d="M3 12c1 0 3-1 3-3s-2-3-3-3-3 1-3 3 2 3 3 3"/>
                <path d="M12 3c0 1-1 3-3 3s-3-2-3-3 1-3 3-3 3 2 3 3"/>
                <path d="M12 21c0-1 1-3 3-3s3 2 3 3-1 3-3 3-3-2-3-3"/>
            </svg>
        </div>
        <div class="message-content">
            <div class="typing-dots">
                <div class="typing-dot"></div>
                <div class="typing-dot"></div>
                <div class="typing-dot"></div>
            </div>
        </div>
    `;
    
    messagesContainer.appendChild(typingDiv);
    scrollToBottom();
}

function hideTypingIndicator() {
    const typingIndicator = document.getElementById('typingIndicator');
    if (typingIndicator) {
        typingIndicator.remove();
    }
}

function handleFileSelect(e) {
    const file = e.target.files[0];
    if (!file) return;
    
    if (!file.type.startsWith('image/')) {
        alert('Please select a valid image file.');
        return;
    }
    
    currentImageFile = file;
    showImagePreview(file);
}

function showImagePreview(file) {
    const reader = new FileReader();
    reader.onload = function(e) {
        previewImage.src = e.target.result;
        
        // Update image details
        imageDetails.innerHTML = `
            <div class="detail-row">
                <span class="detail-label">File Name:</span>
                <span class="detail-value">${file.name}</span>
            </div>
            <div class="detail-row">
                <span class="detail-label">File Size:</span>
                <span class="detail-value">${formatFileSize(file.size)}</span>
            </div>
            <div class="detail-row">
                <span class="detail-label">File Type:</span>
                <span class="detail-value">${file.type}</span>
            </div>
        `;
        
        imageModal.style.display = 'flex';
    };
    reader.readAsDataURL(file);
}

function closeImageModal() {
    imageModal.style.display = 'none';
    currentImageFile = null;
    fileInput.value = '';
    updateSendButtonState();
}

function confirmImageAnalysis() {
    if (!isLoggedIn) {
        alert('Please login to analyze OCT images.');
        closeImageModal();
        showLoginModal();
        return;
    }
    
    imageModal.style.display = 'none';
    updateSendButtonState();
    
    // Trigger the send message function
    sendMessage();
}

function updateSendButtonState() {
    const hasText = messageInput.value.trim().length > 0;
    const hasImage = currentImageFile !== null;
    sendBtn.disabled = !hasText && !hasImage;
}

function scrollToBottom() {
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
}

function formatTime(date) {
    return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
}

function formatFileSize(bytes) {
    if (bytes === 0) return '0 Bytes';
    const k = 1024;
    const sizes = ['Bytes', 'KB', 'MB', 'GB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(2)) + ' ' + sizes[i];
}

function generateChatId() {
    return 'chat-' + Date.now() + '-' + Math.random().toString(36).substr(2, 9);
}

function loadChatHistory() {
    // For demo purposes, we'll just show the welcome message
    // In a real app, this would load from localStorage or backend
}