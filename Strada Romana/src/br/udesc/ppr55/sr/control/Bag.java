package br.udesc.ppr55.sr.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.udesc.ppr55.sr.model.Piece;
//Piece controller 
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/**
 * Bag class NA DUVIDA ENTRE SER CONTROLLER OU BUILDER VOU DECIDIR LOGO
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 */
public class Bag  {

	protected List<Piece> cubes = new ArrayList<>();
	protected List<Piece> wareTiles = new ArrayList<>();
	protected List<Piece> wagons = new ArrayList<>(); 
	protected int bagSize = 36;
	 
	public List<Piece> getCubes() {
		return cubes;
	}
 
	public Piece getWagon(boolean isRomaSide, AbstractPieceFactory factory){ 
				Piece[] wagons = {factory.createBallioWagon(isRomaSide), factory.createDemetriusWagon(isRomaSide),
						factory.createCanopitesWagon(isRomaSide), factory.createCurculioWagon(isRomaSide),
						factory.createHamilcarWagon(isRomaSide), factory.createMaccusWagon(isRomaSide),
						factory.createPersaWagon(isRomaSide), factory.createPlotusWagon(isRomaSide),
						factory.createPseudolusWagon(isRomaSide), factory.createHerenniusWagon(isRomaSide)
						}; 
				 
				Collections.shuffle(Arrays.asList(wagons));  
	
				return wagons[1];  
	}
	
	public Piece getWareTile(AbstractPieceFactory factory){
				Piece[] wareTiles = {factory.createBlueWareTile(), factory.createBrownWareTile(),
						factory.createGreenWareTile(), factory.createRedWareTile(),
						factory.createWhiteWareTile(), factory.createYellowWareTile()
						}; 
				
				Collections.shuffle(Arrays.asList(wareTiles));
				return wareTiles[1];
	}
	
	public Piece getCubeTile(int side, AbstractPieceFactory factory){  
			Piece[] cubes = {factory.createBlueCube(side), factory.createBrownCube(side),
					factory.createGreenCube(side), factory.createRedCube(side),
					factory.createWhiteCube(side), factory.createYellowCube(side)
					};
		
		Collections.shuffle(Arrays.asList(cubes));
		return cubes[1];
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
