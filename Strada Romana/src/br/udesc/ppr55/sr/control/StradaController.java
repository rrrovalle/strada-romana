 /**
 * StradaController Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control;
import br.udesc.ppr55.sr.control.observer.Observer;
import br.udesc.ppr55.sr.model.Audio;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory; 
import br.udesc.ppr55.sr.model.builder.BuildGameTable; 
import br.udesc.ppr55.sr.model.builder.Builder;
import br.udesc.ppr55.sr.model.builder.EmperorDirector;
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.components.WagonTilePortus;
import br.udesc.ppr55.sr.model.components.WagonTileRoma;
import br.udesc.ppr55.sr.model.components.WareSpotTile;
import br.udesc.ppr55.sr.view.PlayerPanel;
 
import java.util.ArrayList;
import java.util.List;
  
import javax.swing.JPanel; 

public class StradaController implements IStradaController {
	 
	private static StradaController instance;
	private EmperorDirector director;
	private Builder builderGameTable;    
	
	private Audio audio;
	private Bag bag;
	
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
    	
    } 
    
    @Override
    public void startGame() {
    	this.addWagon();
    	this.addCubeAndWareTiles();
    	
    	this.notifyStart();
    }
    
    @Override
    public void createPlayerPanel(String n1, String n2) {  
    	players.add(new Player(new PlayerPanel(),n1));
    	players.add(new Player(new PlayerPanel(),n2)); 
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
        this.bag = new Bag();
        this.initializeBoard();    
    } 
    
    @Override 
    public void setRadio(){ 
        this.audio = new Audio("music/Pillars of Eternity II Deadfire Soundtrack 11 - Queen's Berth (Justin Bell) - Rodrigo Valle REMIX.wav");   
        this.audio.playMusic(); 
    }
    
    @Override
    public void notifyPlayerPanelUpdate() {
    	for(Observer observer: observers) {
    		observer.playerPanelUpdate();
    	}
    }
    
    @Override
    public void notifyStart() {
    	for(Observer observer: observers) {
    		observer.boardPanelUpdate();
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
 
    @Override
    public void addWagon() {
        Piece[][] grid = this.builderGameTable.getTable().getGrid();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 17; j++) {
                if (grid[i][j].getClass() == WagonTilePortus.class) {
                    grid[i][j] = bag.getWagon(false, this.factory); 
                } else if (grid[i][j].getClass() == WagonTileRoma.class) {
                    grid[i][j] = bag.getWagon(true, this.factory); 
                } 
            }
        }
    }

    @Override
    public void addCubeAndWareTiles() {
        Piece[][] grid = this.builderGameTable.getTable().getGrid();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 17; j++) {
                if (grid[i][j].getClass() == CubeSpotTile.class) {
                			grid[i][j] = bag.getCubeTile(1, this.factory);
                		} else if (grid[i][j].getClass() == InverseCubeSpot.class){
                			grid[i][j] = bag.getCubeTile(2, this.factory);
			             	} else if(grid[i][j].getClass() == WareSpotTile.class) {
			                    grid[i][j] = bag.getWareTile(this.factory); 
			                } 
            }
        }
    }

	@Override
	public void createCubeTiles() {
		// TODO Auto-generated method stub
		
	}
 
    
}
