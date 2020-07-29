package br.udesc.ppr55.sr.control; 

import javax.swing.JFrame;

import br.udesc.ppr55.sr.control.observer.Observed;

/**
 * Interface to control the game
 * @author Rodrigo Valle
 */
public interface IStradaController extends Observed {
    
    void initializeBoard();  
    void setPlayerPanel(int p); 
    void initializePlayerPanel(JFrame j);
}
