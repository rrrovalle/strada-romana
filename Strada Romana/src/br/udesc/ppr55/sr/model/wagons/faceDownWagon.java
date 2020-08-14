 /**
 * FaceDownWagon Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.model.wagons;
import br.udesc.ppr55.sr.model.Piece;

public class faceDownWagon extends Piece {

	private Piece wagon;
	
	public faceDownWagon() {
		super("images/spqr.png");
	}
	
	public void setWagon(Piece wagon) {
		this.wagon = wagon;
	}
	
	public Piece getWagon() {
		return wagon;
	} 
}
