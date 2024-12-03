package final_proj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.JPanel;
public class GameController implements ActionListener {
    private JPanel container;
    private ChatClient client;

    public GameController(JPanel container, ChatClient client) {
        this.container = container;
        this.client = client;
    }
    
    public void callRec(String s) {
    	 GamePanel gamePanel = (GamePanel) container.getComponent(5);
    	 gamePanel.updateLabel(s);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	    
	    if (command.equals("+"))
	    {
	    	 try {
				client.sendToServer("+");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 
	    
	    }
		
	}
	
	
	

}

      
