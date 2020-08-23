 /**
 * Ballio class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons; 
import br.udesc.ppr55.sr.model.Piece;

public class Ballio extends Piece { 
	
	public Ballio(int side) {
		super("images/ballio"+side+".png");
		this.setMovable(true);
		this.setWagon(true);
	} 
}
