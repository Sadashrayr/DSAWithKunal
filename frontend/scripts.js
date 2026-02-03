let isTyping = false;

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
        
        // Add file upload message
        addMessage(`I've uploaded an OCT scan: ${file.name}`, 'user');
        
        // Simulate AI analysis
        setTimeout(() => {
            showTypingIndicator();
            
            setTimeout(() => {
                hideTypingIndicator();
                addMessage(`I can see your OCT scan. Based on my analysis, I've detected signs of Diabetic Retinopathy with 97.47% confidence. The scan shows characteristic changes in the retinal blood vessels. Would you like me to explain the findings in detail or discuss treatment recommendations?`, 'bot');
            }, 2000);
        }, 500);
    }
}

function handleKeyPress(event) {
    if (event.key === 'Enter') {
        sendMessage();
    }
}

function sendMessage() {
    const input = document.getElementById('messageInput');
    const message = input.value.trim();
    
    if (message && !isTyping) {
        addMessage(message, 'user');
        input.value = '';
        
        // Simulate bot response
        setTimeout(() => {
            showTypingIndicator();
            
            setTimeout(() => {
                hideTypingIndicator();
                const response = getBotResponse(message);
                addMessage(response, 'bot');
            }, 1500);
        }, 500);
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

function getBotResponse(userInput) {
    const input = userInput.toLowerCase();
    
    if (input.includes('diabetic') || input.includes('retinopathy')) {
        return "Diabetic Retinopathy is a complication of diabetes that affects the blood vessels in the retina. High blood sugar levels can damage these vessels, causing them to leak or become blocked. Early stages may have no symptoms, which is why regular OCT scans are so important for people with diabetes.";
    }
    
    if (input.includes('confidence') || input.includes('percentage')) {
        return "The confidence level represents how certain our AI model is about the diagnosis. Higher confidence indicates more reliable results. A 97.47% confidence level means the AI is highly certain about detecting Diabetic Retinopathy based on analyzing thousands of similar OCT images.";
    }
    
    if (input.includes('treatment') || input.includes('what should') || input.includes('next')) {
        return "For Diabetic Retinopathy, I recommend: 1) Schedule an appointment with your ophthalmologist within 2-4 weeks, 2) Bring this analysis with you, 3) Continue managing your diabetes carefully, 4) Ask about treatment options which may include laser therapy, anti-VEGF injections, or monitoring. Early intervention often leads to better outcomes.";
    }
    
    if (input.includes('normal') || input.includes('healthy')) {
        return "A normal OCT scan shows clear, well-defined retinal layers without fluid accumulation, blood vessel changes, or structural abnormalities. The scan would show normal foveal contour and intact photoreceptor layers.";
    }
    
    return "Thank you for your question about OCT analysis. I can help explain retinal conditions, interpret scan results, and provide clinical insights. For specific medical advice, please consult with your ophthalmologist. What would you like to know more about?";
}

// Close upload modal when clicking outside
document.getElementById('uploadOverlay').addEventListener('click', function(e) {
    if (e.target === this) {
        hideUploadModal();
    }
});