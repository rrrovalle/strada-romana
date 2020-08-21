 /**
 * Maccus class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons; 
import br.udesc.ppr55.sr.model.Piece; 

public class Maccus extends Piece {

	public Maccus(int side) {
		super("images/maccus"+side+".png");
		this.setMovable(true);
	}
}
