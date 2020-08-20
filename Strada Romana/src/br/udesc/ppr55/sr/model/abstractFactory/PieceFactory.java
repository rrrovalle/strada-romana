/**
* Piece Factory Class
* @author Rodrigo Valle e Robson de Jesus
* @since 12/08/2020
* @version 1.0
*/
package br.udesc.ppr55.sr.model.abstractFactory;

import br.udesc.ppr55.sr.model.Piece; 
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.DeckTile;
import br.udesc.ppr55.sr.model.components.GroundTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.components.LineTile;
import br.udesc.ppr55.sr.model.components.RomaTile;
import br.udesc.ppr55.sr.model.components.StradaTile;
import br.udesc.ppr55.sr.model.components.WagonTilePortus;
import br.udesc.ppr55.sr.model.components.WagonTileRoma;
import br.udesc.ppr55.sr.model.components.WareSpotTile;
import br.udesc.ppr55.sr.model.cubes.BlueCube;
import br.udesc.ppr55.sr.model.cubes.BrownCube;
import br.udesc.ppr55.sr.model.cubes.GreenCube;
import br.udesc.ppr55.sr.model.cubes.RedCube;
import br.udesc.ppr55.sr.model.cubes.WhiteCube;
import br.udesc.ppr55.sr.model.cubes.YellowCube;
import br.udesc.ppr55.sr.model.wagons.Ballio;
import br.udesc.ppr55.sr.model.wagons.Canopites;
import br.udesc.ppr55.sr.model.wagons.Curculio;
import br.udesc.ppr55.sr.model.wagons.Deck;
import br.udesc.ppr55.sr.model.wagons.Demetrius;
import br.udesc.ppr55.sr.model.wagons.Hamilcar;
import br.udesc.ppr55.sr.model.wagons.Herennius;
import br.udesc.ppr55.sr.model.wagons.Maccus;
import br.udesc.ppr55.sr.model.wagons.Persa;
import br.udesc.ppr55.sr.model.wagons.Plotus;
import br.udesc.ppr55.sr.model.wagons.Pseudolus;
import br.udesc.ppr55.sr.model.wagons.WagonCard;
import br.udesc.ppr55.sr.model.wagons.faceDownWagon;
import br.udesc.ppr55.sr.model.wareTiles.BlueWareTile;
import br.udesc.ppr55.sr.model.wareTiles.BrownWareTile;
import br.udesc.ppr55.sr.model.wareTiles.GreenWareTile;
import br.udesc.ppr55.sr.model.wareTiles.RedWareTile;
import br.udesc.ppr55.sr.model.wareTiles.WhiteWareTile;
import br.udesc.ppr55.sr.model.wareTiles.YellowWareTile;

public class PieceFactory extends AbstractPieceFactory {

	@Override
	public Piece createDeckTile() {
		return new DeckTile();
	}

	@Override
	public Piece createGroundTile() {
		return new GroundTile();
	}

	@Override
	public Piece createRomaTile() {
		return new RomaTile();
	}

	@Override
	public Piece createWagonTilePortus() {
		return new WagonTilePortus();
	}

	@Override
	public Piece createWagonTileRoma() {
		return new WagonTileRoma();
	}

	@Override
	public Piece createCubeSpotTile() {
		return new CubeSpotTile();
	}

	@Override
	public Piece createInverseCubeTile() {
		return new InverseCubeSpot();
	}

	@Override
	public Piece createLineTile() {
		return new LineTile();
	}

	@Override
	public Piece createWareSpotTile(int number) {
		return new WareSpotTile(number);
	}

	@Override
	public Piece createStradaTile() {
		return new StradaTile();
	}

	@Override
	public Piece createBlueCube(int alt) {
		return new BlueCube(alt);
	}

	@Override
	public Piece createGreenCube(int alt) {
		return new GreenCube(alt);
	}

	@Override
	public Piece createYellowCube(int alt) {
		return new YellowCube(alt);
	}

	@Override
	public Piece createBrownCube(int alt) {
		return new BrownCube(alt);
	}

	@Override
	public Piece createRedCube(int alt) {
		return new RedCube(alt);
	}

	@Override
	public Piece createWhiteCube(int alt) {
		return new WhiteCube(alt);
	}

	@Override
	public Piece createBlueWareTile() {
		return new BlueWareTile();
	}

	@Override
	public Piece createBrownWareTile() {
		return new BrownWareTile();
	}

	@Override
	public Piece createGreenWareTile() {
		return new GreenWareTile();
	}

	@Override
	public Piece createRedWareTile() {
		return new RedWareTile();
	}

	@Override
	public Piece createWhiteWareTile() {
		return new WhiteWareTile();
	}

	@Override
	public Piece createYellowWareTile() {
		return new YellowWareTile();
	}

	@Override
	public Piece createContract() {
		return null;
	}

	@Override
	public Piece createBallioWagon(int side) {
		return new Ballio(side);
	}

	@Override
	public Piece createCanopitesWagon(int side) {
		return new Canopites(side);
	}

	@Override
	public Piece createCurculioWagon(int side) {
		return new Curculio(side);
	}

	@Override
	public Piece createDemetriusWagon(int side) {
		return new Demetrius(side);
	}

	@Override
	public Piece createHamilcarWagon(int side) {
		return new Hamilcar(side);
	}

	@Override
	public Piece createHerenniusWagon(int side) {
		return new Herennius(side);
	}

	@Override
	public Piece createMaccusWagon(int side) {
		return new Maccus(side);
	}

	@Override
	public Piece createPersaWagon(int side) {
		return new Persa(side);
	}

	@Override
	public Piece createPlotusWagon(int side) {
		return new Plotus(side);
	}

	@Override
	public Piece createPseudolusWagon(int side) {
		return new Pseudolus(side);
	}

	@Override
	public Piece createDeck() {
		return new Deck();
	}

	@Override
	public Piece createCard(int number) {
		return new WagonCard(number);
	}

	@Override
	public Piece createSpqrCard() {
		return new faceDownWagon();
	}
}
