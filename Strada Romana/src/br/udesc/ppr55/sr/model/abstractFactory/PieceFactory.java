package br.udesc.ppr55.sr.model.abstractFactory;

import br.udesc.ppr55.sr.model.Bag;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.components.CubeSpotTile;
import br.udesc.ppr55.sr.model.components.GroundTile;
import br.udesc.ppr55.sr.model.components.InverseCubeSpot;
import br.udesc.ppr55.sr.model.components.LineTile;
import br.udesc.ppr55.sr.model.components.RomaTile;
import br.udesc.ppr55.sr.model.components.StradaTile;
import br.udesc.ppr55.sr.model.components.WagonTile;
import br.udesc.ppr55.sr.model.components.WareSpotTile;
import br.udesc.ppr55.sr.model.cubes.CubeType;
import br.udesc.ppr55.sr.model.cubes.MarketCube;
import br.udesc.ppr55.sr.model.wagons.BallioPortus;
import br.udesc.ppr55.sr.model.wagons.BallioRoma;
import br.udesc.ppr55.sr.model.wagons.CanopitesPortus;
import br.udesc.ppr55.sr.model.wagons.CanopitesRoma;
import br.udesc.ppr55.sr.model.wagons.CurculioPortus;
import br.udesc.ppr55.sr.model.wagons.CurculioRoma;
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
import br.udesc.ppr55.sr.model.wagons.PseudolousPortus;
import br.udesc.ppr55.sr.model.wagons.PseudolousRoma;

/**
 * Piece Factory class
 * @author Rodrigo Valle
 * @since 15/07/2020
 * @version 1.0
 */
public class PieceFactory extends AbstractPieceFactory{

	@Override
	public Piece createBag() {
		return new Bag(); 
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
	public Piece createWagonTile() {
		return new WagonTile(); 
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
	public Piece createCube(CubeType cubeType) { 
		return new MarketCube(cubeType);
	}

	@Override
	public Piece createWareTile() { 
		return null;
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
	public Piece createPseudolousWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PseudolousRoma();
		 }else{
			 return new PseudolousPortus();
		 }
	}

	@Override
	public Piece chooseWagon() { 
		return null;
	}
    
}
