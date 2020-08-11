package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.Observer;
import br.udesc.ppr55.sr.model.Audio;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.model.builder.BuildGameBag;
import br.udesc.ppr55.sr.model.builder.BuildGameTable; 
import br.udesc.ppr55.sr.model.builder.Builder;
import br.udesc.ppr55.sr.model.builder.EmperorDirector; 
import br.udesc.ppr55.sr.view.PlayerPanel;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JOptionPane;
import javax.swing.JPanel; 

/**
 *
 * @author Rodrigo Valle
 */
public class StradaController implements IStradaController {
	 
	private static StradaController instance;
	private EmperorDirector director;
	private Builder builderGameTable;   
	private Builder builderBag; 
	
	private Audio audio; 
	
    private AbstractPieceFactory factory;
	 
	private List<Observer> observers = new ArrayList<>();
	 
    private ArrayList<Player> players = new ArrayList<>();
     
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
        this.builderGameTable = new BuildGameTable();
        this.director = new EmperorDirector(builderGameTable);
        this.director.build(factory);  
	} 
     
    @Override
    public void initializeBag() {
        this.builderBag = new BuildGameBag();
        this.director = new EmperorDirector(builderBag);
        this.director.build(factory); 
    }
    
    @Override
    public void createPlayerPanel(int p) {  
			for(int i=0; i<p;i++) {  
				 String name = JOptionPane.showInputDialog("Name: ");
				 players.add(new Player(new PlayerPanel(),name));
			}    
    }
    
    @Override
    public void initializeRadio() { 
    	this.setRadio(); 
    }

    @Override
    public void restartPlayerPanel(JPanel panel) {
		for(int i=0; i<players.size(); i++) {
			panel.add(players.get(i).getPanel());
			players.get(i).getPanel().setName(players.get(i).getName()); 
		}   
    } 
 
    @Override
    public String getPiece(int col, int row) { 
    	return (builderGameTable.getTable().getGrid()[col][row] == null ? null : builderGameTable.getTable().getGrid()[col][row].getImage());
    }
    
    @Override
    public void notifyBoardPanelUpdate() {
    }
    
    @Override
    public AbstractPieceFactory getFactory() {
        return factory;
    }
    
    @Override
    public void setFactory(PieceFactory pieceFactory) {
        this.factory = pieceFactory;
        this.initializeBoard();   
        this.initializeBag(); 
    } 
    
    @Override 
    public void setRadio(){ 
        this.audio = new Audio("soundtrack/Pillars of Eternity II Deadfire Soundtrack 11 - Queen's Berth (Justin Bell) - Rodrigo Valle REMIX.wav");   
        this.audio.playMusic(); 
    }
    
    @Override
    public void notifyPlayerPanelUpdate() {
    	for(Observer observer: observers) {
    		observer.playerPanelUpdate();
    	}
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
	public void playRadio() {
	    this.audio.play();
	}

	@Override
	public void stopRadio() {
	    this.audio.stop();
	} 
 
 
    
}
