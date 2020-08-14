 /**
 * Selection Frame to create Players Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.control.StradaController;
import br.udesc.ppr55.sr.view.command.CommandInvoker;
import br.udesc.ppr55.sr.view.command.stradaCommands.CreatePlayerPanelCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.PlayMusicCommand;
import br.udesc.ppr55.sr.view.command.stradaCommands.SetScreenSizeCommand;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants; 

public class SelectionFrame extends JFrame {

	private static final long serialVersionUID = -4650788474650177006L;

	/**
	 * Attributes
	 */	
	private JPanel contentPane;
	private JTextField txtPlayer1;
	private JTextField txtPlayer2; 
	private JCheckBox screenSize;
	
    private IStradaController stradaController;
    
    private CommandInvoker commandInvoker;
    private SetScreenSizeCommand ssc;
    private CreatePlayerPanelCommand cppc;
 
    public int players;
    
	/**
	 * Create the frame.
	 */
	public SelectionFrame() {
		setTitle("Strada Romana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100 ,200, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		stradaController = StradaController.getInstance(); 
		stradaController.setScreenSize(50);
		commandInvoker = new CommandInvoker();
		initComponents();
	}
	
	private void initComponents() {  
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emperors");
		lblNewLabel.setBounds(64, 16, 55, 16);
		lblNewLabel.setSize(70, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		txtPlayer1 = new JTextField();
		txtPlayer1.setBounds(38, 45, 116, 22);
		txtPlayer1.setText("Player 1");
		contentPane.add(txtPlayer1);
		txtPlayer1.setColumns(50);
		
		txtPlayer2 = new JTextField();
		txtPlayer2.setBounds(38, 80, 116, 22);
		txtPlayer2.setText("Player 2");
		contentPane.add(txtPlayer2);
		txtPlayer2.setColumns(50);
		
		screenSize = new JCheckBox();
		screenSize.setBounds(38, 110, 116, 22);
		screenSize.setText("High Quality");
		screenSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				  if(screenSize.isSelected()){
					 ssc = new SetScreenSizeCommand(stradaController, 100); 
	                     commandInvoker.add(ssc);
	                     commandInvoker.execute(); 
				  } else {
					 ssc = new SetScreenSizeCommand(stradaController, 50); 
	                     commandInvoker.add(ssc);
	                     commandInvoker.execute(); 
				  }
			}
		});
		contentPane.add(screenSize);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setBounds(64, 135, 55, 25);
		btnNewButton.setSize(50,25);
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerValidation()) {    
					setVisible(false); 
						 cppc = new CreatePlayerPanelCommand(stradaController, txtPlayer1.getText(), txtPlayer2.getText()); 
	                     commandInvoker.add(cppc);
	                     commandInvoker.execute(); 
					new GameFrame().setVisible(true);
				}
			}
		});
		contentPane.add(btnNewButton);
	}
	
	private boolean playerValidation() { 
			if(txtPlayer1.getText().equals("") || txtPlayer2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please, check all the obligatory fields.");
				return false;
		}
		return true;
	}
	
}
 
	 
		
		
