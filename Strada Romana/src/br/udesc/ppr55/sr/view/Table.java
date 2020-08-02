package br.udesc.ppr55.sr.view;

import br.udesc.ppr55.sr.model.Piece;

public class Table {

    private Piece[][] grid; 
    private int currentX;
    private int currentY;

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void setGrid(Piece[][] table) {
        this.grid = table;
    }
    
}
    
