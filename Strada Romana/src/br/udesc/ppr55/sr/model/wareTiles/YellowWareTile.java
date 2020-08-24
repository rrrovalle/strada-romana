 /**
 * Yellow Ware cube class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wareTiles;
import br.udesc.ppr55.sr.model.Piece;

public class YellowWareTile extends Piece {
	
	public YellowWareTile() {
		super("images/yellowWareTile.png");
		super.setWareTile(true);
		super.setColor("yellow");
	}
}
