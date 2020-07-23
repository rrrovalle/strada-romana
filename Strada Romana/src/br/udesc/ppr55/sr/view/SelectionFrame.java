package br.udesc.ppr55.sr.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.midi.Soundbank;
import javax.swing.ButtonGroup;
import javax.swing.JButton; 
import javax.swing.JLabel; 
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class SelectionFrame extends JFrame {

	/**
	 * Attributes.
	 */
	private static final long serialVersionUID = -4650788474650177006L;
	private JPanel contentPane;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;
	private JRadioButton btnNero = new JRadioButton("Nero");
	private JRadioButton btnMarco = new JRadioButton("Marco Aurélio");
	private JRadioButton btnCaligula = new JRadioButton("Caligula");
	private JRadioButton btnAugusto = new JRadioButton("Augusto");
	
	/**
	 * Create the frame.
	 */
	public SelectionFrame() {
		setTitle("Strata Romana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		initComponents();
	}
	
	private void initComponents() { 
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{175, 0, 131, 0};
		gbl_contentPane.rowHeights = new int[]{16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane); 
		
		JLabel lblNewLabel = new JLabel("Choose your imperator");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player 1");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Player 2");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPlayer = new JTextField();
		GridBagConstraints gbc_txtPlayer = new GridBagConstraints();
		gbc_txtPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_txtPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer.gridx = 0;
		gbc_txtPlayer.gridy = 4;
		contentPane.add(txtPlayer, gbc_txtPlayer);
		txtPlayer.setColumns(10);
		
		txtPlayer_1 = new JTextField();
		GridBagConstraints gbc_txtPlayer_1 = new GridBagConstraints();
		gbc_txtPlayer_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlayer_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlayer_1.gridx = 2;
		gbc_txtPlayer_1.gridy = 4;
		contentPane.add(txtPlayer_1, gbc_txtPlayer_1);
		txtPlayer_1.setColumns(10);
		
		btnNero = new JRadioButton("Nero");
		btnNero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNero.isSelected()) {
					btnAugusto.setEnabled(false);
				}else {
					btnAugusto.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 5;
		contentPane.add(btnNero, gbc_rdbtnNewRadioButton);
		
		btnMarco = new JRadioButton("Marco");
		btnMarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnMarco.isSelected()) {
					btnCaligula.setEnabled(false);
				}else {
					btnCaligula.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 2;
		gbc_rdbtnNewRadioButton_2.gridy = 5;
		contentPane.add(btnMarco, gbc_rdbtnNewRadioButton_2);
		
		btnAugusto = new JRadioButton("Augusto");
		btnAugusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnAugusto.isSelected()) {
					btnNero.setEnabled(false);
				}else {
					btnNero.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 6; 
		contentPane.add(btnAugusto, gbc_rdbtnNewRadioButton_1);
		
		btnCaligula = new JRadioButton("Calígula");
		btnCaligula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnCaligula.isSelected()) {
					btnMarco.setEnabled(false);
				}else {
					btnMarco.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_3.gridx = 2;
		gbc_rdbtnNewRadioButton_3.gridy = 6; 
		contentPane.add(btnCaligula, gbc_rdbtnNewRadioButton_3);
		 
		JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerValidation()) {
				System.out.println("ok!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 9;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3); 


	}
	
	private boolean playerValidation() {  
		if(txtPlayer.getText().equals("") || txtPlayer_1.getText().equals("")) {
			System.out.println("Campos obrigatórios!");
			return false;
		}else if((btnAugusto.isSelected() || btnNero.isSelected()) && (btnCaligula.isSelected() || btnMarco.isSelected())) {
			System.out.println("Criou");
		}else {
			System.out.println("Ambos devem escolher um imperador!");
			return false;
		}
		return true;
	}
	
}
		
		
