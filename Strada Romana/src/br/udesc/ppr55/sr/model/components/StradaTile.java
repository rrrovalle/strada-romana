 /**
 * StradaTile Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.components;

import br.udesc.ppr55.sr.model.Piece;

public class StradaTile extends Piece {
	
	private boolean isOccupied;
	
	public StradaTile(boolean isOccupied) {
		super("images/stradaTile.png"); 
		this.isOccupied = isOccupied;
	}
	
    public boolean isOccupied() {
        return isOccupied;
    }
}
