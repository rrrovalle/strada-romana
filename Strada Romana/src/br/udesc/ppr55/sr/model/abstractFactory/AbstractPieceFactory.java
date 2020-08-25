 /**
 * Abstract Factory for Piece creation
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.abstractFactory;
import br.udesc.ppr55.sr.model.Piece; 

public abstract class AbstractPieceFactory {  
	
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
	
	// Wagons  
	public abstract Piece createBallioWagon(int side); 
	public abstract Piece createCanopitesWagon(int side); 
	public abstract Piece createCurculioWagon(int side);
	public abstract Piece createDemetriusWagon(int side);
	public abstract Piece createHamilcarWagon(int side);
	public abstract Piece createHerenniusWagon(int side);
	public abstract Piece createMaccusWagon(int side);
	public abstract Piece createPersaWagon(int side);
	public abstract Piece createPlotusWagon(int side);
	public abstract Piece createPseudolusWagon(int side);
	
	// Pieces of the board 
	public abstract Piece createGroundTile(); 
	public abstract Piece createDeckTile(); 
	public abstract Piece createStradaTile(); 
	public abstract Piece createWagonTileRoma(); 
	public abstract Piece createWagonTilePortus(); 
	public abstract Piece createWareSpotTile(int number); 
	public abstract Piece createCubeSpotTile(); 
	public abstract Piece createLineTile(); 
	public abstract Piece createRomaTile(); 
	public abstract Piece createInverseCubeTile();
	
	// Wagons deck of cards
	public abstract Piece createDeck();
	public abstract Piece createSpqrCard();
	public abstract Piece createCard(int number);
}
