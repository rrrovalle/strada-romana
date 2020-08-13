 /**
 * Bag Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.udesc.ppr55.sr.model.Piece; 

public class Bag  {

	private List<Piece> cubes = new ArrayList<>();
	private List<Piece> altCubes = new ArrayList<>();
	private List<Piece> wareTiles = new ArrayList<>();
	private List<Piece> wagonsRoma = new ArrayList<>();
	private List<Piece> wagonsPortus = new ArrayList<>();  
	
	private Random random;
 
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
	
	/* create pieces */
	public Piece getPortusWagon(){ 
		random = new Random(); 
		Piece p = wagonsPortus.get(random.nextInt(wagonsPortus.size()));  
		wagonsPortus.remove(p);
		return p;
	}
	
	public Piece getRomaWagon(){ 
		random = new Random(); 
		Piece r = wagonsRoma.get(random.nextInt(wagonsRoma.size()));  
		wagonsRoma.remove(r);
		return r;
	}
	 
	
	public Piece getWareTile(){
		random = new Random(); 
		Collections.shuffle(Arrays.asList(wareTiles));
		Piece wt = wareTiles.get(random.nextInt(wareTiles.size()));  
		wareTiles.remove(wt);
		return wt;	
	}
	
	public Piece getCube(){ 
		random = new Random(); 
		Collections.shuffle(Arrays.asList(cubes));
		Piece c = cubes.get(random.nextInt(cubes.size()));  
		cubes.remove(c);
		return c;
	}
	
	public Piece getAltCube(){ 
		random = new Random(); 
		Collections.shuffle(Arrays.asList(altCubes));
		Piece ac = altCubes.get(random.nextInt(altCubes.size()));  
		altCubes.remove(ac);
		return ac;
	}  
}
