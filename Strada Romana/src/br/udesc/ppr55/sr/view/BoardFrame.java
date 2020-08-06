package br.udesc.ppr55.sr.view;
  
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer; 

public class BoardFrame extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9092742548519956717L;
	private JTable table;
	private MyRenderer render; 
	
	/**
	 * Create the panel.
	 */
	public BoardFrame() { 
	    this.table = new JTable(7,17); 
	    render = new MyRenderer();
	    ImageIcon icon = new ImageIcon("images/demetriusRoma.png");
	    render.getTableCellRendererComponent(table, icon);  
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    
	    table.getColumnModel().getColumn(6).setCellRenderer(render);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
	public JTable getTable() {
		return this.table;
	}
	
	public class MyRenderer extends DefaultTableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, ImageIcon icon) {

		setIcon(icon);
		this.setSize(50, 50);
		return this;
		}
	}
		
}
