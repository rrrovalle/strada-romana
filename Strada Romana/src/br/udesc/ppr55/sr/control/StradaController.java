package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.Observer;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.view.PlayerPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 

/**
 *
 * @author Rodrigo Valle
 */
public class StradaController implements IStradaController {
	 
	private static StradaController instance;
    
	private PlayerPanel playerPanel;
	// Observer list
	private List<Observer> observers = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    
    // Singleton pattern
     public static StradaController getInstance() {
        if (instance == null) {
            instance = new StradaController();
        }

        return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.add(observer);
    }
    
    @Override
    public void initializeBoard() {
  
    } 
    
    @Override
    public void setPlayerPanel(int p) { 
			for(int i=0; i<p;i++) {  
				 players.add(new Player(new PlayerPanel(i)));
			}
    }
    
    @Override
    public void initializePlayerPanel(JFrame frame) {
		for(int i=0; i<players.size(); i++) {
			frame.add(players.get(i).getPanel());
			String name = JOptionPane.showInputDialog("Name:");
			players.get(i).getPanel().setName(name);
		}
		notifyPlayerPanelUpdate();
    }

    @Override
    public void notifyBoardPanelUpdate() {
    }

    @Override
    public void notifyPlayerPanelUpdate() {
    	for(Observer observer: observers) {
    		observer.playerPanelUpdate();
    	}
    }

    @Override
    public void notifyWagonsPanelUpdate() {
    }

    @Override
    public void notifyShowWagons() {
    }

    @Override
    public void notifyWareTileUpdate() {
    }

    @Override
    public void notifyShowWareTiles() {
    }

    @Override
    public void notifyCubeUpdate() {
    }

    @Override
    public void notifyShowCube() {
    }

    @Override
    public void notifyShowWareBag() {
    }

    @Override
    public void notifyShuffleWagonTiles() {
    }

    @Override
    public void notifyEndGame() {
    }

    @Override
    public void notifyMessage(String message) {
    	for(Observer observer: observers) {
    		observer.message(message);
    	}
    }
    
    @Override
    public void notifyQuestion(String question) {
    	for(Observer observer: observers) {
    		observer.question(question);
    	}
    }
 
 
    
}
