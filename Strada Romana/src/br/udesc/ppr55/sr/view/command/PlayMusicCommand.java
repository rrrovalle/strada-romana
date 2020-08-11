package br.udesc.ppr55.sr.view.command;

import br.udesc.ppr55.sr.control.IStradaController; 

/**
 * Command class to play music
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @Command
 * @version 1.0
 */
public class PlayMusicCommand extends StradaCommander {
	
	public PlayMusicCommand(IStradaController controller) {
		super(controller);
	}
	 
	@Override
	public void execute() {    
		controller.playRadio(); 
	}


}
