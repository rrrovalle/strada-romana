package br.udesc.ppr55.sr.view;
  
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTable; 

public class BoardPanel extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9092742548519956717L;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public BoardPanel() { 
	    this.table = new JTable(7,17);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
	
	public JTable getTable() {
		return this.table;
	}
}
