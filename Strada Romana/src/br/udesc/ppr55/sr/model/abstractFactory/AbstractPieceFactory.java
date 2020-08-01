package br.udesc.ppr55.sr.model.abstractFactory;

import br.udesc.ppr55.sr.model.Piece; 
import br.udesc.ppr55.sr.model.cubes.CubeType;

/**
 * Abstract Factory for Piece creation
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 */
public abstract class AbstractPieceFactory {
	
	public abstract Piece createBag();  
	
	public abstract Piece createCube(CubeType cubeType);
	
	public abstract Piece createWareTile();
	
	public abstract Piece createContract();

	public abstract Piece createBallioWagon(boolean isRomaSide);
	
	public abstract Piece createCanopitesWagon(boolean isRomaSide);
	
	public abstract Piece createCurculioWagon(boolean isRomaSide);

	public abstract Piece createDemetriusWagon(boolean isRomaSide);
	
	public abstract Piece createHamilcarWagon(boolean isRomaSide);
	
	public abstract Piece createHerenniusWagon(boolean isRomaSide);
	
	public abstract Piece createMaccusWagon(boolean isRomaSide);
	
	public abstract Piece createPersaWagon(boolean isRomaSide);
	
	public abstract Piece createPlotusWagon(boolean isRomaSide);
	
	public abstract Piece createPseudolousWagon(boolean isRomaSide);
	
	//implementar deck para apostas
	public abstract Piece chooseWagon();
}
