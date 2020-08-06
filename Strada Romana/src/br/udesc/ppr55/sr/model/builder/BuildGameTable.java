 package br.udesc.ppr55.sr.model.builder;

import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/**
 * Concrete builder to create the board
 * @Builder
 * @author Rodrigo Valle
 */
public class BuildGameTable extends Builder {
	 
    @Override
    public void buildStradaBoard(AbstractPieceFactory factory) {
    	board = new Piece[7][17];
    	 
    }

}
