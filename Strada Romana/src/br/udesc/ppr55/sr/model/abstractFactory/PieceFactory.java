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
import br.udesc.ppr55.sr.model.wagons.BallioPortus;
import br.udesc.ppr55.sr.model.wagons.BallioRoma;
import br.udesc.ppr55.sr.model.wagons.CanopitesPortus;
import br.udesc.ppr55.sr.model.wagons.CanopitesRoma;
import br.udesc.ppr55.sr.model.wagons.CurculioPortus;
import br.udesc.ppr55.sr.model.wagons.CurculioRoma;
import br.udesc.ppr55.sr.model.wagons.Deck;
import br.udesc.ppr55.sr.model.wagons.DemetriusPortus;
import br.udesc.ppr55.sr.model.wagons.DemetriusRoma;
import br.udesc.ppr55.sr.model.wagons.HamilcarPortus;
import br.udesc.ppr55.sr.model.wagons.HamilcarRoma;
import br.udesc.ppr55.sr.model.wagons.HerenniusPortus;
import br.udesc.ppr55.sr.model.wagons.HerenniusRoma;
import br.udesc.ppr55.sr.model.wagons.MaccusPortus;
import br.udesc.ppr55.sr.model.wagons.MaccusRoma;
import br.udesc.ppr55.sr.model.wagons.PersaPortus;
import br.udesc.ppr55.sr.model.wagons.PersaRoma;
import br.udesc.ppr55.sr.model.wagons.PlotusPortus;
import br.udesc.ppr55.sr.model.wagons.PlotusRoma; 
import br.udesc.ppr55.sr.model.wagons.PseudolusPortus;
import br.udesc.ppr55.sr.model.wagons.PseudolusRoma;
import br.udesc.ppr55.sr.model.wagons.WagonCard;
import br.udesc.ppr55.sr.model.wagons.faceDownWagon;
import br.udesc.ppr55.sr.model.wareTiles.BlueWareTile;
import br.udesc.ppr55.sr.model.wareTiles.BrownWareTile;
import br.udesc.ppr55.sr.model.wareTiles.GreenWareTile;
import br.udesc.ppr55.sr.model.wareTiles.RedWareTile;
import br.udesc.ppr55.sr.model.wareTiles.WhiteWareTile;
import br.udesc.ppr55.sr.model.wareTiles.YellowWareTile;

public class PieceFactory extends AbstractPieceFactory{
 
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
	public Piece createBallioWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new BallioRoma();
		 }else{
			 return new BallioPortus();
		 }
	}

	@Override
	public Piece createCanopitesWagon(boolean isRomaSide) {
		 if(isRomaSide) { 
			 return new CanopitesRoma();
		 }else{
			 return new CanopitesPortus();
		 }
	}

	@Override
	public Piece createCurculioWagon(boolean isRomaSide) {
		 if(isRomaSide) { 
			 return new CurculioRoma();
		 }else{
			 return new CurculioPortus();
		 }
	}

	@Override
	public Piece createDemetriusWagon(boolean isRomaSide) {
		 if(isRomaSide) { 
			 return new DemetriusRoma();
		 }else{
			 return new DemetriusPortus();
		 }
	}

	@Override
	public Piece createHamilcarWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new HamilcarRoma();
		 }else{
			 return new HamilcarPortus();
		 }
	}

	@Override
	public Piece createHerenniusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new HerenniusRoma();
		 }else{
			 return new HerenniusPortus();
		 }
	}

	@Override
	public Piece createMaccusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new MaccusRoma();
		 }else{
			 return new MaccusPortus();
		 }
	}

	@Override
	public Piece createPersaWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PersaRoma();
		 }else{
			 return new PersaPortus();
		 }
	}

	@Override
	public Piece createPlotusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PlotusRoma();
		 }else{
			 return new PlotusPortus();
		 }
	}

	@Override
	public Piece createPseudolusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PseudolusRoma();
		 }else{
			 return new PseudolusPortus();
		 }
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
