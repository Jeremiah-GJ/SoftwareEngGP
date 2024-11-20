// ContactsPanel.java
package final_proj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactsPanel extends JPanel {
    private JButton logoutButton;
    private CardLayout cardLayout;
    private JPanel container;

    public ContactsPanel(CardLayout cardLayout, JPanel container) {
        this.cardLayout = cardLayout;
        this.container = container;

        DefaultListModel<String> list = new DefaultListModel<String>();
        list.addElement("Person One");
        list.addElement("<html><b>Person Two</b></html>");
        list.addElement("Person Three");
        list.addElement("Person Four");
        list.addElement("<html><b>Person Five</b></html>");
        list.addElement("Person Six");
        list.addElement("<html><b>Person Seven</b></html>");
        list.addElement("<html><b>Person Eight</b></html>");
        list.addElement("Person Nine");

        this.setLayout(new BorderLayout());

        JLabel label = new JLabel("Contacts", JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        JList<String> contactList = new JList<String>(list);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactList.setLayoutOrientation(JList.VERTICAL);
        contactList.setVisibleRowCount(-1);
        contactList.setPreferredSize(new Dimension(300, 200));
        contactList.setFont(contactList.getFont().deriveFont(Font.PLAIN));
        JPanel contactListBuffer = new JPanel();
        contactListBuffer.add(contactList);
        this.add(contactListBuffer, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new BorderLayout());
        JPanel contactButtons = new JPanel();
        JButton deleteButton = new JButton("Delete Contact");
        JButton addButton = new JButton("Add Contact");
        contactButtons.add(deleteButton);
        contactButtons.add(addButton);
        buttonsPanel.add(contactButtons, BorderLayout.NORTH);

        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(new LogoutButtonListener());
        JPanel logoutButtonBuffer = new JPanel();
        logoutButtonBuffer.add(logoutButton);
        buttonsPanel.add(logoutButtonBuffer, BorderLayout.SOUTH);
        
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    private class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(container, "1");
        }
    }
}
