package br.udesc.ppr55.sr.view.command;

import br.udesc.ppr55.sr.control.IStradaController; 

/**
 * Strada Commander abstract class
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @Command
 * @version 1.0
 */
public abstract class StradaCommander implements Command {
	protected IStradaController controller;
	
	public StradaCommander(IStradaController controller) {
		this.controller = controller;
	}  
}
