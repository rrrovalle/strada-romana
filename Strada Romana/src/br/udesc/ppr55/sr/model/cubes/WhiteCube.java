package br.udesc.ppr55.sr.model.cubes;

import br.udesc.ppr55.sr.model.Piece;

/**
 * White cube class
 * @author Rodrigo Valle
 * @since 29/07/2020
 * @version 1.0
 */
public class WhiteCube extends Piece {

	public WhiteCube(int side) {
		super("images/whiteCube"+side+".png");
	}
}
