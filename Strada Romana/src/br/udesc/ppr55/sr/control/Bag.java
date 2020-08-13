 /**
 * Game Bag Controller Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control;  
import java.util.Arrays;
import java.util.Collections; 
import java.util.Random;

import br.udesc.ppr55.sr.model.Piece; 

public class Bag extends IBag { 
	
	/* create pieces */
	
	@Override
	public Piece getPortusWagon(){ 
		random = new Random(); 
		Piece p = wagonsPortus.get(random.nextInt(wagonsPortus.size()));  
		wagonsPortus.remove(p);
		return p;
	}

	@Override
	public Piece getRomaWagon(){ 
		random = new Random(); 
		Piece r = wagonsRoma.get(random.nextInt(wagonsRoma.size()));  
		wagonsRoma.remove(r);
		return r;
	} 
	
	@Override
	public Piece getWareTile(){
		random = new Random(); 
		Collections.shuffle(Arrays.asList(wareTiles));
		Piece wt = wareTiles.get(random.nextInt(wareTiles.size()));  
		wareTiles.remove(wt);
		return wt;	
	}
	
	@Override
	public Piece getCube(){ 
		random = new Random(); 
		Collections.shuffle(Arrays.asList(cubes));
		Piece c = cubes.get(random.nextInt(cubes.size()));  
		cubes.remove(c);
		return c;
	}
	
	@Override
	public Piece getAltCube(){ 
		random = new Random(); 
		Collections.shuffle(Arrays.asList(altCubes));
		Piece ac = altCubes.get(random.nextInt(altCubes.size()));  
		altCubes.remove(ac);
		return ac;
	}  
}
