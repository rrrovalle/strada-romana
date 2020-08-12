 /**
 * StradaCommander Abstract class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command;
import br.udesc.ppr55.sr.control.IStradaController; 

public abstract class StradaCommander implements Command {
	protected IStradaController controller;
	
	public StradaCommander(IStradaController controller) {
		this.controller = controller;
	}  
}
