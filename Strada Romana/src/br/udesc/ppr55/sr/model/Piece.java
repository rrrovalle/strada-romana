 /**
 * Piece Abstract Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.model;
public abstract class Piece {
    
    private String image;
    private int place;
    
    private boolean movable;
    private boolean isCube;
    private boolean isWareTile;
    private boolean isWagon;
    
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
    
    public int getPlace(){
        return place;
    }
    
    public void setPlace(int place){
        this.place = place;
    }
    
    public boolean isMovable() {
    	return movable;
    }
    
    public void setMovable(boolean movable) {
    	this.movable = movable;
    } 
    
    public boolean isCube() {
    	return isCube;
    }
    
    public void setCube(boolean isCube) {
    	this.isCube = isCube;
    } 
    
    public boolean isWareTile() {
    	return isWareTile;
    }
    
    public void setWareTile(boolean isWareTile) {
    	this.isWareTile = isWareTile;
    }
    
    public boolean isWagon() {
    	return isWagon;
    }
    
    public void setWagon(boolean isWagon) {
    	this.isWagon = isWagon;
    }
    
    
    
    
    
    
}
