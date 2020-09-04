package br.udesc.ppr55.sr.model.decorator; 

import br.udesc.ppr55.sr.model.components.InverseCubeSpot;

public class InverseMarkedCubeSpot extends InverseSpotDecorator {
	
    public InverseMarkedCubeSpot(InverseCubeSpot inverseCubeSpot) {
        super(inverseCubeSpot);
        super.setImage("images/MarkedInverseCube.png");
    }
}
