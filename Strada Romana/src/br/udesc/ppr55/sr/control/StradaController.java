package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.Observer; 
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame; 

/**
 *
 * @author Rodrigo Valle
 */
public class StradaController implements IStradaController {
	
    // Model and view  
	private JFrame principalFrame;
	
	private static StradaController instance;
    
	// Observer list
	private List<Observer> observers = new ArrayList<>();
 
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
    public void initializePlayerPanel() {    
    }

    @Override
    public void notifyBoardPanelUpdate() {
    }

    @Override
    public void notifyPlayerPanelUpdate() {
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
    public void notifyShowAlert(String message) {
    }
 
 
    
}
