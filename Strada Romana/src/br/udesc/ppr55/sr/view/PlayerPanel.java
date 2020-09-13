 /**
 * PlayerPanel Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view; 
import javax.swing.JPanel; 

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.IObserver;
import br.udesc.ppr55.sr.view.command.CommandInvoker;
import br.udesc.ppr55.sr.view.command.stradaCommands.PassPlay; 

import br.udesc.ppr55.sr.model.composite.Card;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel; 
 
public class PlayerPanel extends JPanel implements IObserver {

	private static final long serialVersionUID = 5040820868743358336L;
	
	private JLabel 	lbName;
	private JLabel 	lbScore; 
	private JButton btnPass;
	private JButton btnBag;  
	
	private JDialog playerBag;
	private JPanel panelBag; 
	private JLabel lbCubes;
	private JLabel lbWareTiles;
	private JLabel lbContracts;
	private JLabel lbCoins;
	private JLabel lbVictoryPoints; 
	private JLabel lbCards;
	
	private InterfaceStradaC stradaController;
	private CommandInvoker commandInvoker;
	
	
	public PlayerPanel() {  
		super(); 
		this.setLayout(new BorderLayout(15,15));
		
		this.stradaController = StradaController.getInstance();
		this.commandInvoker = new CommandInvoker();
		stradaController.addObserver(this);
		initializeComponents();
		initPlayerBag();
	} 
	
	public void initializeComponents() {
		lbName = new JLabel(); 
		lbScore = new JLabel("Score: 0"); 
		btnBag = new JButton("Bag"); 
		this.add(lbName, BorderLayout.NORTH);
		this.add(btnBag,BorderLayout.CENTER); 
		
		btnPass = new JButton("Pass"); 
		btnPass.setEnabled(false);
		btnPass.addActionListener((ActionEvent e) -> {
			PassPlay pp = new PassPlay(stradaController);
            commandInvoker.add(pp);
            commandInvoker.execute();
		}); 
		this.add(btnPass, BorderLayout.SOUTH);
		this.add(lbScore, BorderLayout.WEST);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
	
	public void initPlayerBag() {
		panelBag = new JPanel();
		playerBag = new JDialog();
		lbCubes = new JLabel("Cubes:");
		lbWareTiles = new JLabel("Ware Tiles:");
		lbContracts = new JLabel("Contracts:"); 
		lbCoins = new JLabel("Coins:");
		lbVictoryPoints = new JLabel("VP:");
		lbCards = new JLabel("Cards");
		panelBag.add(lbCubes);
		panelBag.add(lbWareTiles);
		panelBag.add(lbContracts); 
		panelBag.add(lbCoins);
		panelBag.add(lbVictoryPoints);
		panelBag.add(lbCards);
		playerBag.add(panelBag); 
		 
		btnBag.addActionListener((ActionEvent e) -> {
			if(!playerBag.isActive()) { 
				playerBag.setTitle(lbName.getText()+" Bag"); 
				playerBag.setSize(250,100);  
				playerBag.setLocationRelativeTo(null);
				playerBag.setResizable(false);
				playerBag.setVisible(true);
			}
		}); 
	} 
	

	
	public void setName(String name) {
		this.lbName.setText("Player: "+name);
	} 
	
    public void update() {
        this.updateUI();
    }  
    
    @Override
    public void openDeckPanel(List<Card> deck) {}

	@Override
	public void playerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts, int cards) {
		this.lbScore.setText("Score:\n"+score); 
		// bag items
		this.lbCoins.setText("Coins: \n"+coins);
		this.lbVictoryPoints.setText("VP: \n"+vp);
		this.lbCubes.setText("Cubes: \n"+cubes); 
		this.lbWareTiles.setText("Ware Tiles: \n"+wareTiles);
		this.lbContracts.setText("Contracts: \n"+contracts); 
		this.lbCards.setText("Cards: \n"+cards); 
	} 
	
	@Override
	public void disableButton(boolean isEnabled) {
		this.btnPass.setEnabled(isEnabled);
	}

	@Override
	public void boardPanelUpdate() {}

	@Override
	public void setPlayerPanel() {}

	@Override
	public void showBag(int size) {}

	@Override
	public void update(boolean isPaused) {}

	@Override
	public void shuffleWagonTiles() {}

	@Override
	public void startGame() {}

	@Override
	public void endGame() {}
	
	@Override
	public void closeDeckPanel() {}
	
	@Override
	public void closeFeaturePanel() {}
	
	@Override
	public void message(String message) {} 
}
