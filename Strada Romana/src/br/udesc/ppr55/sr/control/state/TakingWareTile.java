package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.model.Piece;

public class TakingWareTile extends MoveState {
	
	 public TakingWareTile(InterfaceStradaC stradaController) {
		 super(stradaController);
	 }
	 
	 @Override
	 public void takingWareTile(int iCol, int iRow) { 
			if (stradaController.confirmWareTilePick(iCol, iRow)) {
				if (stradaController.getWareLimit() == 0 && stradaController.getCubeLimit() == 0) {
				 	stradaController.getRoundPlayer().setWareTiles((Piece) (stradaController.getGrid()[iRow][iCol]));
					stradaController.getRoundPlayer().setGold(stradaController.giveCubes(stradaController.getGrid()[iRow][iCol].getColor()));
					stradaController.notifyMessage("You took the ware tile!");
					stradaController.getGrid()[iRow][iCol] = stradaController.getFactory().createWareSpotTile(stradaController.getGrid()[iRow][iCol].getPlace());
					stradaController.changeWareLimit(1); 
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
