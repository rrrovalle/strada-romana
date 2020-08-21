 /**
 * Canopites class 
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons; 
import br.udesc.ppr55.sr.model.Piece; 

public class Canopites extends Piece {
	
	public Canopites(int side) {
		super("images/Canopites"+side+".png");
		this.setMovable(true);
	}
}
