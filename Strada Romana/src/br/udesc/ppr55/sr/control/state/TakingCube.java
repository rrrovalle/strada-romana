package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.model.Piece;

public class TakingCube extends MoveState {

	public TakingCube(InterfaceStradaC stradaController) {
		super(stradaController);
	}
	
	@Override
	public void takingCube(int iCol, int iRow) {  
		if (stradaController.confirmOccupiedCubeConnectedTile(iCol, iRow)) {
			if (stradaController.getWareLimit() == 0 && stradaController.getCubeLimit() == 0) {
				stradaController.notifyMessage("You took the cube!");
				stradaController.getRoundPlayer().setCubes((Piece) (stradaController.getGrid()[iRow][iCol]));
				stradaController.changeCubeLimit(1); 
				if (iRow >= 2) {
					stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createCubeSpotTile();
				} else {
					stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createInverseCubeTile();
				}
			} else {
				stradaController.notifyMessage("You already got a piece on this round.");
			}
		} else {
			stradaController.notifyMessage("You need to get closer to the piece before try to pick up it.");
		}
		stradaController.notifyBoardUpdate();
		stradaController.playerPanelUpdate();
		// return to the original state
		stradaController.setStradaState(new MoveWagon(stradaController));
	} 

}
