 /**
 * Interface Observer Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control.observer;

import java.util.List;
import br.udesc.ppr55.sr.model.composite.Card;

public interface IObserver { 
	
	  public void boardPanelUpdate();
	  public void setPlayerPanel();
	  public void playerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts, int cards); 
	  public void showBag(int size); 
	  public void update(boolean isPaused);
	  public void disableButton(boolean turn);
	  public void shuffleWagonTiles();
	  public void openDeckPanel(List<Card> cards);
	  public void closeDeckPanel();
	  public void startGame();
	  public void endGame(); 
	  public void message(String message);
  
}
