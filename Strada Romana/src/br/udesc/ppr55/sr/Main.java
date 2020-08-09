 
package br.udesc.ppr55.sr; 
import java.awt.EventQueue;

import br.udesc.ppr55.sr.view.GameFrame;  

public class Main {
    				
	/** 
	 * Launch the game 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				 new GameFrame().setVisible(true);
			} 
		});
	}
}
