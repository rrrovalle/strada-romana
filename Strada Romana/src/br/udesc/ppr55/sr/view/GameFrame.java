package br.udesc.ppr55.sr.view;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.Observer;
 
public class GameFrame extends JFrame implements Observer {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 765606884169312925L;
	
	private JPanel contentPane; 
	private BoardFrame boardFrame;
	
	private JButton btnRestart;
	private JButton btnPlayerBag;
	
	private IStradaController stradaController;   
	
	public GameFrame() {
		super("Strada Romana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 1350, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		stradaController = new StradaController();
		stradaController.addObserver(this);  
		 
		setPlayerPanel();
		initComponents(); 
	}

	public void initComponents() {  	   
		boardFrame = new BoardFrame();
		contentPane.add(boardFrame.getTable()); 
		
		btnRestart = new JButton("Restart");
		contentPane.add(btnRestart);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			 System.exit(0);
			}
		});
		
		btnPlayerBag = new JButton("Game Bag");
		contentPane.add(btnPlayerBag);
	}

	public void setPlayerPanel() { 
		 stradaController.createPlayerPanel(2);  
		 playerPanelUpdate(); 
	}

	@Override
	public void playerPanelUpdate() {
		stradaController.restartPlayerPanel(contentPane); 
	}  

	@Override
	public void boardPanelUpdate() { 
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
		// TODO Auto-generated method stub
		
	} 
	
}
