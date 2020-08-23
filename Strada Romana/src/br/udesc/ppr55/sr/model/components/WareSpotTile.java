 /**
 * WareSpotTile Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.components;

import br.udesc.ppr55.sr.model.Piece;

public class WareSpotTile extends Piece { 
   
    public WareSpotTile(int number) {
        super("images/wareSpot" + number + ".png" );
       	super.setPlace(number);
    }
 
}
