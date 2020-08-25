/**
* StradaController Class
* @author Rodrigo Valle e Robson de Jesus
* @since 12/08/2020
* @version 1.0
*/

package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.IObserver;
import br.udesc.ppr55.sr.model.Audio;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.model.builder.GameBuilder;
import br.udesc.ppr55.sr.model.builder.AbstractBuilder;
import br.udesc.ppr55.sr.model.builder.EmperorDirector;
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.GroundTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.components.LineTile;
import br.udesc.ppr55.sr.model.components.RomaTile;
import br.udesc.ppr55.sr.model.components.StradaTile;
import br.udesc.ppr55.sr.model.components.WagonTilePortus;
import br.udesc.ppr55.sr.model.components.WagonTileRoma;
import br.udesc.ppr55.sr.model.components.WareSpotTile;
import br.udesc.ppr55.sr.view.PlayerPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StradaController implements InterfaceStradaC {

	private static StradaController instance;
	private EmperorDirector director;
	private AbstractBuilder builderGameTable;

	private Audio audio;

	private Border yellowBorder;
	private Border blackBorder;

	private int screenSize;
	private int pos;
	private boolean gameStatus;
	private int round;
	private Random random;

	private int total;
	private int totalInv;
	protected Piece[][] grid;

	private int playerMoves;
	private int cubeLimit;
	private int wareLimit;

	private AbstractPieceFactory factory;

	private List<IObserver> observers = new ArrayList<>();

	private ArrayList<Player> players = new ArrayList<>();

	public static StradaController getInstance() {
		if (instance == null) {
			instance = new StradaController();
		}
		return instance;
	}

	@Override
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		this.observers.add(observer);
	}

	/*
	 * Core Methods
	 */
	@Override
	/**
	 *  Start the builder to create the game board
	 */
	public void initializeBoard() {
		this.builderGameTable = new GameBuilder();
		this.director = new EmperorDirector(builderGameTable);
		this.director.build(this.factory);
	}

	@Override
	/**
	 * Define the list with both players on game 
	 */
	public void createPlayerPanel(String n1, String n2) {
		players.add(new Player(new PlayerPanel(), n1));
		players.add(new Player(new PlayerPanel(), n2));
	}

	@Override
	public void initializeRadio() {
		this.setRadio();
	}

	public void setRadio() {
		this.audio = new Audio(
				"music/Pillars of Eternity II Deadfire Soundtrack 11 - Queen's Berth (Justin Bell) - Rodrigo Valle REMIX.wav");
		this.audio.playMusic();
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
	 * Add 
	 */
	public void restartPlayerPanel(JPanel panel) {
		for (int i = 0; i < players.size(); i++) {
			panel.add(players.get(i).getPanel());
			players.get(i).getPanel().setName(players.get(i).getName());
		}
	}

	@Override
	/**
	 *  Get a piece from the builder game table
	 */
	public String getPiece(int col, int row) {
		return (builderGameTable.getTable().getGrid()[col][row] == null ? null
				: builderGameTable.getTable().getGrid()[col][row].getImage());
	}

	@Override
	public void setFactory(PieceFactory pieceFactory) {
		this.factory = pieceFactory;
		this.initializeBoard();
		this.gameStatus = false;
	}

	@Override
	public AbstractPieceFactory getFactory() {
		return factory;
	}

	/*
	 * Screen methods
	 */
	@Override
	public int getScreenSize() {
		return screenSize;
	}

	@Override
	public void setScreenSize(int size) {
		this.screenSize = size;
	}

	/*
	 * Game basic control methods
	 */

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
	 *  Placing 6 “ware” tiles (one of each color) at random on the dedicated area
	 */
	public void addWareTiles() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if (grid[i][j].getClass() == WareSpotTile.class) {
					grid[i][j] = this.builderGameTable.getBag().getRandomWareTile(grid[i][j].getPlace());
				}
			}
		}
	}

	@Override
	/**
	 * Add cubes and ware tiles to the game board at the predefined position
	 */
	public void fillCubesAndWareTiles() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if (grid[i][j].getClass() == CubeSpotTile.class) {
					grid[i][j] = builderGameTable.getBag().getCube();
				} else if (grid[i][j].getClass() == InverseCubeSpot.class) {
					grid[i][j] = builderGameTable.getBag().getAltCube();
				} else if (grid[i][j].getClass() == WareSpotTile.class) {
					grid[i][j] = builderGameTable.getBag().getWareTile(grid[i][j].getPlace());
				}
			}
		}
		notifyBoardUpdate();
		notifyBagSize(this.builderGameTable.getBag().getBagSize());
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
	/**
	 * Check if the player is trying to grab a ware tile and discover which one is to check if there's a wagon near of it
	 */
	public boolean confirmWareTilePick(int iCol, int iRow) {
		// check if player can grab a ware tile
		if (grid[iRow][iCol] == grid[0][4] && (findWagons(iCol, iRow) == 1 || findWagons(iCol, iRow) == 3)) {
			return true;
		} else if (grid[iRow][iCol] == grid[8][3] && (findWagons(iCol, iRow) == 2 || findWagons(iCol, iRow) == 3)) {
			return true;
		} else if (grid[iRow][iCol] == grid[0][8] && (findWagons(iCol, iRow) == 1 || findWagons(iCol, iRow) == 3)) {
			return true;
		} else if (grid[iRow][iCol] == grid[8][10] && (findWagons(iCol, iRow) == 2 || findWagons(iCol, iRow) == 3)) {
			return true;
		} else if (grid[iRow][iCol] == grid[0][14] && (findWagons(iCol, iRow) == 1 || findWagons(iCol, iRow) == 3)) {
			return true;
		} else if (grid[iRow][iCol] == grid[8][14] && (findWagons(iCol, iRow) == 2 || findWagons(iCol, iRow) == 3)) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 *  Find all the cube connected tiles and confirm the wagon position besides it
	 */
	public boolean confirmOccupiedCubeConnectedTile(int iCol, int iRow) {
		if (grid[iRow][iCol] == grid[8][1] && grid[6][1].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][2] && grid[3][2].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[6][3] && grid[4][3].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][5] && grid[3][5].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[7][5] && grid[5][5].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][7] && grid[3][7].getClass() != RomaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[7][8] && grid[5][8].getClass() != RomaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][10] && grid[3][10].getClass() != RomaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[8][11] && grid[6][11].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][12] && grid[3][12].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[7][12] && grid[5][12].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][13] && grid[3][13].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[1][15] && grid[3][15].getClass() != StradaTile.class) {
			return true;
		} else if (grid[iRow][iCol] == grid[7][15] && grid[5][15].getClass() != StradaTile.class) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * 	Set a coin for each cube on the board with the same color of the taken ware tile
	 */
	public int giveCubes(String color) {
		int total = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if (grid[i][j].getColor() == color && grid[i][j].isCube()) {
					total++;
				}
			}
		}
		return total;
	}

	@Override
	/**
	 *  check if the player is trying to pass or end they turn before check the end round action
	 *  @param pass
	 *  
	 */
	public void controlPlayerTurn(boolean pass) {
		if(players.get(pos).getMoves() == 0 || pass == true) {
		round++;
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
		if (round == 2) {
			players.get(pos).setGold(1);
		}
		// set the player turn and yellow border
		resetGameTurn();
		notifyPassButton(true);
		players.get(pos).getPanel().setBorder(yellowBorder);
		}else {
			notifyMessage("You must always move by 3 squares to finish your turn!");
		}
	}

	@Override
	/**
	 * Add gold coin into the player bag and jump to the next player
	 */
	public void passPlay() {
		if (players.get(pos).isMyTurn() == true && players.get(pos).getMoves() == 3) {
			players.get(pos).setGold(1);
			playerPanelUpdate();

			controlPlayerTurn(true);
			notifyMessage("It's " + players.get(pos).getName() + " turn!");
		}
	}

	@Override
	public void startGame() {
		this.grid = this.builderGameTable.getTable().getGrid();
		this.builderGameTable.getBag().loadFirstWareTiles();
		addWagon();
		addWareTiles();
		fillCubesAndWareTiles();
		removeWagonTile();
		//System.out.println(this.builderGameTable.getBag().toString());

		this.yellowBorder = BorderFactory.createLineBorder(Color.yellow);
		this.blackBorder = BorderFactory.createLineBorder(Color.black);

		// adjusts game bag
		this.builderGameTable.getBag().addPiece(-55);
		this.gameStatus = true;
		
		// set a random player to start the match
		random = new Random();
		this.pos = random.nextInt(2);
		controlPlayerTurn(false);
		notifyStart();

		playerPanelUpdate();

		this.notifyBagSize(this.builderGameTable.getBag().getBagSize());
		this.notifyMessage("To move a wagon just grab and drag it to a different place!");
	}

	/*
	 * Game Control methods
	 */

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
	/**
	 *  Receive information from mouse listener and set the game flow from it
	 */
	public void gameFlow(int iCol, int iRow, int col, int row) {
		int action = checkAction(iCol, iRow);
		switch (action) {
		case 1:
			movingWagon(iCol, iRow, col, row);
			break;
		case 2:
			takingCube(iCol, iRow);
			break;
		case 3:
			takingWareTile(iCol, iRow);
			break;
		default:
			notifyMessage("First you need to select the wagon to move!");
			break;
		}
	}

	@Override
	/** 
	 *  Return the type from a clicked piece
	 */
	public int checkAction(int iCol, int iRow) {
		if (grid[iRow][iCol].isWagon()) {
			return 1;
		} else if (grid[iRow][iCol].isCube()) {
			return 2;
		} else if (grid[iRow][iCol].isWareTile()) {
			return 3;
		}
		return 0;
	}

	@Override
	/**
	 *   Let the player move a wagon if the movement is valid
	 */
	public void movingWagon(int iCol, int iRow, int col, int row) {
		if (checkMovement(iCol, iRow, col, row)) {
			moveWagon(iCol, iRow, col, row);
		} else {
			notifyMessage(players.get(pos).getName() + " moves: " + players.get(pos).getMoves());
		}
	}

	@Override
	/** 
	 *  Confirm if there's a wagon close to it/check if 
	 */
	public void takingWareTile(int iCol, int iRow) {

		if (confirmWareTilePick(iCol, iRow)) {
			if (wareLimit == 0 && cubeLimit == 0) {
				players.get(pos).setWareTiles((Piece) (grid[iRow][iCol]));
				players.get(pos).setGold(giveCubes(grid[iRow][iCol].getColor()));
				notifyMessage("You took the ware tile!");
				grid[iRow][iCol] = factory.createWareSpotTile(grid[iRow][iCol].getPlace());
				wareLimit++; 
			} else {
				notifyMessage("You already got a piece on this round.");
			}
		} else {
			notifyMessage("You need to get closer to the piece before try to pick up it.");
		}
		notifyBoardUpdate();
		playerPanelUpdate();
	}

	@Override
	public void takingCube(int iCol, int iRow) {
		if (confirmOccupiedCubeConnectedTile(iCol, iRow)) {
			if (cubeLimit == 0 && wareLimit == 0) {
				notifyMessage("You took the cube!");
				players.get(pos).setCubes((Piece) (grid[iRow][iCol]));
				cubeLimit++;
				if (iRow >= 2) {
					grid[iRow][iCol] = factory.createCubeSpotTile();
				} else {
					grid[iRow][iCol] = factory.createInverseCubeTile();
				}
			} else {
				notifyMessage("You already got a piece on this round.");
			}
		} else {
			notifyMessage("You need to get closer to the piece before try to pick up it.");
		}
		notifyBoardUpdate();
		playerPanelUpdate();
	}

	@Override
	/**
	 * check if there are still possibilities to move a wagon
	 */
	public boolean checkMovement(int iCol, int iRow, int col, int row) {
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col;
		if (!checkTrafficBlock(iCol, col) && grid[iRow][iCol].isMovable() && (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class)) {
				if (playerMoves > 0 && iCol != col) {
					// left side
					if (iCol < col && total <= playerMoves && total == 1 && grid[iRow][iCol].getWagonSide() == 1) {
						playerMoves -= total;
						players.get(pos).setMoves(playerMoves);
						return true;
					} else if (iCol > col && totalInv <= playerMoves && totalInv == 1 && grid[iRow][iCol].getWagonSide() == 2) {
						// right side
						playerMoves -= totalInv;
						players.get(pos).setMoves(playerMoves);
						return true;
					}
				}
				return false;
		} else {
			return false;
		}
	} 
	
	@Override
	/**
	 * 
	 * @param iRow
	 * @param iCol
	 * @return 1: top square; 2: bottom square; 3: middle square
	 */
	public int findWagons(int iCol, int iRow) {
		int result = 0;
		if (grid[iRow][iCol] == grid[0][4]) {
			for (int i = 2; i <= 3; i++) {
				for (int j = 1; j < 6; j++) {
					// test middle
					if (grid[4][1].getClass() != StradaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != StradaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								result = 1;
							}
						}
					}
				}
			}
		} else if (grid[iRow][iCol] == grid[8][3]) {
			for (int i = 4; i <= 6; i++) {
				for (int j = 1; j < 6; j++) {
					// test middle
					if (grid[4][1].getClass() != StradaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != StradaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								if (!grid[i][j].isCube()) {
									result = 2;
								}
							}
						}
					}
				}
			}
		} else if (grid[iRow][iCol] == grid[0][8]) {
			for (int i = 3; i <= 4; i++) {
				for (int j = 6; j <= 10; j++) {
					// test middle
					if (grid[4][9].getClass() != RomaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != RomaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								result = 1;
							}
						}
					}
				}
			}
		} else if (grid[iRow][iCol] == grid[8][10]) {
			for (int i = 5; i <= 6; i++) {
				for (int j = 6; j <= 10; j++) {
					// test middle
					if (grid[4][9].getClass() != RomaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != RomaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								result = 2;
							}
						}
					}
				}
			}
		} else if (grid[iRow][iCol] == grid[0][14]) {
			for (int i = 2; i <= 4; i++) {
				for (int j = 11; j <= 15; j++) {
					// test middle
					if (grid[4][11].getClass() != StradaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != StradaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								result = 1;
							}
						}
					}
				}
			}
		} else if (grid[iRow][iCol] == grid[8][14]) {
			for (int i = 5; i <= 6; i++) {
				for (int j = 11; j <= 15; j++) {
					// test middle
					if (grid[4][11].getClass() != StradaTile.class) {
						result = 3;
					} else if (grid[i][j].getClass() != StradaTile.class) {
						if (grid[i][j].getClass() != LineTile.class) {
							if (grid[i][j].getClass() != GroundTile.class) {
								result = 2;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	@Override
	/**
	 *  Check if there's any wagon blocking the passage
	 */
	public boolean checkTrafficBlock(int iCol, int col) { 
		boolean isBlocked = false; 
		for (int i = 2; i <= 6; i++) {
			for (int j = iCol+2; j <= col; j++) {
				if (grid[i][j].isWagon()) {
					 isBlocked = true;
				}
			}
		} 
		return isBlocked;
	}

	public void resetGameTurn() {
		players.get(pos).setTurn(true);
		players.get(pos).setMoves(3);
		cubeLimit = 0;
		wareLimit = 0;
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

	// Notifications
	@Override
	public void notifyBoardUpdate() {
		for (IObserver observer : observers) {
			observer.boardPanelUpdate();
		}
	}

	@Override
	public void notifyPassButton(boolean isEnabled) {
		observers.get(pos).disableButton(isEnabled);
	}

	@Override
	public void notifyStart() {
		for (IObserver observer : observers) {
			observer.boardPanelUpdate();
			observer.startGame();
		}
	}

	@Override
	public void notifyEndGame() {
	}

	@Override
	public void notifyMessage(String message) {
		for (IObserver observer : observers) {
			observer.message(message);
		}
	}

	@Override
	public void notifyBagSize(int size) {
		for (IObserver observer : observers) {
			observer.showBag(size);
		}
	}
}
