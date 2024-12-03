// GamePanel.java
package final_proj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static JLabel opponentLabel = new JLabel("Waiting for opponent...");
    private ChatClient client; // Reference to the client for sending messages

    public GamePanel(ChatClient client) {
        this.client = client; // Initialize the client reference

        setLayout(new BorderLayout());
        add(opponentLabel, BorderLayout.NORTH);

        // Add a button to send "PING"
        JButton pingButton = new JButton("Send PING");
        pingButton.addActionListener(e -> {
            try {
                System.out.println("Sending PING to server...");
                client.sendToServer("PING");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        add(pingButton, BorderLayout.SOUTH);
    }

    // Method to update the opponent label
    public static void updateOpponentLabel(String opponent) {
        System.out.println("GamePanel updating opponent label to: " + opponent);
        opponentLabel.setText("Opponent: " + opponent);
    }
}
