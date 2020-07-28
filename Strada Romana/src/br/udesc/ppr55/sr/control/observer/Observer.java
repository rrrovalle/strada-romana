package br.udesc.ppr55.sr.control.observer;

/**
 * Observer Class
 * 
 * @author Rodrigo Valle
 * @since 20/07/2020
 * @version 1.0
 */
public interface Observer {   
  void boardPanelUpdate();
  void initializePlayerPanel();
  void playerPanelUpdate();
  void wagonsPanelUpdate();
  void showWagons();
  void wareTileUpdate();
  void showWareTiles();
  void cubeUpdate();
  void showCube();
  void showWareBag();
  void shuffleWagonTiles();
  void endGame();
  void showAlert(String message);

}
