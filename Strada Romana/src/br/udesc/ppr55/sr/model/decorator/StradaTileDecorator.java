package br.udesc.ppr55.sr.model.decorator;
 
import br.udesc.ppr55.sr.model.components.StradaTile;

public abstract class StradaTileDecorator extends StradaTile {
	
	private StradaTile stradaTile;

    public StradaTileDecorator(StradaTile stradaTile) {
        super(stradaTile.isOccupied());
        this.stradaTile = stradaTile;
    }

    public StradaTile getStradaTile() {
        return stradaTile;
    }
}
