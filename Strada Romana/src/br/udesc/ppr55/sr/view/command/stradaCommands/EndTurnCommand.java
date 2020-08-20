package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class EndTurnCommand extends StradaCommander {
	
	public EndTurnCommand(IStradaController controller) {
		super(controller);
	}
	
	@Override
	public void execute() {
		controller.controlPlayerTurn();
	}

}
