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
	public PlayerPanel() {  
		super();
		JLabel btn = new JLabel();
		btn.setIcon(new ImageIcon("C:\\\\Users\\\\Rodrigo Valle\\\\Desktop\\\\Strata Romana\\\\Strada-Romana\\\\Strada Romana\\\\src\\\\images\\\\augusto.png"));
		JLabel name = new JLabel("Mario"); 
		JLabel score = new JLabel("Score: 0");
		this.add(btn);
		this.add(name);
		this.add(score);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
 
 
}
