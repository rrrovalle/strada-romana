 /**
 * CubeType enem Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.model.cubes;

public enum CubeType {
	
	RED("Red"), YELLOW("Yellow"), GREEN("Green"), 
	WHITE("White"), BROWN("Brown"), BLUE("Blue");
	
	private String name;
	
	CubeType(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
