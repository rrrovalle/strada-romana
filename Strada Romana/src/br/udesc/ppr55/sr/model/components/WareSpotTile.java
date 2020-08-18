 /**
 * WareSpotTile Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.components;

import br.udesc.ppr55.sr.model.Piece;

public class WareSpotTile extends Piece {
	
    private int number;
    
	public WareSpotTile() {
		super("images/wareSpot.png" );
	} 
	
    public WareSpotTile(int number) {
        super("images/wareSpot" + number + ".png" );
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
}
