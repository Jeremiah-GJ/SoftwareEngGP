package final_proj;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SelectPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public SelectPanel() {
		
		 ImageIcon ch1 = new ImageIcon("path/to/your/image.png");
		 ImageIcon ch2 = new ImageIcon("path/to/your/image.png");
		 ImageIcon ch3 = new ImageIcon("path/to/your/image.png");
		 ImageIcon ch4 = new ImageIcon("path/to/your/image.png");
		 
		setBackground(new Color(128, 0, 255));
		setLayout(null);
		
		JButton Select1 = new JButton("Select");
		Select1.setBounds(82, 109, 98, 30);
		add(Select1);
		
		JButton Select2 = new JButton("Select");
		Select2.setBounds(679, 114, 98, 30);
		add(Select2);
		
		JButton Select3 = new JButton("Select");
		Select3.setBounds(82, 343, 98, 30);
		add(Select3);
		
		JButton Select4 = new JButton("Select");
		Select4.setBounds(679, 348, 98, 30);
		add(Select4);
		
		JLabel Chr1 = new JLabel(ch1);
		Chr1.setBounds(82, 29, 98, 70);
		add(Chr1);
		
		JLabel Chr2 = new JLabel(ch2);
		Chr2.setBounds(679, 29, 98, 70);
		add(Chr2);
		
		JLabel Chr3 = new JLabel(ch3);
		Chr3.setBounds(82, 257, 98, 70);
		add(Chr3);
		
		JLabel Chr4 = new JLabel(ch4);
		Chr4.setBounds(679, 257, 98, 70);
		add(Chr4);

	}
}
