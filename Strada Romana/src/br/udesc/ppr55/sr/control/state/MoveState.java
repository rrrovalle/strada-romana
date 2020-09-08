package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;

public abstract class MoveState  {
	
    protected InterfaceStradaC stradaController;

    public MoveState(InterfaceStradaC stradaController) {
        this.stradaController = stradaController;
    } 
    
    public void takingWareTile(int iCol, int iRow) {
    	stradaController.notifyMessage("Invalid action!");
    }
    
    public void takingCube(int iCol, int iRow) {
    	stradaController.notifyMessage("Invalid action!");
    }
    
    public void movingWagon(int iCol, int iRow, int col, int row) {
    	stradaController.notifyMessage("Invalid action!");
    } 
    
    public void takingWagonTile(String cardName) {
    	stradaController.notifyMessage("Invalid action!");
    }
}
