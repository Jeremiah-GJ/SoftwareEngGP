//InitialPanel.java
package final_proj;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel
{
  public InitialPanel(InitialControl ic)
  {
    
    JLabel label = new JLabel("Account Information", JLabel.CENTER);
    
    JButton loginButton = new JButton("Login");
    loginButton.addActionListener(ic);
    JPanel loginButtonBuffer = new JPanel();
    loginButtonBuffer.add(loginButton);
    
    JButton createButton = new JButton("Create");
    createButton.addActionListener(ic);
    JPanel createButtonBuffer = new JPanel();
    createButtonBuffer.add(createButton);

    JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
    grid.add(label);
    grid.add(loginButtonBuffer);
    grid.add(createButtonBuffer);
    this.add(grid);
  }
}
