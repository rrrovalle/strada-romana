 /**
 * Command Invoker class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view.command;
import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	   private List<Command> commands = new ArrayList<>();

	   	public void add(Command comm) {
	        commands.add(comm);
	    }

	   	public void execute() {
	        for (Command comm : commands) {
	            comm.execute();
	        }
	        commands.clear();
	    }
}
