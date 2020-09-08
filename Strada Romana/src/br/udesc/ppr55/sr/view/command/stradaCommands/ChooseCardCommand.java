package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class ChooseCardCommand extends StradaCommander {
	
	private String cardName;
	
	public ChooseCardCommand(InterfaceStradaC controller, String cardName) {
		super(controller);
		this.cardName = cardName;
	}
	
	@Override
	public void execute() { 
		controller.chooseCard(cardName);
	} 
}
