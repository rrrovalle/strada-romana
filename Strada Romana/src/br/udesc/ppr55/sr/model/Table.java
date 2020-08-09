package br.udesc.ppr55.sr.model;

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
    
    public Piece getElementAt(int y, int x) {
		return this.grid[y][x];
	}
	
	//seta o elemento na posicao y e x
	public void setElementAt(Piece object,int y, int x) {
		this.grid[y][x] = object;
	}

    public void setGrid(Piece[][] table) {
        this.grid = table;
    }
}
