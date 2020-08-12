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
  void playerPanelUpdate();
  void wagonsPanelUpdate();
  void showWagons();
  void wareTileUpdate();
  void showWareTiles();
  void cubeUpdate();
  void showCube();
  void update(boolean isPaused);
  void shuffleWagonTiles();
  void endGame(); 
  void message(String message);
  }
