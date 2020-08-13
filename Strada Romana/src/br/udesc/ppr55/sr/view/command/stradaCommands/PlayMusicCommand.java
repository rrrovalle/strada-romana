 /**
 * Command class to play music
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command.stradaCommands;
import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.view.command.StradaCommander; 

public class PlayMusicCommand extends StradaCommander {
	
	public PlayMusicCommand(IStradaController controller) {
		super(controller);
	}
	 
	@Override
	public void execute() {    
		controller.playRadio(); 
	}


}
