package br.udesc.ppr55.sr.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rodrigo Valle
 */
public class LoadFrame extends JFrame {
    
        public LoadFrame(){
            this.setTitle("Strada Romana");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(380,370);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            add(new JLabel("Carregando..",JLabel.CENTER));
            setVisible(true); 
            setVisible(false);
            new Principal();
            
        } 
}
