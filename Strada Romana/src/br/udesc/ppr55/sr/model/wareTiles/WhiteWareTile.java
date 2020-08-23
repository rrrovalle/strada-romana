 /**
 * White Ware Tile class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wareTiles;
import br.udesc.ppr55.sr.model.Piece;

public class WhiteWareTile extends Piece {

	public WhiteWareTile() {
		super("images/whiteWareTile.png");
		super.setWareTile(true);
	}
}
