package br.udesc.ppr55.sr.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.udesc.ppr55.sr.control.IStradaController;
import br.udesc.ppr55.sr.control.StradaController;
 
import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class SelectionFrame extends JFrame {

	private static final long serialVersionUID = -4650788474650177006L;

	/**
	 * Attributes.
	 */	
	private JPanel contentPane;
	private JTextField txtPlayer2;
	private JTextField txtPlayer1;
	private JTextField txtPlayer4;
	
    private IStradaController stradaController;
     
	private JButton btnPlayers;
	private JTextField txtPlayer3;
	private JTextField txtPlayer5;
    public int players;
    
	/**
	 * Create the frame.
	 */
	public SelectionFrame() {
		setTitle("Strada Romana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		stradaController = new StradaController();
		players = 0;
		initComponents();
	}
	
	private void initComponents() {  
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{175, 0, 131, 0};
		gbl_contentPane.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Emperors");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtPlayer1 = new JTextField();
		txtPlayer1.setText("Player 1");
		GridBagConstraints gbc_txtPlayer1 = new GridBagConstraints();
		gbc_txtPlayer1.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer1.gridx = 1;
		gbc_txtPlayer1.gridy = 3;
		contentPane.add(txtPlayer1, gbc_txtPlayer1);
		txtPlayer1.setColumns(10);
		
		txtPlayer2 = new JTextField();
		txtPlayer2.setText("Player 2");
		GridBagConstraints gbc_txtPlayer2 = new GridBagConstraints();
		gbc_txtPlayer2.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer2.gridx = 1;
		gbc_txtPlayer2.gridy = 4;
		contentPane.add(txtPlayer2, gbc_txtPlayer2);
		txtPlayer2.setColumns(10);
		
		txtPlayer3 = new JTextField();
		txtPlayer3.setText("Player 3");
		GridBagConstraints gbc_txtPlayer3 = new GridBagConstraints();
		gbc_txtPlayer3.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer3.gridx = 1;
		gbc_txtPlayer3.gridy = 5;
		contentPane.add(txtPlayer3, gbc_txtPlayer3);
		txtPlayer3.setColumns(10);
		
		txtPlayer4 = new JTextField();
		txtPlayer4.setText("Player 4");
		GridBagConstraints gbc_txtPlayer4 = new GridBagConstraints();
		gbc_txtPlayer4.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer4.gridx = 1;
		gbc_txtPlayer4.gridy = 6;
		contentPane.add(txtPlayer4, gbc_txtPlayer4);
		txtPlayer4.setColumns(10);
		
		txtPlayer5 = new JTextField();
		txtPlayer5.setText("Player 5");
		GridBagConstraints gbc_txtPlayer5 = new GridBagConstraints();
		gbc_txtPlayer5.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer5.gridx = 1;
		gbc_txtPlayer5.gridy = 7;
		contentPane.add(txtPlayer5, gbc_txtPlayer5);
		txtPlayer5.setColumns(10); 
		
		btnPlayers = new JButton("Set Players");
		btnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
					players = Integer.parseInt(JOptionPane.showInputDialog(null,"How many players?"));
					
					if(players == 2) {
							txtPlayer1.setEnabled(true);
							txtPlayer2.setEnabled(true);
							txtPlayer3.setEnabled(false);
							txtPlayer3.setText("");
							txtPlayer4.setEnabled(false);
							txtPlayer4.setText("");
							txtPlayer5.setEnabled(false);
							txtPlayer5.setText("");
							players = 2;
					} else if (players == 3) {
							txtPlayer1.setEnabled(true);
							txtPlayer2.setEnabled(true);
							txtPlayer3.setEnabled(true);
							txtPlayer4.setEnabled(false);
							txtPlayer4.setText("");
							txtPlayer5.setEnabled(false); 
							txtPlayer5.setText("");
							players = 3;
					} else if(players == 4) { 
							txtPlayer1.setEnabled(true);
							txtPlayer2.setEnabled(true);
							txtPlayer3.setEnabled(true);
							txtPlayer4.setEnabled(true);
							txtPlayer5.setEnabled(false); 
							txtPlayer5.setText("");
							players = 4;
					} else {
							txtPlayer1.setEnabled(true);
							txtPlayer2.setEnabled(true);
							txtPlayer3.setEnabled(true);
							txtPlayer4.setEnabled(true);
							txtPlayer5.setEnabled(true); 
							players = 5;
				}
			}
		});
		GridBagConstraints gbc_btnPlayers = new GridBagConstraints();
		gbc_btnPlayers.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlayers.gridx = 2;
		gbc_btnPlayers.gridy = 1;
		contentPane.add(btnPlayers, gbc_btnPlayers);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerValidation()) {    
					setVisible(false);
					new Principal();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		contentPane.add(btnNewButton, gbc_btnNewButton);

	}
	
	private boolean playerValidation() {
		if(players == 1 || players == 2) { 
			if(txtPlayer1.getText().equals("") || txtPlayer2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please, check all the obligatory fields.");
				return false;
			}else {
				return true;
			}
		} else if (players == 3) { 
			if(txtPlayer1.getText().equals("") || txtPlayer2.getText().equals("") || txtPlayer3.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please, check all the obligatory fields.");
				return false;
			}else {
				return true;
			}
		} else if(players == 4) {  
			if(txtPlayer1.getText().equals("") || txtPlayer2.getText().equals("") || txtPlayer3.getText().equals("") || txtPlayer4.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please, check all the obligatory fields.");
				return false;
			}else {
				return true;
			}
		} else { 
			if(txtPlayer1.getText().equals("") || txtPlayer2.getText().equals("") || txtPlayer3.getText().equals("") || txtPlayer4.getText().equals("") || txtPlayer5.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please, check all the obligatory fields.");
				return false;
			}else {
				return true;
			}
		}
	}

 
	
}
		
		
