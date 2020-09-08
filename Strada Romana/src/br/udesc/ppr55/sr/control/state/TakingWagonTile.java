package br.udesc.ppr55.sr.control.state;

import br.udesc.ppr55.sr.control.InterfaceStradaC;

public class TakingWagonTile extends MoveState {

	public TakingWagonTile(InterfaceStradaC stradaController) {
		super(stradaController); 
	}
	
	@Override
	public void takingWagonTile(String cardName) {
		if(stradaController.getCardLimit() == 0) { 
			if(stradaController.getRoundPlayer().getCards().size() < 3) {
			stradaController.getRoundPlayer().addCard(cardName); 
			stradaController.getDeck().remove(stradaController.getDeck().findByName(cardName));
			stradaController.changeCardLimit(1);
			stradaController.notifyMessage("Your card has been saved");
			stradaController.playerPanelUpdate();
			stradaController.notifyChooseWagon();
			}else {
				stradaController.notifyMessage("You already got 3 cards!");
			}
		}else {
			stradaController.notifyMessage("You already got a card on this round!");
		}
		// return to the original state
		stradaController.setStradaState(new MoveWagon(stradaController));
	};

}
