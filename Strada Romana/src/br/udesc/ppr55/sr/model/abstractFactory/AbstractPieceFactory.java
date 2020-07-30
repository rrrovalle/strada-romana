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
	
	public abstract Piece createCube();
	
	public abstract Piece createWareTile();
	
	public abstract Piece createContract();

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
	public abstract Piece chooseWagon();
}
