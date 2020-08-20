 /**
 * Piece Abstract Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.model;
public abstract class Piece {
    
    private String image;
    private boolean movable;
    
    public Piece(String image){
        this.image = image;
        this.movable = false;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    
    public boolean isMovable() {
    	return movable;
    }
    
    public void setMovable(boolean movable) {
    	this.movable = movable;
    } 
}
