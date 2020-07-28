package br.udesc.ppr55.sr.control; 

import br.udesc.ppr55.sr.control.observer.Observed;

/**
 * Interface to control the game
 * @author Rodrigo Valle
 */
public interface IStradaController extends Observed {
    
    void initializeBoard();  
    void initializePlayerPanel(); 
}
