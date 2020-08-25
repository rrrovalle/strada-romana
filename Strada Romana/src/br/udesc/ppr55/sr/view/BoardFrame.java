 /**
 * BoardFrame Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view;    
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
import javax.swing.BoxLayout; 
import javax.swing.ImageIcon; 
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel; 
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import br.udesc.ppr55.sr.control.InterfaceStradaC;
import br.udesc.ppr55.sr.utils.ImageRenderer;  
 
@SuppressWarnings("serial")
public class BoardFrame extends JPanel {
	 
    class StradaTableModel extends AbstractTableModel { 
        private static final long serialVersionUID = 1L;
 
        @Override
        public int getRowCount() {
            return 9;
        } 

        @Override
        public int getColumnCount() {
            return 18;    
        }
 
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try { 
                return new ImageIcon(stradaController.getPiece(rowIndex, columnIndex));
            } catch (Exception e) { 
                e.printStackTrace();
                return null;
            }
        }
    }
     
    class StradaRender extends DefaultTableCellRenderer { 

        private static final long serialVersionUID = 1L;
        
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(ImageRenderer.resizeImage((ImageIcon)value, screenSize, screenSize));
            return this;
       }
    }
    
    private InterfaceStradaC stradaController; 
    private JTable gameBoard;
    
    protected int screenSize; 
	public int iCol; //first column
    public int iRow; //first row
    
    public BoardFrame(InterfaceStradaC stradaController) {
        this.stradaController = stradaController;
        this.screenSize = stradaController.getScreenSize();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        this.initComponents();
        this.addComponents();
    } 

    private void addComponents() {
        this.add(gameBoard);
    } 
    
    public void update() {
        this.updateUI();
    } 

    private void initComponents() {
        gameBoard = new JTable();
        gameBoard.setModel(new StradaTableModel());
        for (int x = 0; x < gameBoard.getColumnModel().getColumnCount(); x++) { 
            gameBoard.getColumnModel().getColumn(x).setWidth(screenSize);
            gameBoard.getColumnModel().getColumn(x).setMinWidth(screenSize);
            gameBoard.getColumnModel().getColumn(x).setMaxWidth(screenSize);
        }
        gameBoard.setRowHeight(screenSize);
        gameBoard.setShowGrid(false);
        gameBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gameBoard.setIntercellSpacing(new Dimension(0, 0));
        gameBoard.setDefaultRenderer(Object.class, new StradaRender());   
        gameBoard.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                iCol  = gameBoard.getSelectedColumn();
                iRow  = gameBoard.getSelectedRow();  
             }	

            @Override
            public void mouseReleased(MouseEvent e) { 
               stradaController.gameFlow( iCol,  iRow, gameBoard.getSelectedColumn(), gameBoard.getSelectedRow());
            }  
		});  
    }
    }
     