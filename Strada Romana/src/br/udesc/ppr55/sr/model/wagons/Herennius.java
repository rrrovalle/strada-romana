 /**
 * Herennius  class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons; 
import br.udesc.ppr55.sr.model.Piece; 

public class Herennius extends Piece {
	
	public Herennius(int side) {
		super("images/herennius"+side+".png");
		this.setMovable(true);
		this.setWagon(true);
	}
}