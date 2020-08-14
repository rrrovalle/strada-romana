 /**
 * Game Bag Controller Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control;  

import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.wagons.faceDownWagon; 

public class Bag extends AbstractBag { 
	
	/* create pieces */ 
	@Override
	public Piece getPortusWagon(){
		shuffle(wagonsPortus);
		Piece p = wagonsPortus.get(random.nextInt(wagonsPortus.size()));  
		wagonsPortus.remove(p); 
		bagSize--;
		return p;
	}

	@Override
	public Piece getRomaWagon(){ 
		shuffle(wagonsRoma);
		Piece r = wagonsRoma.get(random.nextInt(wagonsRoma.size()));  
		wagonsRoma.remove(r); 
		bagSize--;
		return r;
	} 

	// starts the first turn with 30 ware tiles
	@Override
	public Piece getWareTile(){
		shuffle(wareTiles);
		Piece wt = wareTiles.get(random.nextInt(wareTiles.size()));  
		wareTiles.remove(wt);
		bagSize--;
		return wt;	
	}
	
	// starts the first turn with 22 cubes
	@Override
	public Piece getCube(){ 
		shuffle(cubes);
		Piece c = cubes.get(random.nextInt(cubes.size()));  
		cubes.remove(c); 
		bagSize--;
		return c;
	}
	
	@Override
	public Piece getAltCube(){  
		shuffle(altCubes);
		Piece ac = altCubes.get(random.nextInt(altCubes.size()));  
		altCubes.remove(ac); 
		bagSize--;
		return ac;
	}
	
	@Override
	public Piece removeCard() {
		shuffle(wagonsDeck);
		Piece card = wagonsDeck.get(random.nextInt(wagonsDeck.size()));
		discard.setWagon(card);
		wagonsDeck.remove(card);
		bagSize--;
		return discard;
	}
}
