package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class PassPlay extends StradaCommander {
	
	public PassPlay(InterfaceStradaC controller) {
		super(controller);
	}
	 
	@Override
	public void execute() {    
		controller.passPlay(); 
	}
}
