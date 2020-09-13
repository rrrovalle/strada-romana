package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class SpecialMoveCommand extends StradaCommander {
	
	private int gold;
	
	public SpecialMoveCommand(InterfaceStradaC controller, int gold) {
		super(controller);
		this.gold = gold;
	}
	
	@Override
	public void execute() { 
		controller.buySpecialFeature(gold);
	} 
}
