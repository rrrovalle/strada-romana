/**
* Main frame - build the game
* @author Rodrigo Valle e Robson de Jesus
* @since 12/08/2020
* @version 1.0
*/

package br.udesc.ppr55.sr.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.udesc.ppr55.sr.model.composite.Card;
import java.util.List;
import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.control.observer.IObserver;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.view.command.CommandInvoker;
import br.udesc.ppr55.sr.view.command.stradaCommands.ChooseCardCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.EndTurnCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.FulfilPiecesCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.PlayMusicCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.SpecialMoveCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.StartGameCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.StopMusicCommand;

import java.awt.Dimension;

public class GameFrame extends JFrame implements IObserver {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 765606884169312925L;

	private int status = 0;

	private JPanel contentPane;
	private JPanel panelDeck;
	private JPanel panelMoves;
	private JDialog deckDialog;
	private JDialog movesDialog;
	private BoardFrame boardFrame;

	private JButton btnRadio;
	private JButton btnStart;
	private JButton btnClose;
	private JButton btnMove;
	private JButton btnEndTurn;

	private JButton btnPlayerBag;

	private InterfaceStradaC stradaController;

	private CommandInvoker commandInvoker;
	private StartGameCommand sgc;
	private EndTurnCommand etc;
	private StopMusicCommand smc;
	private FulfilPiecesCommand fpc;
	private ChooseCardCommand ccc;
	private SpecialMoveCommand smcmm; 

	public GameFrame() {
		super("Strada Romana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.GRAY);

		stradaController = StradaController.getInstance();
		stradaController.setFactory(new PieceFactory());
		stradaController.initializeRadio();
		commandInvoker = new CommandInvoker();
		stradaController.addObserver(this);

		setScreenSize(stradaController.getScreenSize());
		setPlayerPanel();
		initComponents();
		addComponents();

		super.getContentPane().add(contentPane);
	}

	public void setScreenSize(int tam) {
		if (tam == 50) {
			this.setSize(new Dimension(1050, 750));
			this.setUndecorated(true);
			this.setLocationRelativeTo(null);
		} else if (tam == 100) {
			this.setSize(new Dimension(1920, 1080));
			this.setUndecorated(true);
			this.setLocationRelativeTo(null);
		}
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
			if (status == 0) {
				PlayMusicCommand msc = new PlayMusicCommand(stradaController);
				commandInvoker.add(msc);
				commandInvoker.execute();
				status = 1;
				btnRadio.setText("Turn off");
			} else if (status == 1) {
				smc = new StopMusicCommand(stradaController);
				commandInvoker.add(smc);
				commandInvoker.execute();

				status = 0;
				btnRadio.setText("Play Music");
			}
		});

		btnPlayerBag = new JButton("Game Bag");
		btnPlayerBag.setEnabled(false);
		btnPlayerBag.addActionListener((ActionEvent e) -> {
			fpc = new FulfilPiecesCommand(stradaController);
			commandInvoker.add(fpc);
			commandInvoker.execute();
		});
		contentPane.add(btnPlayerBag);

		btnEndTurn = new JButton("End Turn");
		btnEndTurn.setEnabled(false);
		btnEndTurn.addActionListener((ActionEvent e) -> {
			etc = new EndTurnCommand(stradaController);
			commandInvoker.add(etc);
			commandInvoker.execute();
		});
		contentPane.add(btnEndTurn);

		btnStart = new JButton("Start");
		contentPane.add(btnStart);
		btnStart.addActionListener((ActionEvent e) -> {
			sgc = new StartGameCommand(stradaController);
			commandInvoker.add(sgc);
			commandInvoker.execute();
		}); 
        
		btnMove = new JButton("Shop");
		c.gridx = 4;
		c.gridy = 0;
		c.insets = new Insets(0, -150, 5, 0);
		contentPane.add(btnMove,c);
		btnMove.addActionListener((ActionEvent e) -> {
			initializeMovesDeck();
		});
		
		btnClose = new JButton("Exit");
		c.gridx = 5;
		c.gridy = 0;
		c.insets = new Insets(0, -135, 5, 0);
		this.contentPane.add(btnClose, c);
		btnClose.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		contentPane.setBackground(Color.GRAY);
	}

	public void initializeDeckBag(List<Card> deck) {
		panelDeck  = new JPanel();
		deckDialog = new JDialog();
		
		for(int i=0; i<deck.size(); i++) { 
			JButton b = new JButton(new ImageIcon(deck.get(i).getCard())); 
			b.setName(deck.get(i).getName());
			b.addActionListener((ActionEvent e)->{
				ccc = new ChooseCardCommand(stradaController, b.getName());
				commandInvoker.add(ccc);
				commandInvoker.execute(); 
			});
			panelDeck.add(b);
		}  
		 
		deckDialog.add(panelDeck);
		
		deckDialog.setTitle("Wagon's Deck"); 
		deckDialog.setSize(500,400);  
		deckDialog.setLocationRelativeTo(null);
		deckDialog.setResizable(false);
		deckDialog.setVisible(true);
	}
	
	public void initializeMovesDeck() {
		panelMoves  = new JPanel();
		movesDialog = new JDialog();
		movesDialog.add(panelMoves);
		
		String[] moves = {"Sideways Move - 1 Gold","Diagonal Move - 2 Gold","Extra Move - 3 Gold", "Staking - 4 Gold"};
		for(int i=0; i<moves.length;i++) {
			JButton b = new JButton(moves[i]); 
			b.setName(Integer.toString(i+1));
			b.addActionListener((ActionEvent e)->{ 
				smcmm = new SpecialMoveCommand(stradaController, Integer.parseInt(b.getName()));
				commandInvoker.add(smcmm);
				commandInvoker.execute();
			});
			panelMoves.add(b);
		}
		movesDialog.setTitle("Special Moves"); 
		movesDialog.setSize(200,170);  
		movesDialog.setLocationRelativeTo(null);
		movesDialog.setResizable(false);
		movesDialog.setVisible(true);
	}

	@Override
	public void playerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts, int cards) {
	}

	@Override
	public void boardPanelUpdate() {
		this.boardFrame.updateUI();
	}

	@Override
	public void showBag(int size) {
		btnPlayerBag.setEnabled(true);
		btnPlayerBag.setText("Reroll bag (" + size + ")");
	}

	@Override
	public void shuffleWagonTiles() {
	}

	@Override
	public void startGame() {
		btnStart.setEnabled(false);
		btnEndTurn.setEnabled(true);
	}

	@Override
	public void endGame() {
		btnStart.setEnabled(true);
		btnEndTurn.setEnabled(false);
	}

	@Override
	public void message(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void update(boolean isPaused) {
	}

	@Override
	public void setPlayerPanel() {
		stradaController.restartPlayerPanel(contentPane);
	}

	@Override
	public void disableButton(boolean turn) {
	}

	@Override
	public void openDeckPanel(List<Card> deck) {
		this.initializeDeckBag(deck);
	}
	
	@Override
	public void closeDeckPanel() {
		this.deckDialog.setVisible(false);
	}
	
	@Override
	public void closeFeaturePanel() {
		this.movesDialog.setVisible(false);
	}
}
