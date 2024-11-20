//InitialControl.java
package final_proj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialControl implements ActionListener
{
  private JPanel container;
  private ChatClient client;
  public InitialControl(JPanel container, ChatClient client)
  {
    this.container = container;
    this.client = client;
  }
  
  public void actionPerformed(ActionEvent ae)
  {
    String command = ae.getActionCommand();
    
    if (command.equals("Login"))
    {
      LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
      loginPanel.setError("");
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "2");
     
    }
    
    else if (command.equals("Create"))
    {
      CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
      createAccountPanel.setError("");
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "3");
    }
  }
}
