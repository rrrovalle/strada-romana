package br.udesc.ppr55.sr.control.visitor;
  
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.utils.ArrayItem;

public class ContractsVisitor implements IPlayerVisitor {
	
	private int max;
	private int cont;
	private int colors;
	private int[] pos;
	protected int total;
	
	@Override
	public int visit(Player player) {
		if(player.getContracts().size() > 0) {  
			pos = new int[6];
			
			for(int i=0; i<player.getContracts().size(); i++) {
				if(player.getContracts().get(i).equalsIgnoreCase("blue")) { 
					pos[0]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("brown")) { 
					pos[1]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("green")) { 
					pos[2]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("red")) {
					pos[3]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("white")) {
					pos[4]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("yellow")) {
					pos[5]++;
				} 
			}
			
			// check all array positions that contains something
			colors = ArrayItem.notEmptyArrayItem(pos); 
			// check the largest array position
			max    = ArrayItem.largestArrayItemAuxiliary(pos, 0);   
			cont   = (colors * max);  
			// return contract points 
			return cont;
		}else {
			return 0;
		}
	}
}
