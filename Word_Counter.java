import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Word_Counter extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JTextArea textArea;
    private JButton submit;
    private JLabel result;

    public Word_Counter() {
        setTitle("Word Counter");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Word Counter Application");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        textArea.setSize(800, 200);
        textArea.setLocation(50, 100);
        textArea.setLineWrap(true);
        c.add(textArea);

        submit = new JButton("Count Words");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(200, 20);
        submit.setLocation(350, 320);
        submit.addActionListener(this);
        c.add(submit);

        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(500, 25);
        result.setLocation(50, 360);
        c.add(result);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        String[] words = text.trim().split("\\s+");
        result.setText("Words Counted: " + words.length);
    }

    public static void main(String[] args) {
        Word_Counter f = new Word_Counter();
        f.setVisible(true);
    }
}