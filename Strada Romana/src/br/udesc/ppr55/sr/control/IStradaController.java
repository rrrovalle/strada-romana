package br.udesc.ppr55.sr.control; 
 
import javax.swing.JPanel;

import br.udesc.ppr55.sr.control.observer.Observed;

/**
 * Interface to control the game
 * @author Rodrigo Valle
 */
public interface IStradaController extends Observed {
    
    void initializeBoard();  
    void createPlayerPanel(int p); 
    void restartPlayerPanel(JPanel pane);  
}
