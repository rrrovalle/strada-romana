 /**
 * Green cube class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.cubes;

import br.udesc.ppr55.sr.model.Piece;

public class GreenCube extends Piece {
 
	public GreenCube(int side) {
		super("images/greenCube"+side+".png"); 
		super.setCube(true);
		super.setColor("green");
	}
}
