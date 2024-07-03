import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame 
{
    private JTextArea textArea;
    private JButton wordCountButton;
    private JButton charCountButton;
    private JButton sentenceCountButton;
    private JButton readingTimeButton;
    private JButton longestWordButton;
    private JButton clearButton;
    private JLabel resultLabel;

    public WordCounter() 
    {
         
        setTitle("Word Counter");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

         
        textArea = new JTextArea("Write Your Message Here...");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);

        wordCountButton = createStyledButton("Word Count");
        charCountButton = createStyledButton("Character Count");
        sentenceCountButton = createStyledButton("Sentence Count");
        readingTimeButton = createStyledButton("Reading Time");
        longestWordButton = createStyledButton("Longest Word");
        clearButton = createStyledButton("Clear");

        resultLabel = new JLabel("Results will be shown here.");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 35));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.YELLOW);
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        resultLabel.setPreferredSize(new Dimension(resultLabel.getWidth(), 80)); // Increased height
         
        setLayout(new BorderLayout(10, 10));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(wordCountButton);
        buttonPanel.add(charCountButton);
        buttonPanel.add(sentenceCountButton);
        buttonPanel.add(readingTimeButton);
        buttonPanel.add(longestWordButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.SOUTH);

         
        wordCountButton.addActionListener(e -> showWordCount());
        charCountButton.addActionListener(e -> showCharCount());
        sentenceCountButton.addActionListener(e -> showSentenceCount());
        readingTimeButton.addActionListener(e -> showReadingTime());
        longestWordButton.addActionListener(e -> showLongestWord());
        clearButton.addActionListener(e -> clearText());
    }

     
    private JButton createStyledButton(String text) 
    {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setFocusPainted(false);
        button.setBackground(new Color(255, 255, 0));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(150, 60)); // Set button size
        return button;
    }

     
    private void showWordCount() 
    {
        String text = textArea.getText().trim();
        int count = text.isEmpty() ? 0 : text.split("\\s+").length;
        resultLabel.setText("Word Count: " + count);
    }

    
    private void showCharCount() 
    {
        String text = textArea.getText();
        int count = text.length();
        int countWithoutSpaces = text.replace(" ", "").length();
        resultLabel.setText("Character Count: " + count + " (" + countWithoutSpaces + " without spaces)");
    }

    
    private void showSentenceCount() 
    {
        String text = textArea.getText().trim();
        int count = text.isEmpty() ? 0 : text.split("[.!?]").length;
        resultLabel.setText("Sentence Count: " + count);
    }

     
    private void showReadingTime() 
    {
        String text = textArea.getText().trim();
        int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;
        int readingTime = (int) Math.ceil(wordCount / 200.0); // Average reading speed: 200 words per minute
        resultLabel.setText("Estimated Reading Time: " + readingTime + " min");
    }

    
    private void showLongestWord() 
    {
        String text = textArea.getText().trim();
        String[] words = text.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) 
            {
                longestWord = word;
            }
        }
        resultLabel.setText("Longest Word: " + (longestWord.isEmpty() ? "N/A" : longestWord));
    }

     
    private void clearText() 
    {
        textArea.setText("");
        resultLabel.setText("Results will be shown here.");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            new WordCounter().setVisible(true);
        });
    }
}