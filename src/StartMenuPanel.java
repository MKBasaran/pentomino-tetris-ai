import javax.swing.*;
import java.awt.*;

public class StartMenuPanel extends JPanel {

    public StartMenuPanel(MainFrame mainFrame) {
        // Set layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50); // top, left, bottom, right padding

        // Set a Barbie-themed background color
        this.setBackground(Color.PINK);

        // Create and style buttons
        JButton playPlayerButton = new JButton("Play You");
        JButton playBotButton = new JButton("Play Bot");
        JButton playSmartBotButton = new JButton("Play Smart Bot");

        styleButton(playPlayerButton);
        styleButton(playBotButton);
        styleButton(playSmartBotButton);

        playPlayerButton.addActionListener(e -> mainFrame.launchPlayerGame());
        playBotButton.addActionListener(e -> mainFrame.launchBotGame());
        playSmartBotButton.addActionListener(e -> mainFrame.launchSmartBotGame());

        // Add buttons to the panel
        this.add(playPlayerButton, gbc);
        this.add(playBotButton, gbc);
        this.add(playSmartBotButton, gbc);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.PINK); // Hot pink
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        button.setFocusPainted(false);
    }
}