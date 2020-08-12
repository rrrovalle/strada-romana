 package br.udesc.ppr55.sr.model.builder;

import java.util.Arrays;
import java.util.Collections;

import br.udesc.ppr55.sr.model.Piece;
import br.udesc.ppr55.sr.model.abstractFactory.AbstractPieceFactory;
import br.udesc.ppr55.sr.model.cubes.CubeType; 

/**
 * Concrete builder to create the board
 * @Builder
 * @author Rodrigo Valle
 */
public class BuildGameTable extends Builder {
	 
    @Override
    public void buildStradaBoard(AbstractPieceFactory factory) {
        tablePiece = new Piece[9][17];
        
        // Set the background tiles
        for( int line = 0; line < tablePiece.length; line++) {
            for( int column = 0; column < tablePiece[line].length; column++) {
                tablePiece[line][column] = factory.createGroundTile();
            }
          }
         
        // Add strada romana tiles
        tablePiece[2][0] = factory.createWagonTilePortus();
        tablePiece[3][0] = factory.createWagonTilePortus();
        tablePiece[4][0] = factory.createWagonTilePortus();
        tablePiece[5][0] = factory.createWagonTilePortus();
        tablePiece[6][0] = factory.createWagonTilePortus();
        
        tablePiece[2][1] = factory.createStradaTile();
        tablePiece[4][1] = factory.createStradaTile();
        tablePiece[6][1] = factory.createStradaTile();
        tablePiece[7][1] = factory.createLineTile();
        tablePiece[8][1] = factory.createCubeSpotTile();
        
        tablePiece[1][2] = factory.createInverseCubeTile();
        tablePiece[2][2] = factory.createLineTile();
        tablePiece[3][2] = factory.createStradaTile();
        tablePiece[5][2] = factory.createStradaTile();

        tablePiece[2][3] = factory.createStradaTile();
        tablePiece[4][3] = factory.createStradaTile();
        tablePiece[5][3] = factory.createLineTile();
        tablePiece[6][3] = factory.createCubeSpotTile();
        tablePiece[8][3] = factory.createWareSpotTile(1);
        
        tablePiece[0][4] = factory.createWareSpotTile(2);
        tablePiece[3][4] = factory.createStradaTile();
        tablePiece[5][4] = factory.createStradaTile();
        
        tablePiece[1][5] = factory.createInverseCubeTile();
        tablePiece[2][5] = factory.createLineTile();
        tablePiece[3][5] = factory.createStradaTile();
        tablePiece[5][5] = factory.createStradaTile();
        tablePiece[6][5] = factory.createLineTile();
        tablePiece[7][5] = factory.createCubeSpotTile();
        
        tablePiece[4][6] = factory.createRomaTile();
        tablePiece[6][6] = factory.createRomaTile();

        tablePiece[1][7] = factory.createInverseCubeTile();
        tablePiece[2][7] = factory.createLineTile();
        tablePiece[3][7] = factory.createRomaTile();
        tablePiece[5][7] = factory.createRomaTile();
        
        tablePiece[0][8] = factory.createWareSpotTile(3);
        tablePiece[3][8] = factory.createRomaTile();
        tablePiece[5][8] = factory.createRomaTile();
        tablePiece[6][8] = factory.createLineTile();
        tablePiece[7][8] = factory.createCubeSpotTile();
        
        tablePiece[4][9] = factory.createRomaTile();
        
        tablePiece[1][10] = factory.createInverseCubeTile();
        tablePiece[2][10] = factory.createLineTile();
        tablePiece[3][10] = factory.createRomaTile();
        tablePiece[5][10] = factory.createRomaTile();
        tablePiece[8][10] = factory.createWareSpotTile(4);
        
        tablePiece[2][11] = factory.createStradaTile();
        tablePiece[4][11] = factory.createStradaTile();
        tablePiece[6][11] = factory.createStradaTile();
        tablePiece[7][11] = factory.createLineTile();
        tablePiece[8][11] = factory.createCubeSpotTile();

        tablePiece[1][12] = factory.createInverseCubeTile();
        tablePiece[2][12] = factory.createLineTile();
        tablePiece[3][12] = factory.createStradaTile();
        tablePiece[5][12] = factory.createStradaTile();
        tablePiece[6][12] = factory.createLineTile();
        tablePiece[7][12] = factory.createCubeSpotTile();
        
        tablePiece[1][13] = factory.createInverseCubeTile(); 
        tablePiece[2][13] = factory.createLineTile();
        tablePiece[3][13] = factory.createStradaTile();
        tablePiece[5][13] = factory.createStradaTile();
        
        tablePiece[0][14] = factory.createWareSpotTile(5);
        tablePiece[4][14] = factory.createStradaTile();
        tablePiece[6][14] = factory.createStradaTile();
        tablePiece[8][14] = factory.createWareSpotTile(6);
        
        tablePiece[1][15] = factory.createInverseCubeTile();
        tablePiece[2][15] = factory.createLineTile();
        tablePiece[3][15] = factory.createStradaTile();
        tablePiece[5][15] = factory.createStradaTile();
        tablePiece[6][15] = factory.createLineTile();
        tablePiece[7][15] = factory.createCubeSpotTile();
        
        tablePiece[2][16] = factory.createWagonTileRoma();
        tablePiece[3][16] = factory.createWagonTileRoma();
        tablePiece[4][16] = factory.createWagonTileRoma();
        tablePiece[5][16] = factory.createWagonTileRoma();
        tablePiece[6][16] = factory.createWagonTileRoma();
        
        super.table.setGrid(tablePiece);
    }
    
    @Override 
    public void buildWagons(AbstractPieceFactory factory) { 
    	tablePiece = super.getTable().getGrid();
    	
    	Piece[] portusSide = {factory.createBallioWagon(true), factory.createDemetriusWagon(true),
				factory.createCanopitesWagon(true), factory.createCurculioWagon(true),
				factory.createHamilcarWagon(true), factory.createMaccusWagon(true),
				factory.createPersaWagon(true), factory.createPlotusWagon(true),
				factory.createPseudolusWagon(true), factory.createHerenniusWagon(true)
				};
    	
		Piece[] romaSide = {factory.createBallioWagon(false), factory.createDemetriusWagon(false),
				 factory.createCanopitesWagon(false), factory.createCurculioWagon(false),
				 factory.createHamilcarWagon(false), factory.createMaccusWagon(false),
				 factory.createPersaWagon(false), factory.createPlotusWagon(false),
				 factory.createPseudolusWagon(false), factory.createHerenniusWagon(false)
				 };
    	
    	Collections.shuffle(Arrays.asList(romaSide));
		Collections.shuffle(Arrays.asList(portusSide));  
     
    	
        super.table.setGrid(tablePiece);
    	
    }
    
    @Override
    public void buildGameBag(AbstractPieceFactory factory) { }
}
