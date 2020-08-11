package br.udesc.ppr55.sr.view.command;

import br.udesc.ppr55.sr.control.IStradaController;

/**
 * Command class to stop music
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 * @Command
 */
public class StopMusicCommand extends StradaCommander {
		
		public StopMusicCommand(IStradaController controller) {
			super(controller);
		}
		 
		@Override
		public void execute() {    
			controller.stopRadio(); 
		}

}
