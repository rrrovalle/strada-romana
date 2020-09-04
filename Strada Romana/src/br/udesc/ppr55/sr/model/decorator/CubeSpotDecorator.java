package br.udesc.ppr55.sr.model.decorator;

import br.udesc.ppr55.sr.model.components.CubeSpotTile;

public abstract class CubeSpotDecorator {
	
	private CubeSpotTile cubeSpot;
	
	public CubeSpotDecorator(CubeSpotTile cubeSpot) { 
		this.cubeSpot = cubeSpot;
	}
 
	public CubeSpotTile getCubeSpotTile() {
		return cubeSpot;
	}	
	
	public void setImage(String image) {
		this.cubeSpot.setImage(image);
	}
}
