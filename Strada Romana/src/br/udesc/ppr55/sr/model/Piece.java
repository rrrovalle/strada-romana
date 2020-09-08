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
    private String color;
    private String cardName;
    
    private boolean movable;
    private boolean isCube;
    private boolean isWareTile;
    private boolean isWagon;
    private boolean isDeck;
    private int wagonSide;
    
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
    
    public String getColor() {
    	return color;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }
    
    public int getWagonSide() {
    	return wagonSide;
    }
    
    public void setWagonSide(int side) {
    	this.wagonSide = side;
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
    
    public boolean isDeck() {
    	return isDeck;
    }
    
    public void setDeck(boolean isDeck) {
    	this.isDeck = isDeck;
    }
    
    public String getCardName() {
    	return cardName;
    }
    
    public void setCardName(String name) {
    	this.cardName = name;
    }
}
