import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener {
    JLabel maleNameLabel, femaleNameLabel, resultLabel;
    JTextField maleNameField, femaleNameField;
    JButton calculateButton;
    ImageIcon loveEmoji;

    public index() {
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
            String maleName = maleNameField.getText();
            String femaleName = femaleNameField.getText();
            int lovePercentage = calculateLove(maleName, femaleName);
            resultLabel.setText("Love Percentage: " + lovePercentage + "%");
            resultLabel.setIcon(loveEmoji);
            if (lovePercentage > 60) {
                JOptionPane.showMessageDialog(null, "Congratulations! You got true love.");
            } else {
                JOptionPane.showMessageDialog(null, "Soryy! You guys are not made for each other.");
            }
        }
    }
        }
        String combinedNames = (maleName + femaleName).toLowerCase();
        int loveScore = 0;
        for (int i = 0; i < combinedNames.length(); i++) {
            loveScore += combinedNames.charAt(i);
        }
        return loveScore % 101;
    }

    public static void main(String[] args) {
        index calculator = new index();
    }
}

