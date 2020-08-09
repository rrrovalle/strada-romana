package br.udesc.ppr55.sr.model.builder;

import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Table;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/**
* Builder class
* @Builder
* @author Rodrigo Valle
*/
public abstract class Builder {
	
	   protected Table table; 
	   protected Piece[][] tablePiece;

	    public Builder() { 
 
	    }

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

	    public abstract void buildWareTiles(AbstractPieceFactory factory);

	    public abstract void buildCubes(AbstractPieceFactory factory);
	     
}
