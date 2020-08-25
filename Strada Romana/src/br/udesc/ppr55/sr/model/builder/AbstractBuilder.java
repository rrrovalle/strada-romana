 /**
 * Builder Abstract Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.builder; 
import java.util.List;

import br.udesc.ppr55.sr.control.gameBag.Bag;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Table; 
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

public abstract class AbstractBuilder {
	
	   protected Table table; 
	   protected Piece[][] tablePiece;
	   protected Bag bag;
	   
	   protected List<Piece> wagonsRoma;
	   protected List<Piece> wagonsPortus;
	   protected List<Piece> wareTiles;
	   protected List<Piece> cubes;
	   protected List<Piece> altCubes; 
	   protected List<Piece> wagonsCards;
 
	    public Table getTable() {
	        return table;
	    }  
	    
	    public Bag getBag() {
	    	return bag;
	    }
	    
	    public void reset() {
	        this.table = new Table();
	    }

	    public void buildStradaBoard(AbstractPieceFactory factory) {
	        this.table.setGrid(tablePiece);
	    } 
	    
	    public void buildWagonsCards(AbstractPieceFactory factory) {
	        this.bag.setDeck(wagonsCards);
	    } 
	    
	    public void buildWagonsRoma(AbstractPieceFactory factory) {
	        this.bag.setWagonRomaList(wagonsRoma);
	    } 
	    
	    public void buildWagonsPortus(AbstractPieceFactory factory) {
	        this.bag.setWagonPortusList(wagonsPortus);
	    } 
	    
	    public void buildWareTiles(AbstractPieceFactory factory) {
	    	this.bag.setWareTileList(wareTiles);
	    }
	    
	    public void buildCubes(AbstractPieceFactory factory) {
	    	this.bag.setCubeList(cubes);
	    }
	    
	    public void buildAltCubes(AbstractPieceFactory factory) {
	    	this.bag.setAltCubeList(altCubes);
	    }
	    
}
