//GamePanel.java
package final_proj;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField LPEdit;
	private JLabel PlayerLP;
	
	/**
	 * Create the panel.
	 */
	public GamePanel(GameController er) {
		setLayout(null);
		
		
/*		
		 PlayerLP = new JLabel();
		
		PlayerLP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PlayerLP.setBounds(0, 395, 92, 40);
		add(PlayerLP);
		
		JButton LPA = new JButton("+");
	LPA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LPA.setBounds(0, 460, 45, 25);
	add(LPA);
	
	LPA.addActionListener(er);
	*/

		//WINDOW SIZE IS 1000x537
setLayout(null);
		
		//Opponent library, graveyard, banish
		ImageIcon OppL = new ImageIcon("path/to/your/image.png");
		ImageIcon Oppgy = new ImageIcon("path/to/your/image.png");
		ImageIcon Oppban = new ImageIcon("path/to/your/image.png");
		
		//Opponent Monster zones
		ImageIcon OMz1 = new ImageIcon("path/to/your/image.png");
		ImageIcon OMz2 = new ImageIcon("path/to/your/image.png");
		ImageIcon OMz3 = new ImageIcon("path/to/your/image.png");
		
		//Opponent spell zones
		ImageIcon OSz1 = new ImageIcon("path/to/your/image.png");
		ImageIcon OSz2 = new ImageIcon("path/to/your/image.png");
		ImageIcon OSz3 = new ImageIcon("path/to/your/image.png");
		
		
		//Player hand
		ImageIcon H1 = new ImageIcon("path/to/your/image.png");
		ImageIcon H2 = new ImageIcon("path/to/your/image.png");
		ImageIcon H3 = new ImageIcon("path/to/your/image.png");
		ImageIcon H4 = new ImageIcon("path/to/your/image.png");
		ImageIcon H5 = new ImageIcon("path/to/your/image.png");
		ImageIcon H6 = new ImageIcon("path/to/your/image.png");
		
		//Player library, graveyard, banish
		ImageIcon PLl = new ImageIcon("path/to/your/image.png");
		ImageIcon Plg = new ImageIcon("path/to/your/image.png");
		ImageIcon Plb = new ImageIcon("path/to/your/image.png");
		
		//Spell zones
		ImageIcon Sz1 = new ImageIcon("path/to/your/image.png");
		ImageIcon Sz2 = new ImageIcon("path/to/your/image.png");
		ImageIcon Sz3 = new ImageIcon("path/to/your/image.png");
		
		//Monster zone
		ImageIcon Mz1 = new ImageIcon("path/to/your/image.png");
		ImageIcon Mz2 = new ImageIcon("path/to/your/image.png");
		ImageIcon Mz3 = new ImageIcon("path/to/your/image.png");
		
		//Currently Selected card
		ImageIcon Sel = new ImageIcon("path/to/your/image.png");
		
		JLabel oppLibrary = new JLabel(OppL);
		oppLibrary.setBounds(10, 10, 61, 86);
		add(oppLibrary);
		
		JLabel oppLibrCount = new JLabel("20");
		oppLibrCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		oppLibrCount.setBounds(74, 10, 28, 25);
		add(oppLibrCount);
		
		JLabel oppLP = new JLabel("4000");
		oppLP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		oppLP.setBounds(890, 4, 92, 40);
		add(oppLP);
		
		JLabel oppGY = new JLabel(Oppgy);
		oppGY.setBounds(10, 114, 45, 73);
		add(oppGY);
		
		JLabel oppBanish = new JLabel(Oppban);
		oppBanish.setBounds(10, 202, 45, 73);
		add(oppBanish);
		
		JLabel PlayerLP = new JLabel("4000");
		PlayerLP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PlayerLP.setBounds(10, 395, 92, 40);
		add(PlayerLP);
		
		LPEdit = new JTextField();
		LPEdit.setBounds(10, 438, 102, 25);
		add(LPEdit);
		LPEdit.setColumns(10);
		
		JButton LPA = new JButton("+");
		LPA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LPA.setBounds(10, 460, 45, 25);
		add(LPA);
		
		JButton LPS = new JButton("-");
		LPS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LPS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LPS.setBounds(67, 462, 45, 23);
		add(LPS);
		
		JLabel PLHand1 = new JLabel(H1);
		PLHand1.setBounds(200, 395, 61, 86);
		add(PLHand1);
		
		JLabel PLHand2 = new JLabel(H2);
		PLHand2.setBounds(271, 395, 61, 86);
		add(PLHand2);
		
		JLabel PLHand3 = new JLabel(H3);
		PLHand3.setBounds(350, 395, 61, 86);
		add(PLHand3);
		
		JLabel PLHand4 = new JLabel(H4);
		PLHand4.setBounds(421, 395, 61, 86);
		add(PLHand4);
		
		JLabel PLHand5 = new JLabel(H5);
		PLHand5.setBounds(492, 395, 61, 86);
		add(PLHand5);
		
		JLabel PLHand6 = new JLabel(H6);
		PLHand6.setBounds(562, 395, 61, 86);
		add(PLHand6);
		
		JButton CancelButton = new JButton("Cancel Action");
		CancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CancelButton.setBounds(641, 454, 131, 37);
		add(CancelButton);
		
		JButton Card1 = new JButton("Select");
		Card1.setName("H1");
		Card1.setBounds(188, 476, 73, 21);
		
		add(Card1);
		
		JButton Card2 = new JButton("Select");
		Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Card2.setBounds(271, 476, 69, 21);
		Card2.setName("H2");
		add(Card2);
		
		JButton Card3 = new JButton("Select");
		Card3.setBounds(342, 476, 73, 21);
		Card3.setName("H3");
		add(Card3);
		
		JButton Card4 = new JButton("Select");
		Card4.setBounds(409, 476, 73, 21);
		Card4.setName("H4");
		add(Card4);
		
		JButton Card5 = new JButton("Select");
		Card5.setBounds(479, 476, 73, 21);
		Card5.setName("H5");
		add(Card5);
		
		JButton Card6 = new JButton("Select");
		Card6.setBounds(550, 476, 73, 21);
		Card6.setName("H6");
		add(Card6);
		
		JLabel PLlibrary = new JLabel(PLl);
		PLlibrary.setBounds(921, 412, 61, 86);
		add(PLlibrary);
		
		JLabel LibrCount = new JLabel("20");
		LibrCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LibrCount.setBounds(883, 438, 28, 25);
		add(LibrCount);
		
		JButton DrawCard = new JButton("Draw ");
		DrawCard.setBounds(844, 476, 73, 21);
		add(DrawCard);
		
		JLabel GY = new JLabel(Plg);
		GY.setBounds(921, 346, 45, 73);
		add(GY);
		
		JLabel Banish = new JLabel(Plb);
		Banish.setBounds(921, 265, 45, 73);
		add(Banish);
		
		JLabel SZ1 = new JLabel(Sz1);
		SZ1.setBackground(new Color(128, 0, 255));
		SZ1.setBounds(211, 299, 61, 86);
		add(SZ1);
		
		JLabel SZ2 = new JLabel(Sz2);
		SZ2.setBackground(new Color(128, 0, 255));
		SZ2.setBounds(377, 299, 61, 86);
		add(SZ2);
		
		JLabel SZ3 = new JLabel(Sz3);
		SZ3.setBackground(new Color(128, 0, 255));
		SZ3.setBounds(530, 299, 61, 86);
		add(SZ3);
		
		JLabel MZ1 = new JLabel(Mz1);
		MZ1.setBackground(new Color(128, 0, 255));
		MZ1.setBounds(211, 195, 61, 86);
		add(MZ1);
		
		JLabel MZ2 = new JLabel(Mz2);
		MZ2.setBackground(new Color(128, 0, 255));
		MZ2.setBounds(377, 195, 61, 86);
		add(MZ2);
		
		JLabel MZ3 = new JLabel(Mz3);
		MZ3.setBackground(new Color(128, 0, 255));
		MZ3.setBounds(530, 195, 61, 86);
		add(MZ3);
		
		JButton Summon = new JButton("Summon");
		Summon.setBounds(117, 228, 92, 21);
		Summon.setName("MZB1");
		add(Summon);
		
		JButton Summon2 = new JButton("Summon");
		Summon2.setBounds(282, 228, 92, 21);
		Summon.setName("MZB2");
		add(Summon2);
		
		JButton Summon3 = new JButton("Summon");
		Summon3.setBounds(447, 228, 80, 21);
		Summon.setName("MZB3");
		add(Summon3);
		
		JButton Sset1 = new JButton("Set");
		Sset1.setBounds(128, 317, 73, 21);
		Sset1.setName("S1S");
		add(Sset1);
		
		JButton Sset2 = new JButton("Set");
		Sset2.setBounds(294, 317, 73, 21);
		Sset2.setName("S2S");
		add(Sset2);
		
		JButton Sset3 = new JButton("Set");
		Sset3.setBounds(447, 317, 73, 21);
		Sset3.setName("S3S");
		add(Sset3);
		
		JButton Splay1 = new JButton("Play");
		Splay1.setBounds(128, 346, 73, 21);
		Splay1.setName("Splay1");
		add(Splay1);
		
		JButton Splay2 = new JButton("Play");
		Splay2.setBounds(294, 346, 73, 21);
		Splay2.setName("Splay2");
		add(Splay2);
		
		JButton Splay3 = new JButton("Play");
		Splay3.setBounds(447, 346, 73, 21);
		Splay1.setName("Splay3");
		add(Splay3);
		
		JLabel OZ1 = new JLabel(OMz1);
		OZ1.setBackground(new Color(128, 0, 255));
		OZ1.setBounds(211, 114, 61, 86);
		add(OZ1);
		
		JLabel OZ2 = new JLabel(OMz2);
		OZ2.setBackground(new Color(128, 0, 255));
		OZ2.setBounds(377, 114, 61, 86);
		add(OZ2);
		
		JLabel OZ3 = new JLabel(OMz3);
		OZ3.setBackground(new Color(128, 0, 255));
		OZ3.setBounds(530, 114, 61, 86);
		add(OZ3);
		
		JLabel OSZ1 = new JLabel(OSz1);
		OSZ1.setBackground(new Color(128, 0, 255));
		OSZ1.setBounds(211, 10, 61, 86);
		add(OSZ1);
		
		JLabel OSZ2 = new JLabel(OSz2);
		OSZ2.setBackground(new Color(128, 0, 255));
		OSZ2.setBounds(377, 10, 61, 86);
		add(OSZ2);
		
		JLabel OSZ3 = new JLabel(OSz3);
		OSZ3.setBackground(new Color(128, 0, 255));
		OSZ3.setBounds(518, 10, 61, 86);
		add(OSZ3);
		
		JButton SelectC1 = new JButton("Select");
		SelectC1.setBounds(129, 254, 72, 21);
		SelectC1.setName("C1Sel");
		add(SelectC1);
		
		JButton SelectC2 = new JButton("Select");
		SelectC2.setBounds(296, 254, 71, 21);
		SelectC2.setName("C2Sel");
		add(SelectC2);
		
		JButton SelectC3 = new JButton("Select");
		SelectC3.setBounds(448, 254, 72, 21);
		SelectC3.setName("C3Sel");
		add(SelectC3);
		
		JButton SelectC2_1 = new JButton("Select");
		SelectC2_1.setBounds(129, 368, 70, 21);
		SelectC2_1.setName("S1Sel");
		add(SelectC2_1);
		
		JButton SelectC2_2 = new JButton("Select");
		SelectC2_2.setBounds(294, 368, 73, 21);
		SelectC2_2.setName("S2Sel");
		add(SelectC2_2);
		
		JButton SelectC2_3 = new JButton("Select");
		SelectC2_3.setBounds(448, 368, 72, 21);
		SelectC2_3.setName("S3Sel");
		add(SelectC2_3);
		
		JButton GYButton = new JButton("Send GY");
		GYButton.setBounds(826, 364, 85, 21);
		add(GYButton);
		
		JButton sendBanish = new JButton("Banish");
		sendBanish.setBounds(826, 317, 85, 21);
		add(sendBanish);
		
		JLabel SelectedCard = new JLabel(Sel);
		SelectedCard.setBounds(810, 54, 143, 221);
		add(SelectedCard);

	}
	
	
	
	 public void updateLabel(String newText) {
		 PlayerLP.setText(newText);
	    }
}


