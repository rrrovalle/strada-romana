package br.udesc.ppr55.sr.view.command;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import br.udesc.ppr55.sr.control.IStradaController; 

@SuppressWarnings("serial")
public class WagonFrame extends JFrame {
	class StradaTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 1;	
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try { 
                return new ImageIcon(stradaController.getWagon(rowIndex, columnIndex));
            } catch (Exception e) { 
            	e.printStackTrace();
                return null;
            }
        }

    }
	 
    class StradaRender extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        	setIcon((ImageIcon) value);
            return this;
       }
    }
    
    private IStradaController stradaController; 
    private JTable gameBoard;

    public WagonFrame(IStradaController stradaController) {
        this.stradaController = stradaController;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        this.initComponents();
        this.addComponents();
    }

    private void addComponents() {
        this.add(gameBoard);
    } 

    private void initComponents() {
        gameBoard = new JTable();
        gameBoard.setModel(new StradaTableModel());

        for (int x = 0; x < gameBoard.getColumnModel().getColumnCount(); x++) { 
            gameBoard.getColumnModel().getColumn(x).setWidth(100);
            gameBoard.getColumnModel().getColumn(x).setMinWidth(100);
            gameBoard.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        gameBoard.setRowHeight(100);
        gameBoard.setShowGrid(false);
        gameBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gameBoard.setIntercellSpacing(new Dimension(0, 0));
        gameBoard.setDefaultRenderer(Object.class, new StradaRender());
        gameBoard.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Pegou");
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		} );
    }
 
}
