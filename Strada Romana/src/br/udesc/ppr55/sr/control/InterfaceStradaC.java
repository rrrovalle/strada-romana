 /**
 * Interface IStradaController
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.control;  

import javax.swing.JPanel;

import br.udesc.ppr55.sr.control.observer.IObserved;
import br.udesc.ppr55.sr.control.state.MoveState;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory; 
import br.udesc.ppr55.sr.model.composite.DeckComposite; 

public interface InterfaceStradaC extends IObserved {
    
	// Core methods
	public void initializeBoard();    
    public void createPlayerPanel(String n1, String n2); 
    public void initializeRadio();
    public void setRadio();
    public void playRadio();
    public void stopRadio();
    public void restartPlayerPanel(JPanel pane);  
    public String getPiece(int col, int row); 
    public void setFactory(PieceFactory factory);
    public AbstractPieceFactory getFactory();
    
    public Piece[][] getGrid();
    public void setStradaState(MoveState moveState); 
    public Player getRoundPlayer();
    public int getWareLimit();
    public int getCubeLimit();
    public int getCardLimit();
    public void changeWareLimit(int limit);
    public void changeCubeLimit(int limit);
    public void changeCardLimit(int limit);
    public String getActualState();
    public DeckComposite getDeck();
    public void buySpecialFeature(int gold);
    
    // Screen methods
    public int getScreenSize();
    public void setScreenSize(int size); 
    
    // Game basic control methods
    public void addWagon();
    public void addWareTiles();
    public void fillCubesAndWareTiles();
    public void removeWagonTile();
    public boolean confirmWareTilePick(int iCol, int iRow);
    public boolean confirmOccupiedCubeConnectedTile(int iCol, int iRow);
    public int giveCubes(String color);
    public void controlPlayerTurn(boolean pass);
    public void playerPanelUpdate();
    public void resetGameTurn();
    public void passPlay();   
    public void startGame();  
    public boolean checkRomaMerchantPlace();
    public boolean checkPortusMerchantPlace();
    public boolean checkEndGame();
    
    // Game Control methods
    public void moveWagon(int icol,int irow, int finalColumn, int finalRow);
    public void gameFlow(int icol,int irow, int finalColumn, int finalRow); 
    public int checkAction(int iCol, int iRow);
    public void movingWagon(int iCol,int  iRow, int col, int row);
    public void takingWareTile(int iCol,int iRow);
    public void takingCube(int iCol, int iRow); 
    public void takingWagonTile();
    public boolean checkMovement(int iCol, int iRow, int col, int row);
    public int findWagons(int iCol, int iRow); 
    public void chooseCard(String cardName);
    public boolean checkTrafficBlock(int iCol, int col);
    
    // Moving Wagon methods
    public boolean normalMove(int iCol, int iRow, int col, int row);
    public boolean sidewayMove(int iCol, int iRow, int col, int row);
    public boolean checkDiagonalMove(int iCol, int iRow, int col, int row);
    public boolean diagonalMove(int iCol, int iRow, int col, int row);
 	public boolean extraMove(int iCol, int iRow, int col, int row);
  	public boolean stakingMove(int iCol, int iRow, int col, int row); 
}
