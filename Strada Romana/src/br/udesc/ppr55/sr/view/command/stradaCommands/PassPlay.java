package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class PassPlay extends StradaCommander {
	
	public PassPlay(IStradaController controller) {
		super(controller);
	}
	 
	@Override
	public void execute() {    
		controller.passPlay(); 
	}
}
