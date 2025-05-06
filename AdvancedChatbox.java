import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
public class AdvancedChatbox extends JFrame implements ActionListener {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton, clearButton;
    private JScrollPane scrollPane;
    private Map<String, String> responses;
    public AdvancedChatbox() {
        setTitle("Java AI Chatbot");
        setSize(600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setBackground(new Color(245, 245, 245));
        chatArea.setForeground(Color.DARK_GRAY);
        scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.addActionListener(this);
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));
        sendButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(e -> chatArea.setText(""));
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        initResponses();
        greetUser();
        setVisible(true);
    }
    private void greetUser() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        String greeting;
        if (hour >= 5 && hour < 12) {
            greeting = "Good morning! 😊";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good afternoon! ☀️";
        } else if (hour >= 18 && hour < 22) {
            greeting = "Good evening! 🌆";
        } else {
            greeting = "Hello there, night owl! 🌙";
        }
        chatArea.append("Bot: " + greeting + " How can I help you today?\n");
    }
    private void initResponses() {
        responses = new HashMap<>();
        responses.put("hi", "Hi there!");
        responses.put("hello", "Hello! How can I help you?");
        responses.put("namaste", "Namaste! ");
        responses.put("your name", "I'm JavaBot, your assistant.");
        responses.put("who are you", "I'm your chatbot friend built in Java!");
        responses.put("who created you", "I was coded by a student who's name is ANIKET UJJWAL.");
        responses.put("how are you", "I'm just code, but feeling helpful today!");
        responses.put("i am sad", "I'm here for you. Everything will be okay ");
        responses.put("i am happy", "That's wonderful to hear! ");
        responses.put("help", "Sure, I'm here to help. Ask me anything!");
        responses.put("java", "Java is a robust language. Want project ideas?");
        responses.put("project ideas", "Try these: Chatbot, Resume Ranker, Quiz App, File Encryptor, ToDo App.");
        responses.put("gate", "Prepare DS, Algo, DBMS, CN, TOC, OS. Solve previous year papers.");
        responses.put("joke", "Why did the computer go to the doctor? Because it had a virus!");
        responses.put("tell me something", "Did you know? The first computer bug was an actual moth.");
        responses.put("time pass", "Let's play a word game! Type a word, and I’ll continue with another.");
        responses.put("bye", "Goodbye! Have a productive day.");
        responses.put("see you", "See you later, alligator!");
        responses.put("good night", "Sweet dreams!");
        responses.put("study tips", "Make a schedule, focus on concepts, and take small breaks.");
        responses.put("how to focus", "Try Pomodoro technique: 25 mins study, 5 mins break.");
        responses.put("your qid", "QID = 230303394, Btech CSE student, NAME : - ANIKET UJJWAL");
        responses.put("default", "Hmm... I didn’t get that. Try asking differently.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText().trim().toLowerCase();
        if (!userInput.isEmpty()) {
            chatArea.append("You: " + userInput + "\n");
            inputField.setText("");
            respondToUser(userInput);
        }
    }
    private void respondToUser(String input) {
        String response = null;

        for (String keyword : responses.keySet()) {
            if (input.contains(keyword)) {
                response = responses.get(keyword);
                break;
            }
        }
        if (response == null) {
            response = responses.get("default");
        }
        chatArea.append("Bot: " + response + "\n");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdvancedChatbox());
    }
}

