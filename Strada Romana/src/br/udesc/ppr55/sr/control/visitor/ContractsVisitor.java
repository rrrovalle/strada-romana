package br.udesc.ppr55.sr.control.visitor;
  
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.utils.ArrayItem;

public class ContractsVisitor implements IPlayerVisitor {
	
	private int max;
	private int count;
	private int colors;
	private int[] pos;
	
	@Override
	public int visit(Player player) {
		if(player.getContracts().size() > 0) {  
			pos = new int[6];
			
			for(int i=0; i<player.getContracts().size(); i++) {
				if(player.getContracts().get(i).equalsIgnoreCase("blue")) { 
					pos[0]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("green")) { 
					pos[1]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("white")) { 
					pos[2]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("brown")) {
					pos[3]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("green")) {
					pos[4]++;
				}else if(player.getContracts().get(i).equalsIgnoreCase("yellow")) {
					pos[5]++;
				} 
			}
			
			colors = ArrayItem.notEmptyArrayItem(pos);
			max    = ArrayItem.largestArrayItemAuxiliary(pos, 0); 
			count  = (colors * max);  
			return count;
		}
		return 0;
	}
}
