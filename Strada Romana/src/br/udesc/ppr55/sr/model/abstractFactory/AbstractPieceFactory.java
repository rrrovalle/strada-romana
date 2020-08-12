package br.udesc.ppr55.sr.model.abstractFactory;

import br.udesc.ppr55.sr.model.Piece;  

/**
 * Abstract Factory for Piece creation
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 */
public abstract class AbstractPieceFactory {
	
	public abstract Piece createBag();  
	
	// Cubes
	public abstract Piece createRedCube(int alt);
	public abstract Piece createYellowCube(int alt);
	public abstract Piece createBlueCube(int alt);
	public abstract Piece createGreenCube(int alt);
	public abstract Piece createBrownCube(int alt);
	public abstract Piece createWhiteCube(int alt);
	
	// Ware Tiles
	public abstract Piece createBlueWareTile();
	public abstract Piece createBrownWareTile();
	public abstract Piece createGreenWareTile();
	public abstract Piece createRedWareTile();
	public abstract Piece createWhiteWareTile();
	public abstract Piece createYellowWareTile();
	
	public abstract Piece createContract();
	
	// Wagons 

	public abstract Piece createBallioWagon(boolean isRomaSide);
	
	public abstract Piece createCanopitesWagon(boolean isRomaSide);
	
	public abstract Piece createCurculioWagon(boolean isRomaSide);

	public abstract Piece createDemetriusWagon(boolean isRomaSide);
	
	public abstract Piece createHamilcarWagon(boolean isRomaSide);
	
	public abstract Piece createHerenniusWagon(boolean isRomaSide);
	
	public abstract Piece createMaccusWagon(boolean isRomaSide);
	
	public abstract Piece createPersaWagon(boolean isRomaSide);
	
	public abstract Piece createPlotusWagon(boolean isRomaSide);
	
	public abstract Piece createPseudolusWagon(boolean isRomaSide);
	
	// Pieces of the board
	
	public abstract Piece createGroundTile();
	
	public abstract Piece createStradaTile();
	
	public abstract Piece createWagonTileRoma();
	
	public abstract Piece createWagonTilePortus();

	public abstract Piece createWareSpotTile(int number);
	
	public abstract Piece createCubeSpotTile();
	
	public abstract Piece createLineTile();
	
	public abstract Piece createRomaTile();
	
	public abstract Piece createInverseCubeTile();
	
	//implementar deck para apostas
	public abstract Piece chooseWagon();
}
