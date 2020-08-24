 /**
 * Command class SetCreenSizeCommand
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command.stradaCommands;

import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.view.command.StradaCommander;

public class SetScreenSizeCommand  extends StradaCommander {
	 
	private int size;
	
	public SetScreenSizeCommand(InterfaceStradaC controller, int size) {
		super(controller);
		this.size = size;
	}
	
	@Override
	public void execute() {
		controller.setScreenSize(size);
	}

}
