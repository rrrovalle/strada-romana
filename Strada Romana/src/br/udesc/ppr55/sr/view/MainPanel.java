package br.udesc.ppr55.sr.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.Observer;

public class MainPanel extends JFrame implements Observer{
	
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = -4789173995438022948L;
	
	/** Panel and controller */
 
    
	/**
	 * Create the player's frame.
	 */
	public MainPanel() {
 
	}

	private void initComponents() {  
	}
	
	private void addComponents() { 
		
		
	}
	
	@Override
	public void boardPanelUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerPanelUpdate() {  
 
	}

	@Override
	public void wagonsPanelUpdate() {

	}

	@Override
	public void showWagons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wareTileUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showWareTiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cubeUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCube() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showWareBag() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffleWagonTiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAlert(String message) {
		// TODO Auto-generated method stub
		
	}
	
}
