package br.udesc.ppr55.sr.control.visitor;

import br.udesc.ppr55.sr.model.Player;

public interface IPlayerVisitor { 
	public int visit(Player contracts);
}
