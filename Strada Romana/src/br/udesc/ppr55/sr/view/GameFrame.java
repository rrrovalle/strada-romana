package br.udesc.ppr55.sr.view;
 
import java.awt.Color; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;  

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.Observer;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.view.command.CommandInvoker;
import br.udesc.ppr55.sr.view.command.PlayMusicCommand;
import br.udesc.ppr55.sr.view.command.StopMusicCommand;
import br.udesc.ppr55.sr.view.command.WagonFrame; 
 
/**
 * Main frame - build the game
 * @author Rodrigo Valle
 * @Since 27/07/2020
 */
public class GameFrame extends JFrame implements Observer {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 765606884169312925L;
	
	private int status = 0; 
	 
	private JPanel contentPane; 
	private BoardFrame boardFrame;
	private WagonFrame wagonFrame;
	
	private JButton btnRadio;
	private JButton btnClose;
	
	private JButton btnPlayerBag;
	
	private IStradaController stradaController;   
	private CommandInvoker commandInvoker;
	
	public GameFrame() {
		super("Strada Romana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane); 
		contentPane.setBackground(Color.WHITE);
		
		stradaController = StradaController.getInstance();
		stradaController.setFactory(new PieceFactory());
		stradaController.initializeRadio();
		commandInvoker = new CommandInvoker();
		stradaController.addObserver(this);  
		
		playerPanelUpdate();
		initComponents(); 
		addComponents();
		
		super.getContentPane().add(contentPane);
	}	

	public void initComponents() {  	 
		this.contentPane = new JPanel();
	    this.contentPane.setLayout(new GridBagLayout());
	    this.contentPane.setOpaque(true);
	    boardFrame = new BoardFrame(stradaController);    
	}
	
	private void addComponents() {
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 5;
        c.gridheight = 5;
        c.insets = new Insets(0, 0, 0, 40);
        this.contentPane.add(boardFrame, c); 
        
        btnRadio = new JButton("Play Music");
		contentPane.add(btnRadio);
		btnRadio.addActionListener((ActionEvent e) -> {
			  if(status == 0)
			    { 
					PlayMusicCommand msc = new PlayMusicCommand(stradaController); 
	     			commandInvoker.add(msc);
	     			commandInvoker.execute();
			        status = 1; 
			        btnRadio.setText("Turn off");
			    } 
		    else if(status == 1)
		    {
		    	StopMusicCommand smc = new StopMusicCommand(stradaController);
		    	commandInvoker.add(smc);
		    	commandInvoker.execute();
   			
		        status = 0;
		        btnRadio.setText("Play Music");
		    }
		});
		
		btnPlayerBag = new JButton("Game Bag");
		contentPane.add(btnPlayerBag);
 
		btnClose = new JButton("Exit");
		 	c.gridx = 5;
		 	c.gridy = 0;
		 	c.insets = new Insets(0, -135, 5, 0);
		 	this.contentPane.add(btnClose, c); 
		btnClose.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		
		contentPane.setBackground(Color.WHITE);
    } 

	@Override
	public void playerPanelUpdate() {
		stradaController.restartPlayerPanel(contentPane); 	
	}
		 
	@Override
	public void boardPanelUpdate() {  }
 
	@Override
	public void wagonsPanelUpdate() { }

	@Override
	public void showWagons() { }
	
	@Override
	public void wareTileUpdate() { } 

	@Override
	public void showWareTiles() {  
	} 
	
	@Override
	public void cubeUpdate() { } 

	@Override
	public void showCube() { } 
 

	@Override
	public void shuffleWagonTiles() { } 

	@Override
	public void endGame() { } 

	@Override
	public void message(String message) { }

	@Override
	public void update(boolean isPaused) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerPanel() {
		// TODO Auto-generated method stub
		
	} 
	
	
}
