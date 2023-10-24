import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauntedMansionGameSwing {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JButton[] buttons;
    private int gameState;
    private JLabel imageLabel;

    public HauntedMansionGameSwing() {
        gameState = 0;

        frame = new JFrame("Haunted Mansion Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        buttons = new JButton[4];

        textArea = new JTextArea("You find yourself in front of a spooky haunted mansion. Do you dare to enter?");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        imageLabel = new JLabel(new ImageIcon("C:\\Users\\Pradeep Vasudevan\\Documents\\treasure.jpg")); // Add your
                                                                                                         // image file

        buttons[0] = new JButton("Enter the mansion");
        panel.add(buttons[0]);
        buttons[1] = new JButton("Flee away from the mansion");
        panel.add(buttons[1]);
        for (int i = 0; i < 2; i++) {
            final int choice = i + 1;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleChoice(choice);
                }
            });
        }

        frame.add(textArea, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(imageLabel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    private void handleChoice(int choice) {
        if (gameState == 0) {
            if (choice == 1) {
                textArea.setText(
                        "You muster your courage and enter the mansion. Inside, you see a dark hallway. What will you do?");
                buttons[0].setText("Explore the dark hallway");
                buttons[1].setText("Investigate the eerie noise");

                gameState = 1;
            } else if (choice == 2) {
                textArea.setText("You decide not to enter the haunted mansion. Thanks for playing!");
                for (int i = 0; i < 4; i++) {
                    buttons[i].setVisible(false);
                }
            }
        } else if (gameState == 1) {
            if (choice == 1) {
                textArea.setText("You explore the dark hallway and find a dusty bookshelf. What will you do?");
                buttons[0].setText("Examine the books");
                buttons[1].setText("Leave the hallway");

                gameState = 2;
            } else if (choice == 2) {
                textArea.setText("You investigate the eerie noise and find a friendly ghost. What will you do?");
                buttons[0].setText("Chat with the ghost");
                buttons[1].setText("Flee from the ghost");

                gameState = 3;
            }
        } else if (gameState == 2) {
            if (choice == 1) {
                textArea.setText(
                        "As you examine the books, a secret door opens to reveal hidden treasure!\nCongratulations, you found the hidden treasure!");
                for (int i = 0; i < 4; i++) {
                    buttons[i].setVisible(false);
                }
            } else if (choice == 2) {
                textArea.setText(
                        "You decide not to tempt fate and leave the hallway. You continue exploring the mansion and fall in a trap. You lost!");
                for (int i = 0; i < 4; i++) {
                    buttons[i].setVisible(false);
                }

            }
        } else if (gameState == 3) {
            if (choice == 1) {
                textArea.setText(
                        "The friendly ghost shares its story and guides you towards the exit. You've successfully escaped the haunted mansion!");
                for (int i = 0; i < 4; i++) {
                    buttons[i].setVisible(false);
                }
            } else if (choice == 2) {
                textArea.setText(
                        "Your heart starts pounding, you ran away from the ghost and get lost in the mansion slip into a deep hole. You lost!");

                for (int i = 0; i < 4; i++) {
                    buttons[i].setVisible(false);
                }

            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HauntedMansionGameSwing();
            }
        });
    }
}
