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

        this.setTitle("Chat Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        InitialControl ic = new InitialControl(container, client);
        LoginControl lc = new LoginControl(container, client);
        CreateAccountControl cac = new CreateAccountControl(container, client);

        client.setLoginControl(lc);
        client.setCreateAccountControl(cac);

        JPanel view1 = new InitialPanel(ic);
        JPanel view2 = new LoginPanel(lc);
        JPanel view3 = new CreateAccountPanel(cac);
        JPanel view4 = new ContactsPanel(cardLayout, container); // Pass cardLayout and container

        container.add(view1, "1");
        container.add(view2, "2");
        container.add(view3, "3");
        container.add(view4, "4");

        cardLayout.show(container, "1");

        this.setLayout(new GridBagLayout());
        this.add(container);

        this.setSize(550, 350);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
}
