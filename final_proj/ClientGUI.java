//ClientGUI.java

package final_proj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame {

    public ClientGUI() {
        ChatClient client = new ChatClient();
        client.setHost("localhost");
        client.setPort(8300);
        try {
            client.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setTitle("Yu-Gi-Oh Deck Selector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        InitialControl ic = new InitialControl(container, client);
        LoginControl lc = new LoginControl(container, client);
        CreateAccountControl cac = new CreateAccountControl(container, client);
        GameController gc = new GameController(container, client);

        client.setLoginControl(lc);
        client.setCreateAccountControl(cac);

        JPanel view1 = new InitialPanel(ic);
        JPanel view2 = new LoginPanel(lc);
        JPanel view3 = new CreateAccountPanel(cac);
        JPanel view4 = new SelectPanel(cardLayout, container, client);

        // Create the larger GamePanel with a bigger preferred size
        JPanel gamePanel = new GamePanel(gc);
        gamePanel.setPreferredSize(new Dimension(1200, 800)); // Larger GamePanel size

        container.add(view1, "1");
        container.add(view2, "2");
        container.add(view3, "3");
        container.add(view4, "4");
        container.add(gamePanel, "5"); // Add GamePanel to the card layout

        cardLayout.show(container, "1");

        this.setLayout(new GridBagLayout());
        container.setSize(1200, 800);
        this.add(container);

        // Set frame size to match the default size of other panels
        this.setSize(1200, 800); // Default dimensions
        this.setResizable(false); // Disable resizing for consistent appearance

        // Add a component listener to dynamically resize the frame when showing GamePanel
        gamePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                setSize(1200, 800);
                setResizable(false); // Prevent resizing during gameplay
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
}



