import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {
    JLabel maleNameLabel, femaleNameLabel, resultLabel;
    JTextField maleNameField, femaleNameField;
    JButton calculateButton;
    ImageIcon loveEmoji;

    private String maleName, femaleName; // Define instance variables

    public Index() {
        setTitle("Love Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        maleNameLabel = new JLabel("Male Surname:");
        maleNameField = new JTextField();
        femaleNameLabel = new JLabel("Female Surname:");
        femaleNameField = new JTextField();
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        resultLabel = new JLabel();

        loveEmoji = new ImageIcon("love.png");

        add(maleNameLabel);
        add(maleNameField);
        add(femaleNameLabel);
        add(femaleNameField);
        add(calculateButton);
        add(new JLabel());
        add(resultLabel);
        add(new JLabel());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            maleName = maleNameField.getText(); // Assign values to instance variables
            femaleName = femaleNameField.getText();
            int lovePercentage = calculateLove(maleName, femaleName);
            resultLabel.setText("Love Percentage: " + lovePercentage + "%");
            resultLabel.setIcon(loveEmoji);
            if (lovePercentage > 80) {
                JOptionPane.showMessageDialog(null, "Congratulations! You got true love.");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry! You guys are not made for each other.");
            }
        }
    }

    // Define the calculateLove method and put the extra brace at the end of it
    private int calculateLove(String maleName, String femaleName) {
        String combinedNames = (maleName.toLowerCase() + femaleName.toLowerCase());
        int loveScore = 0;
        for (int i = 0; i < combinedNames.length(); i++) {
            char c = combinedNames.charAt(i);
            if (c >= 'a' && c <= 'z') { // Check if character is within range of 'a' to 'z'
                loveScore += c - 'a' + 1; // Add score corresponding to the character
            }
        }
        return loveScore % 101;
    }

    public static void main(String[] args) {
        Index calculator = new Index();
    }
}
