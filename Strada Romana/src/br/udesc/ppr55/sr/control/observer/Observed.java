/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ppr55.sr.control.observer;

/**
 * Observed Class
 * 
 * @author Rodrigo Valle
 * @since 20/07/2020
 * @version 1.0
 */
public interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyBoardPanelUpdate();
    void notifyPlayerPanelUpdate();
    void notifyWagonsPanelUpdate();
    void notifyShowWagons();
    void notifyWareTileUpdate();
    void notifyShowWareTiles();
    void notifyCubeUpdate();
    void notifyShowCube();
    void notifyShowWareBag();
    void notifyShuffleWagonTiles();
    void notifyEndGame();
    void notifyShowAlert(String message);
}
