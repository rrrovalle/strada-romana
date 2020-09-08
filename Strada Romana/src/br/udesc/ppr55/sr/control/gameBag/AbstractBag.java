 /**
 * Command class Abstractbag
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.control.gameBag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import br.udesc.ppr55.sr.model.composite.Card;
 
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.wagons.faceDownWagon;
 
public abstract class AbstractBag {

	protected List<Piece> cubes        = new ArrayList<>();
	protected List<Piece> altCubes     = new ArrayList<>();
	protected List<Piece> wareTiles    = new ArrayList<>();
	protected List<Piece> wagonsRoma   = new ArrayList<>();
	protected List<Piece> wagonsPortus = new ArrayList<>();  
	protected List<Card> wagonsDeck    = new ArrayList<>();
	protected faceDownWagon discard    = new faceDownWagon();
	
	protected ArrayList<Piece> first;
	
	protected int bagSize;
	
	protected Random random; 

	/* set pieces to both sides */
	public List<Card> getDeck() {
		return wagonsDeck;
	}
	
	public List<Piece> getWagonsRoma() {
		return wagonsRoma;
	}
	
	public List<Piece> getWagonsPortus() {
		return wagonsPortus;
	}
	
	public List<Piece> getWareTiles() {
		return wareTiles;
	}
	
	public List<Piece> getCubes() {
		return cubes;
	}
	
	public List<Piece> getAltCubes() {
		return altCubes;
	}
	
	public int getBagSize() {
		return bagSize;
	}

	/* access methods */
	public void setDeck(List<Card> wagons) {
		this.wagonsDeck = wagons;
	}
	
	public void setWagonRomaList(List<Piece> romaPieces) {
		this.wagonsRoma = romaPieces;
	}
	
	public void setWagonPortusList(List<Piece> portusPieces) {
		this.wagonsPortus = portusPieces;
	}  
	
	public void setWareTileList(List<Piece> wareTiles) {
		this.wareTiles = wareTiles;
	}
	
	public void setCubeList(List<Piece> cubes) {
		this.cubes = cubes;
	}
	
	public void setAltCubeList(List<Piece> altCubes) {
		this.altCubes = altCubes;
	}
	
	public void addPiece(int pieces) {
		this.bagSize += pieces;
	}
	
	public List<Piece> shufflePieces(List<Piece> pieces) {
		random = new Random(); 
		Collections.shuffle(Arrays.asList(pieces));
		
		return pieces;
	}
	
	public List<Card> shuffleCards(List<Card> deck) {
		random = new Random(); 
		Collections.shuffle(Arrays.asList(deck));
		
		return deck;
	}
	
	public void loadFirstWareTiles() { 
		first = new ArrayList<>();
		first.addAll(Arrays.asList(wareTiles.get(5),wareTiles.get(11),wareTiles.get(17),wareTiles.get(23),wareTiles.get(29),wareTiles.get(35)));
		
	}
	
	public abstract Piece getPortusWagon();
	public abstract Piece getRomaWagon();
	public abstract Piece getRandomWareTile(int number);
	public abstract Piece getWareTile(int number);
	public abstract Piece getCube();
	public abstract Piece getAltCube();
	public abstract Piece removeCard();
}
