package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class SetScreenSizeCommand  extends StradaCommander {
	 
	private int size;
	
	public SetScreenSizeCommand(IStradaController controller, int size) {
		super(controller);
		this.size = size;
	}
	
	@Override
	public void execute() {
		controller.setScreenSize(size);
	}

}
