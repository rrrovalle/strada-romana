package br.udesc.ppr55.sr.model.decorator;

import br.udesc.ppr55.sr.model.components.CubeSpotTile;

public class MarkedCubeSpot extends CubeSpotDecorator {

    public MarkedCubeSpot(CubeSpotTile cubeSpot) {
        super(cubeSpot);
        super.setImage("images/MarkedCubeSpotTile.png");
    }
}
