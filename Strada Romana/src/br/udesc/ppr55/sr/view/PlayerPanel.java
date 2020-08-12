 /**
 * PlayerPanel Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */
package br.udesc.ppr55.sr.view; 
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory; 
import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 5040820868743358336L;
	
	private JLabel lbName;
	private JLabel lbScore; 
	private JButton btnPass;
	private JButton btnBag;  
	
	public PlayerPanel() {  
		super(); 
		this.setLayout(new BorderLayout(15,15));
		
		initializeComponents();
	} 
	
	public void initializeComponents() {
		lbName = new JLabel(); 
		lbScore = new JLabel("Score: 0"); 
		btnPass = new JButton("Pass");
		btnBag = new JButton("Bag"); 
		this.add(lbName, BorderLayout.NORTH);
		this.add(btnBag,BorderLayout.CENTER);
		this.add(btnPass, BorderLayout.SOUTH);
		this.add(lbScore, BorderLayout.WEST);
		this.setBorder(BorderFactory.createLineBorder(Color.black)); 
	}
	
	public void setName(String name) {
		this.lbName.setText("Player: "+name);
	}    
}
