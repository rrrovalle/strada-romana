package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;

public class MoveWagon extends MoveState {
	
    public MoveWagon(InterfaceStradaC stradaController) {
        super(stradaController);
    }
    
    @Override
    public void movingWagon(int iCol, int iRow, int col, int row) {
		if (iCol == 0 || iCol == 16) {
			stradaController.getGrid()[row][col] = stradaController.getGrid()[iRow][iCol];
			stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createWagonTilePortus();
		} else if (iCol >= 6 && iCol <= 10) {
			stradaController.getGrid()[row][col] = stradaController.getGrid()[iRow][iCol];
			stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createRomaTile();
		} else if (iCol >= 1 && iCol <= 5 || iCol >= 11 && iCol <= 15) {
			stradaController.getGrid()[row][col]   = stradaController.getGrid()[iRow][iCol];
			stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createStradaTile();
		}
		stradaController.notifyBoardUpdate();
    }
    
}
