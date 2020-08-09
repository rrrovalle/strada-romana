package br.udesc.ppr55.sr.control; 
 
import javax.swing.JPanel;

import br.udesc.ppr55.sr.control.observer.Observed;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;

/**
 * Interface to control the game
 * @author Rodrigo Valle
 */
public interface IStradaController extends Observed {
    
    void initializeBoard();   
    void createPlayerPanel(int p); 
    void restartPlayerPanel(JPanel pane);  
    String getPiece(int col, int row);
    void setFactory(PieceFactory factory);
    AbstractPieceFactory getFactory();
    
}
