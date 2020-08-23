package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class CreatePlayerPanelCommand extends StradaCommander {

	private String player1;
	private String player2;
	
	public CreatePlayerPanelCommand(InterfaceStradaC controller, String player1, String player2) {
		super(controller);
		this.player1 = player1;
		this.player2 = player2;
	}
	
	@Override
	public void execute() {
		controller.createPlayerPanel(player1, player2);
	}
}
