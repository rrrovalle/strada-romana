package br.udesc.ppr55.sr.model.builder;

import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/** Director
 *  @BuilderDirector
 *  @Author Rodrigo Valle
*/
public class EmperorDirector {
	
	private BuildGameTable boardBuilder;
	
	public EmperorDirector(BuildGameTable boardBuilder) {
		this.boardBuilder = boardBuilder;
	}
	
	public void create(AbstractPieceFactory abstractPieceFactory) {
		this.boardBuilder.resetBoard();
		this.boardBuilder.buildStradaBoard(abstractPieceFactory);
	}

}
