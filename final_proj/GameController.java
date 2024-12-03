package final_proj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
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
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton sourceButton = (JButton) e.getSource();
        String buttonName = sourceButton.getName();  // Retrieve button name

        // Handle actions based on the button name
        switch (buttonName) {
        case "add":
            System.out.println("Add button clicked!");
            break;
        case "remove":
            System.out.println("Remove button clicked!");
            break;
        case "H1":
            System.out.println("Card 1 selected!");
            break;
        case "H2":
            System.out.println("Card 2 selected!");
            break;
        case "H3":
            System.out.println("Card 3 selected!");
            break;
        case "H4":
            System.out.println("Card 4 selected!");
            break;
        case "H5":
            System.out.println("Card 5 selected!");
            break;
        case "H6":
            System.out.println("Card 6 selected!");
            break;
        case "draw":
            System.out.println("Draw button clicked!");
            break;
        case "MZ1":
            System.out.println("MZ1 selected!");
            break;
        case "MZ2":
            System.out.println("MZ2 selected!");
            break;
        case "MZ3":
            System.out.println("MZ3 selected!");
            break;
        case "MZB1":
            System.out.println("Summon MZB1!");
            break;
        case "MZB2":
            System.out.println("Summon MZB2!");
            break;
        case "MZB3":
            System.out.println("Summon MZB3!");
            break;
        case "S1S":
            System.out.println("Set S1!");
            break;
        case "S2S":
            System.out.println("Set S2!");
            break;
        case "S3S":
            System.out.println("Set S3!");
            break;
        case "Splay1":
            System.out.println("Play Splay1!");
            break;
        case "Splay2":
            System.out.println("Play Splay2!");
            break;
        case "Splay3":
            System.out.println("Play Splay3!");
            break;
        case "C1Sel":
            System.out.println("Select C1!");
            break;
        case "C2Sel":
            System.out.println("Select C2!");
            break;
        case "C3Sel":
            System.out.println("Select C3!");
            break;
        case "S1Sel":
            System.out.println("Select S1!");
            break;
        case "S2Sel":
            System.out.println("Select S2!");
            break;
        case "S3Sel":
            System.out.println("Select S3!");
            break;
        case "grave":
            System.out.println("Send to Graveyard!");
            break;
        case "banish":
            System.out.println("Send to Banish!");
            break;
        case "cancel":
            System.out.println("Cancel Action!");
            break;
        default:
            System.out.println("Unknown button clicked: " + buttonName);
    }
}
		
	}
	
	
	


      
