package br.udesc.ppr55.sr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Bag class
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 */
public class Bag extends Piece {

	protected List<Piece> cubes = new ArrayList<>();
	protected List<Piece> wareTiles = new ArrayList<>();
	protected List<Piece> wagons = new ArrayList<>(); 
	   
	public Bag() {
		super("images/bag.png");
	}

	public List<Piece> getCubes() {
		return cubes;
	}

	public void setCubes(List<Piece> cubes) {
		this.cubes = cubes;
	}

	public List<Piece> getWareTiles() {
		return wareTiles;
	}
	
	public void addCube(Piece cube) {
		cubes.add(cube);	
	}

	public void setWareTiles(List<Piece> wareTiles) {
		this.wareTiles = wareTiles;
	}

	public List<Piece> getWagons() {
		return wagons;
	}

	public void setWagons(List<Piece> wagons) {
		this.wagons = wagons;
	} 
	
}
