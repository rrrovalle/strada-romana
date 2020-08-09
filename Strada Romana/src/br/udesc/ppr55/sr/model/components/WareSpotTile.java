package br.udesc.ppr55.sr.model.components;

import br.udesc.ppr55.sr.model.Piece;

public class WareSpotTile extends Piece {
	
    private int number;
    
	public WareSpotTile() {
		super("images/wareSpot.png");
	} 
	
    public WareSpotTile(int number) {
        super("images/wareSpot" + number + ".png");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
}
