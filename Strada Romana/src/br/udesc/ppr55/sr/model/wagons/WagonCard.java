 /**
 * WagonCard Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons;

import br.udesc.ppr55.sr.model.Piece;

public class WagonCard extends Piece {
	
	public WagonCard(int number) {
		super("images/card"+number+".png"); 
	}
}
