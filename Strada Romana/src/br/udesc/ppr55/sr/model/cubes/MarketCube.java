 /**
 * MarmetCube Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.cubes;

import br.udesc.ppr55.sr.model.Piece;

public class MarketCube extends Piece {
	
	private CubeType cubeType;
	private String imagePath = "images/";
	
	public MarketCube(CubeType cubeType) { 
		super("");
		this.cubeType = cubeType;	
	} 
	
	public void setImagePath() {
		this.imagePath = imagePath+cubeType;
	}
	
	@Override
	public String toString() {
		return imagePath;
	}
	
	
}
