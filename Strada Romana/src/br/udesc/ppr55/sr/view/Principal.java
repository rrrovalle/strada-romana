package br.udesc.ppr55.sr.view;
   
import java.awt.EventQueue;
import java.util.ArrayList; 
import java.awt.FlowLayout; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;  

import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.Observer;

import br.udesc.ppr55.sr.model.Player;  
public class Principal extends JFrame implements Observer{
 
	private static final long serialVersionUID = -5607055001123226547L;
	
	private BoardPanel boardPanel;
    private PlayerPanel playerPanel;
    private JPanel mainPanel; 
    
    private ArrayList<Player> players = new ArrayList<>();
     
    private StradaController stradaController;
    /**
	 * Launch the game.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				 new Principal();
			}
		});
	}

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
	    
	    createPlayersPanel(); 
	}
	
	private void initComponents() { 
	}
	
	private void createPlayersPanel(){  
		try{
			int numberOfPlayers = Integer.parseInt(this.question("Please, inform the number of players in this match:"));
				if(numberOfPlayers >=2 && numberOfPlayers <= 5) {
					stradaController.setPlayerPanel(numberOfPlayers); 
				    initializePlayerPanel();
				}else{
					this.message("You should choose between 2~5 players!");
					createPlayersPanel();
				}
			}catch(NumberFormatException ex){
				this.message("An invalid character was found in text content.");
			}
	} 
	
	@Override
	public void initializePlayerPanel() {
		stradaController.initializePlayerPanel(this);
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

	@Override
	public String question(String question) {
		String answer;
		answer = JOptionPane.showInputDialog(null,question);
		return answer;
	}
	


}
