package br.udesc.ppr55.sr.model.decorator;

import br.udesc.ppr55.sr.model.components.InverseCubeSpot;

public abstract class InverseSpotDecorator {
	
	private InverseCubeSpot inverseCubeSpot;
	
	public InverseSpotDecorator(InverseCubeSpot inverseSpot) { 
		this.inverseCubeSpot = inverseSpot;
	}
 
	public InverseCubeSpot getInverseCubeSpotTile() {
		return inverseCubeSpot;
	}	
	
	public void setImage(String image) {
		this.inverseCubeSpot.setImage(image);
	}
}
