package br.udesc.ppr55.sr.model.builder; 
 
import java.util.Arrays;
import java.util.Collections; 
 
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

public class BuildGameBag extends Builder {
	
	@Override
	public void buildWagons(AbstractPieceFactory factory) { 
	}

	@Override
	public void buildGameBag(AbstractPieceFactory factory) { 
	tablePiece = new Piece[1][1];
    	
    	Piece[] portusSide = {factory.createBallioWagon(true), factory.createDemetriusWagon(true),
				factory.createCanopitesWagon(true), factory.createCurculioWagon(true),
				factory.createHamilcarWagon(true), factory.createMaccusWagon(true),
				factory.createPersaWagon(true), factory.createPlotusWagon(true),
				factory.createPseudolusWagon(true), factory.createHerenniusWagon(true)
				};
    	
		Piece[] romaSide = {factory.createBallioWagon(false), factory.createDemetriusWagon(false),
				 factory.createCanopitesWagon(false), factory.createCurculioWagon(false),
				 factory.createHamilcarWagon(false), factory.createMaccusWagon(false),
				 factory.createPersaWagon(false), factory.createPlotusWagon(false),
				 factory.createPseudolusWagon(false), factory.createHerenniusWagon(false)
				 };
    	
    	Collections.shuffle(Arrays.asList(romaSide));
		Collections.shuffle(Arrays.asList(portusSide));  
    	
        tablePiece[0][1] = romaSide[1];  
    	
        super.table.setGrid(tablePiece);
	}

	
}
