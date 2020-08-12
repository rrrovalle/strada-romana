package br.udesc.ppr55.sr.view.command;

import br.udesc.ppr55.sr.control.IStradaController;

public class StartGameCommand extends StradaCommander {
	
	public StartGameCommand(IStradaController controller) {
		super(controller);
	}
	 
	@Override
	public void execute() {    
		controller.startGame();
	}
 
}
