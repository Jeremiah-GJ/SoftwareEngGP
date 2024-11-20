//CreateAccountControl.java
package final_proj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class CreateAccountControl implements ActionListener
{
  private JPanel container;
  private ChatClient client;
  
  public CreateAccountControl(JPanel container, ChatClient client)
  {
    this.container = container;
    this.client = client;
  }
  
  public void actionPerformed(ActionEvent ae)
  {
    String command = ae.getActionCommand();

    if (command == "Cancel")
    {
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "1");
    }

    else if (command == "Submit")
    {
      CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
      String username = createAccountPanel.getUsername();
      String password = createAccountPanel.getPassword();
      String passwordVerify = createAccountPanel.getPasswordVerify();

      if (username.equals("") || password.equals(""))
      {
        displayError("You must enter a username and password.");
        return;
      }
      else if (!password.equals(passwordVerify))
      {
        displayError("The two passwords did not match.");
        return;
      }
      if (password.length() < 6)
      {
        displayError("The password must be at least 6 characters.");
        return;
      }
      
      CreateAccountData data = new CreateAccountData(username, password);
      try
      {
        client.sendToServer(data);
      }
      catch (IOException e)
      {
        displayError("Error connecting to the server.");
      }
    }
  }

  public void createAccountSuccess()
  {
    CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
    ClientGUI clientGUI = (ClientGUI)SwingUtilities.getWindowAncestor(createAccountPanel);
    CardLayout cardLayout = (CardLayout)container.getLayout();
    cardLayout.show(container, "4");
  }
  
  public void displayError(String error)
  {
    CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
    createAccountPanel.setError(error);
  }
}
