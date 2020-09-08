 /**
 * Player Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.model;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.udesc.ppr55.sr.model.composite.Card;
public class Player {
	
    protected String name; 
    protected int moves;
    protected int score;
    protected int gold;
    protected int victoryPoints;
    protected JPanel panelPlayer;
    protected List<Piece> wareTiles;
	protected List<Piece> cubes;
	protected List<String> contracts;
	protected List<String> cards;
	
	protected boolean myTurn;
	
	public Player(JPanel panel, String name){ 
    	this.panelPlayer   = panel; 
    	this.name          = name;
    	this.score         = 0;
    	this.victoryPoints = 0;
    	this.wareTiles     = new ArrayList<>();
    	this.cubes         = new ArrayList<>();
    	this.contracts     = new ArrayList<>();
    	this.cards         = new ArrayList<>();
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getMoves() {
    	return this.moves;
    }
    
    public void setMoves(int moves) {
    	this.moves = moves;
    }
    
    public void setTurn(boolean turn) {
        this.myTurn = turn;
    }
    
    public boolean isMyTurn() {
    	return this.myTurn;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getVPoints() {
        return victoryPoints;
    }
    
    public void setVPoints(int point) {
    	this.victoryPoints += point;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void setGold(int value) { 
    	if(this.gold < 5) {
    		this.gold += value;
    	}else {
        	this.victoryPoints++;
        	this.score++;
        	this.gold = 0;
    	}
    }

    public void setScore(int score) {
        this.score = this.score + score;
    } 
    
    public JPanel getPanel() {
    	return panelPlayer;
    }
    
    public void setPanel(JPanel panel) {
    	this.panelPlayer = panel;
    }
     

	public List<Piece> getWareTiles() {
		return wareTiles;
	}

	public void setWareTiles(Piece wareTile) {
		this.wareTiles.add(wareTile);
		for(int i=0; i<cubes.size(); i++) {  
			if(cubes.get(i).getColor() == wareTile.getColor()) {
				contracts.add(wareTile.getColor());
				cubes.remove(i);
				wareTiles.remove(wareTile);
			}
		}
	}

	public List<Piece> getCubes() {
		return cubes;
	}

	public void setCubes(Piece cube) { 
		this.cubes.add(cube);
		for(int i=0; i<wareTiles.size(); i++) {  
			if(wareTiles.get(i).getColor() == cube.getColor()) {
				contracts.add(cube.getColor());
				wareTiles.remove(i);
				cubes.remove(cube);
			}
		}
	}

	public List<String> getContracts() {
		return contracts;
	}

	public void setContracts(String pieceColor) {
		contracts.add(pieceColor);
	}
	
	public List<String> getCards() {
		return cards;
	}
	
	public void addCard(String card) {
		cards.add(card);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", panelPlayer=" + panelPlayer +", Turn=" + myTurn +"]";
	} 
    
}
