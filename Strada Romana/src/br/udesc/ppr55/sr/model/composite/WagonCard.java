 /**
 * WagonCard Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.composite;

import br.udesc.ppr55.sr.model.Piece;

/**
 * Leaf class
 * @author Rodrigo Valle
 *
 */
public class WagonCard extends Piece implements Card {
	
	private Piece wagon;
	
	public WagonCard(int number, String name) {
		super("images/card"+number+".png"); 
		super.setCardName(name);
	} 
	
	@Override
	public String getCard() { 
		return this.getImage();
	}  
	
	@Override
	public String getName() {
		return this.getCardName();
	}
}
