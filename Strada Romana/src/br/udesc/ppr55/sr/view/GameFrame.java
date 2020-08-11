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
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.view.command.CommandInvoker;
import br.udesc.ppr55.sr.view.command.PlayMusicCommand;
import br.udesc.ppr55.sr.view.command.StopMusicCommand; 
 
public class GameFrame extends JFrame implements Observer {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 765606884169312925L;
	
	private int status = 0; 
	 
	private JPanel contentPane; 
	private BoardFrame boardFrame;
	
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
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		stradaController = new StradaController();
		stradaController.setFactory(new PieceFactory());
		stradaController.initializeRadio();
		commandInvoker = new CommandInvoker();
		stradaController.addObserver(this);  
		 
		setPlayerPanel();
		initComponents(); 
	}	

	public void initComponents() {  	  
		boardFrame = new BoardFrame(stradaController);
		contentPane.add(boardFrame); 
	
	}

	public void setPlayerPanel() { 
		 stradaController.createPlayerPanel(2);  
		 playerPanelUpdate(); 
	}

	@Override
	public void playerPanelUpdate() {
		stradaController.restartPlayerPanel(contentPane); 
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
		
		btnClose = new JButton("Exit");
		contentPane.add(btnClose);
		btnClose.addActionListener((ActionEvent e) -> {
			this.dispose();
		});
		
		btnPlayerBag = new JButton("Game Bag");
		contentPane.add(btnPlayerBag);
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
	public void showWareTiles() { } 
	
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
	
	
}
