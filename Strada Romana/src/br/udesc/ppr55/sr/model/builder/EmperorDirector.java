 /**
 * EmperorDirector Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.builder;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

public class EmperorDirector {
	
	private Builder builder;

    public EmperorDirector(Builder builder) {
        this.builder = builder;
    }

    public void build(AbstractPieceFactory abstractPieceFactory) {
        builder.reset();
        builder.buildStradaBoard(abstractPieceFactory);     
        builder.buildWagonsRoma(abstractPieceFactory);
        builder.buildWagonsPortus(abstractPieceFactory);
        builder.buildWareTiles(abstractPieceFactory);
        builder.buildCubes(abstractPieceFactory);
        builder.buildAltCubes(abstractPieceFactory);
    }

}
