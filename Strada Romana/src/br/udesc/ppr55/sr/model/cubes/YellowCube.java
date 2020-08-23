 /**
 * Yellow cube class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.cubes;
import br.udesc.ppr55.sr.model.Piece;

public class YellowCube extends Piece {
	
	public YellowCube(int side) {
		super("images/yellowCube"+side+".png");
		super.setCube(true);
	}
}
