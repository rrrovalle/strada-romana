package br.udesc.ppr55.sr.model.builder;

import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/** Director
 *  @BuilderDirector
 *  @Author Rodrigo Valle
*/
public class EmperorDirector {
	
	private Builder builder;

    public EmperorDirector(Builder builder) {
        this.builder = builder;
    }

    public void build(AbstractPieceFactory abstractPieceFactory) {
        builder.reset();
        builder.buildStradaBoard(abstractPieceFactory); 
        builder.buildWagons(abstractPieceFactory);
    }

}
