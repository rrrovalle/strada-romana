package br.udesc.ppr55.sr.control.observer;
 
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;

/**
 * Observed Class
 * 
 * @author Rodrigo Valle
 * @since 20/07/2020
 * @version 1.0
 */
public interface Observed {
	
	public void addObserver(Observer observer);
    public void removeObserver(Observer observer);  
    public void notifyBoardPanelUpdate();
    public void notifyPlayerPanelUpdate(); 
    public void createCubeTiles(); 
    public void notifyStart();
    public void notifyEndGame();
    public void notifyMessage(String message);
    public String getPiece(int col, int row); 
    public void setFactory(PieceFactory factory);
    public AbstractPieceFactory getFactory();
    public void startGame(); 
}
