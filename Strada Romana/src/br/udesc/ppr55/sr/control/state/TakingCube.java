package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.decorator.InverseMarkedCubeSpot;
import br.udesc.ppr55.sr.model.decorator.MarkedCubeSpot;

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
					/* Create decorator class to mark the empty cube spot*/
					MarkedCubeSpot markedCubeSpot = new MarkedCubeSpot((CubeSpotTile) stradaController.getFactory().createCubeSpotTile()); 
					stradaController.getGrid()[iRow][iCol] = markedCubeSpot.getCubeSpotTile();
				} else {
					InverseMarkedCubeSpot inverseMarkedCubeSpot = new InverseMarkedCubeSpot((InverseCubeSpot) stradaController.getFactory().createInverseCubeTile()); 
					stradaController.getGrid()[iRow][iCol] = inverseMarkedCubeSpot.getInverseCubeSpotTile();
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
