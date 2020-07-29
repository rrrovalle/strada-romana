package br.udesc.ppr55.sr.view;
 
import javax.swing.JPanel; 

import java.awt.Color;

import javax.swing.BorderFactory; 
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5040820868743358336L;

	/**
	 * Create the panel.
	 */
	private JLabel lbName;
	private JLabel lbScore;
	private JLabel lbIcon;
	
	public PlayerPanel(int icon) {  
		super();
		lbIcon = new JLabel("");
		lbIcon.setIcon(new ImageIcon("C:\\\\Users\\\\Rodrigo Valle\\\\Desktop\\\\Strata Romana\\\\Strada-Romana\\\\Strada Romana\\\\src\\\\images\\\\"+icon+".png"));
		lbName = new JLabel(""); 
		lbScore = new JLabel("Score: 0");
		this.add(lbIcon);
		this.add(lbName);
		this.add(lbScore);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
	
	public void setName(String name) {
		this.lbName.setText(name);
	}  
 
}
