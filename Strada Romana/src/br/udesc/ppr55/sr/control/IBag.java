package br.udesc.ppr55.sr.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.udesc.ppr55.sr.model.Piece;
 
public abstract class IBag {

	protected List<Piece> cubes = new ArrayList<>();
	protected List<Piece> altCubes = new ArrayList<>();
	protected List<Piece> wareTiles = new ArrayList<>();
	protected List<Piece> wagonsRoma = new ArrayList<>();
	protected List<Piece> wagonsPortus = new ArrayList<>();  
	
	protected Random random; 

	/* set wagon pieces to both sides */
	public List<Piece> getWagonsRoma() {
		return wagonsRoma;
	}
	
	public List<Piece> getWagonsPortus() {
		return wagonsPortus;
	}
	
	public List<Piece> getWareTiles() {
		return wareTiles;
	}
	
	public List<Piece> getCubes() {
		return cubes;
	}
	
	public List<Piece> getAltCubes() {
		return altCubes;
	}

	/* access methods */
	public void setWagonRomaList(List<Piece> romaPieces) {
		this.wagonsRoma = romaPieces;
	}
	
	public void setWagonPortusList(List<Piece> portusPieces) {
		this.wagonsPortus = portusPieces;
	}  
	
	public void setWareTileList(List<Piece> wareTiles) {
		this.wareTiles = wareTiles;
	}
	
	public void setCubeList(List<Piece> cubes) {
		this.cubes = cubes;
	}
	
	public void setAltCubeList(List<Piece> altCubes) {
		this.altCubes = altCubes;
	}
	
	public abstract Piece getPortusWagon();
	public abstract Piece getRomaWagon();
	public abstract Piece getWareTile();
	public abstract Piece getCube();
	public abstract Piece getAltCube();
}
