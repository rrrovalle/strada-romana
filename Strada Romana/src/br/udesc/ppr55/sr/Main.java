 /**
 * Main Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr;
import java.awt.EventQueue;
 
import br.udesc.ppr55.sr.view.SelectionFrame;  

public class Main { 
    				
	/** 
	 * Launch the game 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				 new SelectionFrame().setVisible(true);
			} 
		});
	}
}
