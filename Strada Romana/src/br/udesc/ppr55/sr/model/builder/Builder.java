 /**
 * Builder Abstract Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.builder; 
import br.udesc.ppr55.sr.control.Bag;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Table;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

public abstract class Builder {
	
	   protected Table table; 
	   protected Bag bag;
	   protected Piece[][] tablePiece; 
 
	    public Table getTable() {
	        return table;
	    } 

	    public void reset() {
	        this.table = new Table();
	    }

	    public void buildStradaBoard(AbstractPieceFactory factory) {
	        this.table.setGrid(tablePiece);
	    } 
	    
	    public abstract void buildWagons(AbstractPieceFactory factory);

	    public abstract void buildGameBag(AbstractPieceFactory factory); 
	     
}
