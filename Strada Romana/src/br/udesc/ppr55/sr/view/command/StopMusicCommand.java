 /**
 * Command class to stop music Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command;

import br.udesc.ppr55.sr.control.IStradaController;

public class StopMusicCommand extends StradaCommander {
		
		public StopMusicCommand(IStradaController controller) {
			super(controller);
		}
		 
		@Override
		public void execute() {    
			controller.stopRadio(); 
		}

}
