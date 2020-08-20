/**
* StradaController Class
* @author Rodrigo Valle e Robson de Jesus
* @since 12/08/2020
* @version 1.0
*/

package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.Observer;
import br.udesc.ppr55.sr.model.Audio;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.model.builder.BuildGameTable;
import br.udesc.ppr55.sr.model.builder.Builder;
import br.udesc.ppr55.sr.model.builder.EmperorDirector;
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.components.WagonTilePortus;
import br.udesc.ppr55.sr.model.components.WagonTileRoma;
import br.udesc.ppr55.sr.model.components.WareSpotTile;
import br.udesc.ppr55.sr.view.PlayerPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StradaController implements IStradaController {

	private static StradaController instance;
	private EmperorDirector director;
	private Builder builderGameTable;

	private Audio audio;

	private Border yellowBorder;
	private Border blackBorder;

	private int screenSize;
	private int pos = 1;
	private boolean gameStatus = false;	
	protected Piece[][] grid;

	private AbstractPieceFactory factory;

	private List<Observer> observers = new ArrayList<>();

	private ArrayList<Player> players = new ArrayList<>();

	public static StradaController getInstance() {
		if (instance == null) {
			instance = new StradaController();
		}
		return instance;
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.add(observer);
	}

	// STRADA CONTROLLER
	@Override
	public void initializeBoard() {
		this.builderGameTable = new BuildGameTable();
		this.director = new EmperorDirector(builderGameTable);
		this.director.build(this.factory);
	}

	@Override
	public void startGame() {
		this.grid = this.builderGameTable.getTable().getGrid();
		this.addWagon();
		this.addCubeAndWareTiles();
		this.removeWagonTile();
		System.out.println(this.builderGameTable.getBag().toString());

		yellowBorder = BorderFactory.createLineBorder(Color.yellow);
		blackBorder = BorderFactory.createLineBorder(Color.black);

		// adjusts game bag
		this.builderGameTable.getBag().addPiece(-44);
		this.gameStatus = true;
		this.controlPlayerTurn();
		this.notifyStart();

		this.notifyBagSize(this.builderGameTable.getBag().getBagSize());
		this.notifyMessage("To move a wagon just grab and drag it to a different location!");
	}

	@Override
	public void createPlayerPanel(String n1, String n2) {
		players.add(new Player(new PlayerPanel(), n1));
		players.add(new Player(new PlayerPanel(), n2));
	}

	@Override
	public void initializeRadio() {
		this.setRadio();
	}

	@Override
	public void restartPlayerPanel(JPanel panel) {
		for (int i = 0; i < players.size(); i++) {
			panel.add(players.get(i).getPanel());
			players.get(i).getPanel().setName(players.get(i).getName());
		}
	}

	@Override
	public void controlPlayerTurn() {
		// set black border and change the position to false before pass turn
		players.get(pos).getPanel().setBorder(blackBorder);
		notifyPassButton(false);
		players.get(pos).setMoves(0);
		players.get(pos).setTurn(false);

		if (pos == 0) {
			pos++;
		} else {
			pos--;
		}

		// set the player turn and yellow border
		players.get(pos).setTurn(true);
		players.get(pos).setMoves(3);
		notifyPassButton(true);
		players.get(pos).getPanel().setBorder(yellowBorder);
	}

	@Override
	public void notifyPassButton(boolean isEnabled) {
		observers.get(pos).disableButton(isEnabled);
	}

	@Override
	public String getPiece(int col, int row) {
		return (builderGameTable.getTable().getGrid()[col][row] == null ? null
				: builderGameTable.getTable().getGrid()[col][row].getImage());
	}

	@Override
	public AbstractPieceFactory getFactory() {
		return factory;
	}

	@Override
	public void setFactory(PieceFactory pieceFactory) {
		this.factory = pieceFactory;
		this.initializeBoard();
	}

	@Override
	/**
	 * Set the audio file
	 */
	public void setRadio() {
		this.audio = new Audio(
				"music/Pillars of Eternity II Deadfire Soundtrack 11 - Queen's Berth (Justin Bell) - Rodrigo Valle REMIX.wav");
		this.audio.playMusic();
	}

	public void playerPanelUpdate() {
		notifyPlayerPanelUpdate(players.get(pos).getScore(), players.get(pos).getGold(), players.get(pos).getVPoints(),
				players.get(pos).getCubes().size(), players.get(pos).getWareTiles().size(),
				players.get(pos).getContracts().size());
	}

	@Override
	public void notifyPlayerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts) {
		observers.get(pos).playerPanelUpdate(score, coins, vp, cubes, wareTiles, contracts);
	}

	@Override
	public void playRadio() {
		this.audio.play();
	}

	@Override
	public void stopRadio() {
		this.audio.stop();
	}

	@Override
	/**
	 * Add gold coin into the player bag and jump to the next player
	 */
	public void passPlay() {
		if (players.get(pos).isMyTurn() == true) {
			players.get(pos).setGold(1);
			playerPanelUpdate();

			controlPlayerTurn();
			notifyMessage("It's " + players.get(pos).getName() + " turn!");
		}
	}

	@Override
	/**
	 * Add wagons to the game board at the predefined position
	 */
	public void addWagon() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if (grid[i][j].getClass() == WagonTilePortus.class) {
					grid[i][j] = this.builderGameTable.getBag().getPortusWagon();
				} else if (grid[i][j].getClass() == WagonTileRoma.class) {
					grid[i][j] = this.builderGameTable.getBag().getRomaWagon();
				}
			}
		}
	}

	@Override
	/**
	 * Add cubes and ware tiles to the game board at the predefined position
	 */
	public void addCubeAndWareTiles() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if (grid[i][j].getClass() == CubeSpotTile.class) {
					grid[i][j] = builderGameTable.getBag().getCube();
				} else if (grid[i][j].getClass() == InverseCubeSpot.class) {
					grid[i][j] = builderGameTable.getBag().getAltCube();
				} else if (grid[i][j].getClass() == WareSpotTile.class) {
					grid[i][j] = builderGameTable.getBag().getWareTile();
				}
			}
		}
	}

	@Override
	/**
	 * Remove one card from wagon's deck
	 */
	public void removeWagonTile() {
		for (int i = 7; i < 9; i++) {
			for (int j = 16; j < 18; j++) {
				if (grid[i][j] == grid[8][17]) {
					grid[i][j] = builderGameTable.getBag().removeCard();
				}
			}
		}
	}

	@Override
	public void setScreenSize(int size) {
		this.screenSize = size;
	}

	@Override
	public int getScreenSize() {
		return screenSize;
	}

	@Override
	public void notifyStart() {
		for (Observer observer : observers) {
			observer.boardPanelUpdate();
			observer.startGame();
		}
	}

	@Override
	public void notifyEndGame() {
	}

	@Override
	public void notifyMessage(String message) {
		for (Observer observer : observers) {
			observer.message(message);
		}
	}

	@Override
	public void notifyBagSize(int size) {
		for (Observer observer : observers) {
			observer.showBag(size);
		}
	}

	@Override
	public void gameFlow(int iCol, int iRow, int col, int row) {
		if (checkMovement(iCol, col) == true) {
			moveWagon(iCol, iRow, col, row);
		} else {
			System.out.println("player moves" + players.get(pos).getMoves());
		}
	}

	@Override
	public boolean checkMovement(int icol, int finalColumn) {
		int playerMoves = players.get(pos).getMoves();
		int total = finalColumn - icol;
		int totalOposite = icol - finalColumn;
		if (playerMoves > 0 || playerMoves >= total) {
			playerMoves -= total;
			players.get(pos).setMoves(playerMoves);
			return true;
		}
		return false;
	}

	@Override
	/**
	 * Move a selected wagon through the board
	 */
	public void moveWagon(int iCol, int iRow, int col, int row) {
		if (iCol == 0 || iCol == 16) {
			grid[row][col] = grid[iRow][iCol];
			grid[iRow][iCol] = this.factory.createWagonTilePortus();
		} else if (iCol >= 6 && iCol <= 10) {
			grid[row][col] = grid[iRow][iCol];
			grid[iRow][iCol] = this.factory.createRomaTile();
		} else if (iCol >= 1 && iCol <= 5 || iCol >= 11 && iCol <= 15) {
			grid[row][col] = grid[iRow][iCol];
			grid[iRow][iCol] = this.factory.createStradaTile();
		}
		notifyBoardUpdate();
	}

	@Override
	public void notifyBoardUpdate() {
		for (Observer observer : observers) {
			observer.boardPanelUpdate();
		}
	}

}
