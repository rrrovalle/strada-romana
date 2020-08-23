 /**
 * StradaCommander Abstract class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command;
import br.udesc.ppr55.sr.control.InterfaceStradaC; 

public abstract class StradaCommander implements Command {
	protected InterfaceStradaC controller;
	
	public StradaCommander(InterfaceStradaC controller) {
		this.controller = controller;
	}  
}
