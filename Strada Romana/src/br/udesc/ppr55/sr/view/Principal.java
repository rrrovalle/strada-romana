package br.udesc.ppr55.sr.view;
    
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 

import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.Observer;
  
public class Principal extends JFrame implements Observer{
 
	private static final long serialVersionUID = -5607055001123226547L;
 
    private StradaController stradaController;
 
	/** 
	 * Create the frame.
	 */
	public Principal() { 
		super("Strada Romana");
	    stradaController = StradaController.getInstance(); 
		stradaController.addObserver(this);   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(1500,800);
	    setLocationRelativeTo(null); 
	    
	    setLayout(new FlowLayout());  
	    this.setVisible(true);
	    createPlayersPanel(); 
 
	}
	
	private void initComponents() { 
		
	}
	
	private void createPlayersPanel(){  
		 stradaController.createPlayerPanel(2); 
		 setPlayerPanel(); 
	} 
	
	@Override
	public void setPlayerPanel() {
		stradaController.restartPlayerPanel(null);
		this.setVisible(true);
	}

	@Override
	public void boardPanelUpdate() { 
		
	}

	@Override
	public void playerPanelUpdate() {   
	}

	@Override
	public void wagonsPanelUpdate() {
		// TODO Auto-generated method stub
		
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
	public void message(String message) {
		JOptionPane.showMessageDialog(null,message);
	}
 

}
