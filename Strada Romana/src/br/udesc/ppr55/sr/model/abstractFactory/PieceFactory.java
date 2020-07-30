package br.udesc.ppr55.sr.model.abstractFactory;

import br.udesc.ppr55.sr.model.Bag;
import br.udesc.ppr55.sr.model.BallioPortus;
import br.udesc.ppr55.sr.model.BallioRoma;
import br.udesc.ppr55.sr.model.CanopitesPortus;
import br.udesc.ppr55.sr.model.CanopitesRoma;
import br.udesc.ppr55.sr.model.CurculioPortus;
import br.udesc.ppr55.sr.model.CurculioRoma;
import br.udesc.ppr55.sr.model.DemetriusPortus;
import br.udesc.ppr55.sr.model.DemetriusRoma;
import br.udesc.ppr55.sr.model.HamilcarPortus;
import br.udesc.ppr55.sr.model.HamilcarRoma;
import br.udesc.ppr55.sr.model.HerenniusPortus;
import br.udesc.ppr55.sr.model.HerenniusRoma;
import br.udesc.ppr55.sr.model.MaccusPortus;
import br.udesc.ppr55.sr.model.MaccusRoma;
import br.udesc.ppr55.sr.model.PersaPortus;
import br.udesc.ppr55.sr.model.PersaRoma;
import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.PlotusPortus;
import br.udesc.ppr55.sr.model.PlotusRoma;
import br.udesc.ppr55.sr.model.PseudolousPortus;
import br.udesc.ppr55.sr.model.PseudolousRoma;

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
	public Piece createCube() { 
		return null;
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
		 }else {
			 return new BallioPortus();
		 }
	}

	@Override
	public Piece createCanopitesWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new CanopitesRoma();
		 }else {
			 return new CanopitesPortus();
		 }
	}

	@Override
	public Piece createCurculioWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new CurculioRoma();
		 }else {
			 return new CurculioPortus();
		 }
	}

	@Override
	public Piece createDemetriusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new DemetriusRoma();
		 }else {
			 return new DemetriusPortus();
		 }
	}

	@Override
	public Piece createHamilcarWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new HamilcarRoma();
		 }else {
			 return new HamilcarPortus();
		 }
	}

	@Override
	public Piece createHerenniusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new HerenniusRoma();
		 }else {
			 return new HerenniusPortus();
		 }
	}

	@Override
	public Piece createMaccusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new MaccusRoma();
		 }else {
			 return new MaccusPortus();
		 }
	}

	@Override
	public Piece createPersaWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PersaRoma();
		 }else {
			 return new PersaPortus();
		 }
	}

	@Override
	public Piece createPlotusWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PlotusRoma();
		 }else {
			 return new PlotusPortus();
		 }
	}

	@Override
	public Piece createPseudolousWagon(boolean isRomaSide) {
		 if(isRomaSide) {
			 return new PseudolousRoma();
		 }else {
			 return new PseudolousPortus();
		 }
	}

	@Override
	public Piece chooseWagon() { 
		return null;
	}
    
}
