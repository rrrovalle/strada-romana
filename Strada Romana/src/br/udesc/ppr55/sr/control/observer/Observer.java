 /**
 * Interface Observer Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.control.observer;

public interface Observer {   
  void boardPanelUpdate();
  void setPlayerPanel();
  void playerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts); 
  void showBag(int size); 
  void update(boolean isPaused);
  void disableButton(boolean turn);
  void shuffleWagonTiles();
  void startGame();
  void endGame(); 
  void message(String message);
  }
