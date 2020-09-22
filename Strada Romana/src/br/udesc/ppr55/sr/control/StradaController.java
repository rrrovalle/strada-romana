/**
* StradaController Class
* @author Rodrigo Valle e Robson de Jesus
* @since 12/08/2020
* @version 1.0
*/

package br.udesc.ppr55.sr.control;

import br.udesc.ppr55.sr.control.observer.IObserver;
import br.udesc.ppr55.sr.control.state.TakingCube;
import br.udesc.ppr55.sr.control.state.TakingWagonTile;
import br.udesc.ppr55.sr.control.state.TakingWareTile;
import br.udesc.ppr55.sr.control.visitor.ContractsVisitor;
import br.udesc.ppr55.sr.control.state.MoveState;
import br.udesc.ppr55.sr.model.Audio;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.Player;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.abstractFactory.PieceFactory;
import br.udesc.ppr55.sr.model.adapter.DefaultResolution;
import br.udesc.ppr55.sr.model.adapter.ResolutionAdapter;
import br.udesc.ppr55.sr.model.builder.LocalMultiplayerBuilder;
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
import br.udesc.ppr55.sr.model.composite.Card;
import br.udesc.ppr55.sr.model.composite.DeckComposite;
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
	
	private DefaultResolution defaultResolution;
	private ResolutionAdapter resolutionAdapter;
	
	private MoveState moveState;
	private DeckComposite deck;

	private Audio audio;

	private Border yellowBorder;
	private Border blackBorder;

	private int screenSize;
	private int pos;
	private boolean gameStatus;
	private int round;
	private int count;
	private int takeCard;
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
	private ArrayList<String> wagonsTiles = new ArrayList<>();

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

	public void createDeck() {
		deck = new DeckComposite(builderGameTable.getBag().getDeck());
		removeWagonTile();
	}

	/*
	 * Core Methods
	 */

	@Override
	/**
	 * Start the builder to create the game board
	 */
	public void initializeBoard() {
		this.builderGameTable = new LocalMultiplayerBuilder();
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

	/**
	 * Sum the contract points from each player */
	@Override
	public int sumContractPoints(Player player) {
		ContractsVisitor pv = new ContractsVisitor(); 
		player.accept(pv);
		return pv.visit(player);
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
	 * Get a piece from the builder game table
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

	@Override
	public int getWareLimit() {
		return wareLimit;
	}

	@Override
	public void changeWareLimit(int limit) {
		this.wareLimit = limit;
	}

	@Override
	public int getCubeLimit() {
		return cubeLimit;
	}

	@Override
	public void changeCubeLimit(int limit) {
		this.cubeLimit = limit;
	}

	@Override
	public int getCardLimit() {
		return this.takeCard;
	}

	@Override
	public void changeCardLimit(int limit) {
		this.takeCard = limit;
	}

	@Override
	public DeckComposite getDeck() {
		return this.deck;
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
		if(size == 50) {
			defaultResolution = new DefaultResolution();
			this.screenSize = defaultResolution.provideDefaultResolution();
		}else {
			// Applying the adapter pattern
			defaultResolution = new DefaultResolution();
			resolutionAdapter = new ResolutionAdapter(defaultResolution);
			this.screenSize = resolutionAdapter.provideHighQualityResolution();
		}
	}

	/*
	 * Game basic control methods
	 */

	@Override
	public Player getRoundPlayer() {
		return players.get(pos);
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
	 * Placing 6 “ware” tiles (one of each color) at random on the dedicated area
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
	 * Check if the player is trying to grab a ware tile and discover which one is
	 * to check if there's a wagon near of it
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
	 * Find all the cube connected tiles and confirm the wagon position besides it
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
	 * Set a coin for each cube on the board with the same color of the taken ware
	 * tile
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
	 * check if the player is trying to pass or end they turn before check the end
	 * round action
	 * 
	 * @param pass
	 * 
	 */
	public void controlPlayerTurn(boolean pass) {
		if (getRoundPlayer().getMoves() == 0 || getRoundPlayer().getMoveStatus() == 4 || pass == true) {
			round++;
			// set black border and change the position to false before pass turn
			getRoundPlayer().getPanel().setBorder(blackBorder);
			notifyPassButton(false);
			players.get(pos).setMoves(0);
			players.get(pos).setTurn(false);

			if (pos == 0) {
				pos++;
			} else {
				pos--;
			}
			if (round == 2) {
				getRoundPlayer().setGold(1);
			}
			// set the player turn and yellow border
			resetGameTurn();
			notifyPassButton(true);
			getRoundPlayer().getPanel().setBorder(yellowBorder);
		} else {
			notifyMessage("You must always move by 3 squares to finish your turn!");
		}
	}

	@Override
	/**
	 * Add gold coin into the player bag and jump to the next player
	 */
	public void passPlay() {
		if (getRoundPlayer().isMyTurn() == true && getRoundPlayer().getMoves() == 3) {
			getRoundPlayer().setGold(1);
			playerPanelUpdate(); 
			controlPlayerTurn(true);
			notifyMessage("It's " + getRoundPlayer().getName() + " turn!");
		}
	}

	@Override
	public void startGame() { 
		this.grid = this.builderGameTable.getTable().getGrid();
		this.builderGameTable.getBag().loadFirstWareTiles();
		addWagon();
		addWareTiles();
		fillCubesAndWareTiles();
		this.createDeck(); 
	 
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
	public Piece[][] getGrid() {
		return builderGameTable.getTable().getGrid();
	}

	@Override
	public void setStradaState(MoveState moveState) {
		this.moveState = moveState;
	}

	@Override
	/**
	 * Move a selected wagon through the board
	 */
	public void moveWagon(int iCol, int iRow, int col, int row) {
		this.moveState.movingWagon(iCol, iRow, col, row);
	}

	@Override
	/**
	 * Receive information from mouse listener and set the game flow from it
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
		case 4:
			takingWagonTile();
			break;
		default:
			notifyMessage("First you need to select the wagon to move!");
			break;
		}
	}

	@Override
	/**
	 * Return the type from a clicked piece
	 */
	public int checkAction(int iCol, int iRow) {
		if (grid[iRow][iCol].isWagon()) {
			return 1;
		} else if (grid[iRow][iCol].isCube()) {
			return 2;
		} else if (grid[iRow][iCol].isWareTile()) {
			return 3;
		} else if (grid[iRow][iCol].isDeck()) {
			return 4;
		}
		return 0;
	}

	@Override
	/**
	 * Let the player move a wagon if the movement is valid
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
	 * Confirm if there's a wagon close to it/check if
	 */
	public void takingWareTile(int iCol, int iRow) {
		setStradaState(new TakingWareTile(this));
		this.moveState.takingWareTile(iCol, iRow);
	}

	@Override
	public void takingCube(int iCol, int iRow) {
		this.setStradaState(new TakingCube(this));
		this.moveState.takingCube(iCol, iRow);
	}

	@Override
	public String getActualState() {
		return this.moveState.toString();
	}

	@Override
	public void buySpecialFeature(int gold) { 
		if (getRoundPlayer().getGold() >= gold) {
			notifyMessage("Now you can move like a real merchant!");
			getRoundPlayer().setMoveStatus(gold);
			gold = gold * (-1);
			getRoundPlayer().setGold(gold);
			notifyFeaturePanel();
			playerPanelUpdate();
		} else {
			notifyMessage("You need more gold to buy this feature!");
		}
	}

	@Override
	public void notifyFeaturePanel() {
		for (IObserver observer : observers) {
			observer.closeFeaturePanel();
		}
	}

	@Override
	/**
	 * check if there are still possibilities to move a wagon
	 */
	public boolean checkMovement(int iCol, int iRow, int col, int row) {
		int status = getRoundPlayer().getMoveStatus();
		switch (status) {
		case 0:
			return normalMove(iCol, iRow, col, row); 
		case 1:
			return sidewayMove(iCol, iRow, col, row);
		case 2:
			return diagonalMove(iCol, iRow, col, row);
		case 3:
			return extraMove(iCol, iRow, col, row);
		case 4:
			return stakingMove(iCol, iRow, col, row);
		} 
		return false;
	}
	
	@Override
	public boolean normalMove(int iCol, int iRow, int col, int row) {
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col;
		if (!checkTrafficBlock(iCol, col) && grid[iRow][iCol].isMovable()
				&& (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class 
						|| grid[row][col].getClass() == WagonTileRoma.class || grid[row][col].getClass() == WagonTilePortus.class)) {
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
	public boolean sidewayMove(int iCol, int iRow, int col, int row) {
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col;  
		if (!checkTrafficBlock(iCol, col) && grid[iRow][iCol].isMovable() 
				&& (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class)
				|| grid[row][col].getClass() == WagonTileRoma.class || grid[row][col].getClass() == WagonTilePortus.class) {
			if (playerMoves > 0) {
				// left side
				if (!checkDiagonalMove(iCol, iRow, col, row) && (iCol < col || iCol == col) && total <= playerMoves && (total == 1 || total == 0) && grid[iRow][iCol].getWagonSide() == 1) {
					if(total == 0 || total == 1){
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
						return true;
					}
				} else if (!checkDiagonalMove(iCol, iRow, col, row) && (iCol > col || iCol == col) && totalInv <= playerMoves && (totalInv == 1 || totalInv == 0) && grid[iRow][iCol].getWagonSide() == 2) {
					// right side
					if(totalInv == 0 || totalInv == 1) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
						return true;
					} 
				}
			}
			return false;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkDiagonalMove(int iCol, int iRow, int col, int row) {
		boolean sit = false;
		//check first quadrant
		if(grid[iRow][iCol].getWagonSide() == 1) {
			if(grid[3][4].isWagon() && (iCol == 4 && col == 5) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][4].isWagon() && (iCol == 4 && col == 5) && (iRow == 5 && row == 3)) {
				sit = true;
			}
			//second quadrant
			if(grid[3][7].isWagon() && (iCol == 7 && col == 8) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][7].isWagon() && (iCol == 7 && col == 8) && (iRow == 5 && row == 3)) {
				sit = true;
			}
			//third quadrant
			if(grid[3][12].isWagon() && (iCol == 12 && col == 13) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][12].isWagon() && (iCol == 12 && col == 13) && (iRow == 5 && row == 3)) {
				sit = true;
			}	
		}else if(grid[iRow][iCol].getWagonSide() == 2) {
			//third quadrant
			if(grid[3][13].isWagon() && (iCol == 13 && col == 12) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][13].isWagon() && (iCol == 13 && col == 12) && (iRow == 5 && row == 3)) {
				sit = true;
			}	
			//second quadrant
			if(grid[3][8].isWagon() && (iCol == 8 && col == 7) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][8].isWagon() && (iCol == 8 && col == 7) && (iRow == 5 && row == 3)) {
				sit = true;
			}
			//third quadrant
			if(grid[3][5].isWagon() && (iCol == 5 && col == 4) && (iRow == 3 && row == 5)) {
				sit = true;
			}else if(grid[5][5].isWagon() && (iCol == 5 && col == 4) && (iRow == 5 && row == 3)) {
				sit = true;
			} 
		}
		return sit;
	}
	
	
	@Override
	public boolean diagonalMove(int iCol, int iRow, int col, int row) {
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col;
		if (!checkTrafficBlock(iCol, col) && grid[iRow][iCol].isMovable() 
				&& (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class)
				|| grid[row][col].getClass() == WagonTileRoma.class || grid[row][col].getClass() == WagonTilePortus.class) {
			if (playerMoves > 0) {
				// left side
				if ((iCol < col || iCol == col) && total <= playerMoves && (total == 1 || total == 0) && grid[iRow][iCol].getWagonSide() == 1) {
					if(total == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
					}
					playerMoves -= total;
					players.get(pos).setMoves(playerMoves);
					return true;
				} else if ((iCol > col || iCol == col) && totalInv <= playerMoves && (totalInv == 1 || totalInv == 0) && grid[iRow][iCol].getWagonSide() == 2) {
					// right side
					if(totalInv == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
					}
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
	public boolean extraMove(int iCol, int iRow, int col, int row) {
		count++;
		if(count == 1) {
		players.get(pos).setMoves(4);	
		}
		
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col;
		System.out.println(playerMoves);
		if (!checkTrafficBlock(iCol, col) && grid[iRow][iCol].isMovable() 
				&& (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class)
				|| grid[row][col].getClass() == WagonTileRoma.class || grid[row][col].getClass() == WagonTilePortus.class) {
			if (playerMoves > 0) {
				// left side
				if ((iCol < col || iCol == col) && total <= playerMoves && (total == 1 || total == 0) && grid[iRow][iCol].getWagonSide() == 1) {
					if(total == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
					}
					playerMoves -= total;
					players.get(pos).setMoves(playerMoves);
					return true;
				} else if ((iCol > col || iCol == col) && totalInv <= playerMoves && (totalInv == 1 || totalInv == 0) && grid[iRow][iCol].getWagonSide() == 2) {
					// right side
					if(totalInv == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
					}
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
	public boolean stakingMove(int iCol, int iRow, int col, int row) {  
		count++;
		if(count == 1) {
		players.get(pos).setMoves(4);	
		}
		
		playerMoves = players.get(pos).getMoves();
		total = col - iCol;
		totalInv = iCol - col; 
		if (grid[iRow][iCol].isMovable() 
				&& (grid[row][col].getClass() == StradaTile.class || grid[row][col].getClass() == RomaTile.class)
				|| grid[row][col].getClass() == WagonTileRoma.class || grid[row][col].getClass() == WagonTilePortus.class) {
			if (playerMoves > 0) {
				// left side
				if ((iCol < col || iCol == col) && total <= playerMoves && (total == 1 || total == 2 || total == 0) && grid[iRow][iCol].getWagonSide() == 1) {
					if(total == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
						return true;
					}
					playerMoves -= 1;
					players.get(pos).setMoves(playerMoves);
					return true;
				} else if ((iCol > col || iCol == col) && totalInv <= playerMoves && (totalInv == 1 || totalInv == 2 | totalInv == 0) && grid[iRow][iCol].getWagonSide() == 2) {
					// right side
					if(totalInv == 0) {
						playerMoves -= 1;
						getRoundPlayer().setMoves(playerMoves); 
						return true;
					}
					playerMoves -= 1;
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
	public void takingWagonTile() {
		notifyDeckPanel(this.deck.getDeck());
	}

	@Override
	public void chooseCard(String cardName) {
		this.setStradaState(new TakingWagonTile(this));
		this.moveState.takingWagonTile(cardName);
	}

	@Override
	public void notifyDeckPanel(List<Card> deck) {
		for (IObserver observer : observers) {
			observer.openDeckPanel(deck);
		}
	}

	@Override
	public void notifyChooseWagon() {
		for (IObserver observer : observers) {
			observer.closeDeckPanel();
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
	 * Check if there's any wagon blocking the passage
	 */
	public boolean checkTrafficBlock(int iCol, int col) {
		boolean isBlocked = false;
		for (int i = 2; i <= 6; i++) {
			for (int j = iCol + 2; j <= col; j++) {
				if (grid[i][j].isWagon()) {
					isBlocked = true;
				}
			}
		}
		return isBlocked;
	}

	@Override
	public void resetGameTurn() {
		if(!checkEndGame()) { 
			getRoundPlayer().setTurn(true);
			getRoundPlayer().setMoves(3);
			getRoundPlayer().setMoveStatus(0);
			cubeLimit = 0;
			wareLimit = 0;
			takeCard  = 0;
			count     = 0;
		}else { 
			gameStatus = false;
			playerPanelUpdate();
			notifyEndGame(); 
			notifyMessage("The travel is over. All the merchantors reached their destination!");
			wagonTilesOwned();
			checkWinner();
			initializeBoard();
		}
	}
	
	@Override
	public boolean checkEndGame() {
		if(checkRomaMerchantPlace() || checkPortusMerchantPlace()) {
			return true;
		}else if(builderGameTable.getBag().getBagSize() == 0) {
			return true;
		}else if(getRoundPlayer().getVPoints() == 20) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checkRomaMerchantPlace() {
		int cont = 0;
		//Roma Side 
			for (int i = 0; i <= 0; i++) {
				for (int j = 2; j <= 6; j++) { 
					if (grid[j][i].getWagonSide() == 2) {
						wagonsTiles.add(grid[j][i].getImage());
						cont++;
					}
				}
			}  
			return (cont >= 4 ? true : false);  
	}
	
	@Override
	public boolean checkPortusMerchantPlace() {
		int cont = 0;  
			for (int i = 16; i <= 16; i++) {
				for (int j = 2; j <= 6; j++) { 
					if (grid[j][i].getWagonSide() == 1) {
						wagonsTiles.add(grid[j][i].getImage());
						cont++;
					}
				}
			}
			return (cont >= 4 ? true : false); 
	}
	
	@Override
	public void checkWinner() {  
		int[] fScore = new int [2];
		int cubes = 0;
		int wares = 0;
		int contracts = 0;
		
		for(int i=0; i<players.size();i++) {
			cubes = players.get(i).getCubes().size();
			wares = players.get(i).getWareTiles().size(); 
			contracts = sumContractPoints(players.get(i));
			
			contracts = contracts - (cubes - wares);
			fScore[i] = contracts + players.get(i).getScore();
		}
		
		//check tie
		if(fScore[0] == fScore[1]) {
			int p1 = players.get(0).getGold();
			int p2 = players.get(1).getGold();
			if(p1 == p2) {
				notifyMessage("You win!"+getRoundPlayer().getName());
			}else if(p1 > p2) {
				notifyMessage("You win! "+players.get(0).getName());
			}else {
				notifyMessage("You win! "+players.get(1).getName());
			} // check normal score
		}else if(fScore[0] > fScore[1]) { 
			notifyMessage("You win! "+players.get(0).getName()+"Final Score: "+fScore[0]); 
		}else {  
			notifyMessage("You win! "+players.get(1).getName()+"Final Score: "+fScore[1]);
		}	 
	}
	
	/**
	 * Check all the wagons tiles collected by players that reached the destination
	 */
	@Override
	public void wagonTilesOwned() {
		for(int i=0; i<players.size(); i++) {
			for(int j=0; j<wagonsTiles.size(); j++) {
				if(wagonsTiles.get(j).contains(players.get(i).getCards().get(i))) { 
					players.get(i).setScore(1);
					players.get(i).removeCard(players.get(i).getCards().get(i));
				}
			}
		} 
		checkWrongWagonTiles();
	}
	
	/**
	 *  Check all the player cards that not finished their path
	 */
	@Override
	public void checkWrongWagonTiles() {
		int total = 0;
		for(int i=0; i<players.size(); i++) {
			total = players.get(i).getCards().size();
			players.get(i).setScore(-total); 
		}
	}

	@Override
	public void playerPanelUpdate() {
		notifyPlayerPanelUpdate(getRoundPlayer().getScore(), getRoundPlayer().getGold(), getRoundPlayer().getVPoints(),
				getRoundPlayer().getCubes().size(), getRoundPlayer().getWareTiles().size(),
				getRoundPlayer().getContracts().size(), getRoundPlayer().getCards().size());
	}

	@Override
	public void notifyPlayerPanelUpdate(int score, int coins, int vp, int cubes, int wareTiles, int contracts, int cards) {
		observers.get(pos).playerPanelUpdate(score, coins, vp, cubes, wareTiles, contracts, cards);
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
		for (IObserver observer : observers) {
			observer.boardPanelUpdate();
			observer.endGame();
		}
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
