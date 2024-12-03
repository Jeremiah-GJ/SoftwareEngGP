//SelectPanel.java
package final_proj;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

// Correct class definition
public class SelectPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String selectedDeck;
    private ChatClient chatClient; // Moved inside the class

    public SelectPanel(CardLayout cardLayout, JPanel container, ChatClient chatClient) {
        this.chatClient = chatClient; // Initialize the ChatClient
        setBackground(Color.DARK_GRAY);
        setLayout(new GridLayout(2, 2, 20, 20));

        // Deck information
        String[] deckNames = {"Yugi", "Joey", "Kaiba", "Weevil"};
        String[] imagePaths = {
                "/final_proj/Yugi_Portrait.png",
                "/final_proj/Joey_Portrait.png",
                "/final_proj/Kaiba_Portrait.png",
                "/final_proj/Weevil_Portrait.png"
        };

        for (int i = 0; i < deckNames.length; i++) {
            JPanel deckPanel = new JPanel(new BorderLayout());
            deckPanel.setBackground(Color.DARK_GRAY);

            URL imageURL = getClass().getResource(imagePaths[i]);
            JLabel characterLabel;
            if (imageURL != null) {
                ImageIcon characterImage = new ImageIcon(imageURL);
                characterImage = scaleImageIcon(characterImage, 200, 200);
                characterLabel = new JLabel(characterImage);
            } else {
                System.out.println("Image not found: " + imagePaths[i]);
                characterLabel = new JLabel("Image not found");
                characterLabel.setForeground(Color.WHITE);
            }
            characterLabel.setHorizontalAlignment(JLabel.CENTER);
            deckPanel.add(characterLabel, BorderLayout.CENTER);

            JButton selectButton = new JButton("Select");
            final String deckName = deckNames[i];
            selectButton.addActionListener(e -> {
                selectedDeck = deckName;

                // Send the selected deck to the server
                if (chatClient != null) {
                    chatClient.sendMessage("DeckSelected:" + selectedDeck);
                }

                System.out.println("Selected Deck: " + selectedDeck);
                cardLayout.show(container, "GamePanel");
            });
            deckPanel.add(selectButton, BorderLayout.SOUTH);

            add(deckPanel);
        }

        setPreferredSize(new Dimension(1000, 800));
    }

    private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public String getSelectedDeck() {
        return selectedDeck;
    }
}


