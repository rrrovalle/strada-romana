package br.udesc.ppr55.sr.model;

/**
 * This class implements all abstract methods from a piece
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0 
 */
public abstract class Piece {
    
    private String image;
    
    public Piece(String image){
        this.image = image;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    
}
