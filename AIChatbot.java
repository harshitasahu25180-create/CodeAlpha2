import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AIChatbot extends JFrame {

    // Text area to display conversation
    private JTextArea chatArea;

    // Input field for user's message
    private JTextField inputField;

    // Send button
    private JButton sendButton;

    public AIChatbot() {

        // Window title
        setTitle("AI Chatbot");

        // Window size
        setSize(500, 600);

        // Close program when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add chat area inside scroll pane
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // User input
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Send button
        sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: You can ask me about Java, college, or say hello.\n\n");

        // Button action
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Press Enter to send message
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Make window visible
        setVisible(true);
    }

    // Method to send user message
    private void sendMessage() {

        String userMessage = inputField.getText();

        // Check empty input
        if (userMessage.trim().isEmpty()) {
            return;
        }

        // Display user message
        chatArea.append("You: " + userMessage + "\n");

        // Get bot response
        String response = getResponse(userMessage);

        // Display bot response
        chatArea.append("Bot: " + response + "\n\n");

        // Clear input box
        inputField.setText("");
    }

    // Rule-based chatbot logic
    private String getResponse(String message) {

        // Basic NLP preprocessing
        String text = message.toLowerCase().trim();

        // Greeting
        if (text.contains("hello") ||
            text.contains("hi") ||
            text.contains("hey")) {

            return "Hello! How can I help you?";
        }

        // Name
        else if (text.contains("your name")) {

            return "My name is Java AI Chatbot.";
        }

        // How are you
        else if (text.contains("how are you")) {

            return "I am doing great! Thanks for asking.";
        }

        // Java
        else if (text.contains("java")) {

            return "Java is an object-oriented programming language.";
        }

        // OOP
        else if (text.contains("oop")) {

            return "OOP stands for Object-Oriented Programming. It uses classes and objects.";
        }

        // College
        else if (text.contains("college")) {

            return "College is a great place to learn skills, build projects and prepare for your career.";
        }

        // Programming
        else if (text.contains("programming")) {

            return "Programming means writing instructions that a computer can understand and execute.";
        }

        // Help
        else if (text.contains("help")) {

            return "Sure! Ask me about Java, OOP, programming or college.";
        }

        // Thank you
        else if (text.contains("thank")) {

            return "You're welcome!";
        }

        // Goodbye
        else if (text.contains("bye") ||
                 text.contains("goodbye")) {

            return "Goodbye! Have a great day.";
        }

        // Unknown question
        else {

            return "Sorry, I don't understand that yet. Please ask another question.";
        }
    }

    // Main method
    public static void main(String[] args) {

        new AIChatbot();
    }
}