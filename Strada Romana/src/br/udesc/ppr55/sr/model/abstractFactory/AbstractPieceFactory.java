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
	
	public abstract Piece createCoin();
	
	public abstract Piece createVictoryPoint();
	
	public abstract Piece createBlueCube();
	
	public abstract Piece createBlueWareTile();
	
	public abstract Piece createBlueContract();
	
	public abstract Piece createBrownCube();
	
	public abstract Piece createBrownWareTile();
	
	public abstract Piece createBrownContract();
	
	public abstract Piece createGreenCube();
	
	public abstract Piece createGreenWareTile();
	
	public abstract Piece createGreenContract();
	
	public abstract Piece createRedCube();
	
	public abstract Piece createRedWareTile();
	
	public abstract Piece createRedContract();
	
	public abstract Piece createWhiteCube();
	
	public abstract Piece createWhiteWareTile();
	
	public abstract Piece createWhiteContract();
	
	public abstract Piece createYellowCube();
	
	public abstract Piece createYellowWareTile();
	
	public abstract Piece createYellowContract();
	
	public abstract Piece createBallioWagon(int side);
	
	public abstract Piece createCanopitesWagon(int side);
	
	public abstract Piece createCurculioWagon(int side);

	public abstract Piece createDemetriusWagon(int side);
	
	public abstract Piece createHamilcarWagon(int side);
	
	public abstract Piece createHerenniusWagon(int side);
	
	public abstract Piece createMaccusWagon(int side);
	
	public abstract Piece createPersaWagon(int side);
	
	public abstract Piece createPlotusWagon(int side);
	
	public abstract Piece createPseudolousWagon(int side);
	
	//implementar deck para apostas
}
