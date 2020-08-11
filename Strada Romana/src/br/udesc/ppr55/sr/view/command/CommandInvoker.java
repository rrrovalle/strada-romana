package br.udesc.ppr55.sr.view.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command Invoker class
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @Command
 * @version 1.0
 */
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
