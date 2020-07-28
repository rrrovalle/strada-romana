package br.udesc.ppr55.sr.view;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9092742548519956717L;

	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setSize(500,500);
		setLayout(gridBagLayout);
		
		setBackground(Color.gray); 
	}
	
}
