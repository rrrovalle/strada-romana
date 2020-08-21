 /**
 * Plotus class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons; 
import br.udesc.ppr55.sr.model.Piece; 

public class Plotus extends Piece {

	public Plotus(int side) {
		super("images/plotus"+side+".png");
		this.setMovable(true);
	}
}
