package br.udesc.ppr55.sr.control.visitor;

import br.udesc.ppr55.sr.model.Player;

public interface IPlayerVisitor { 
	// Como se trata de um PlayerVisitor e pra manipular os contratos ou outras peças (caso fosse desejado) se trataria de pegar o tamanho do array, optamos por retornar um int
	public int visit(Player contracts);
}
