 /**
 * Red Cube class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.cubes;
import br.udesc.ppr55.sr.model.Piece;

public class RedCube extends Piece {
	
	public RedCube(int side) {
		super("images/redCube"+side+".png");
		super.setCube(true);
		super.setColor("red");
	} 
}
