 package br.udesc.ppr55.sr.model;

import javax.swing.JPanel;

/**
 *
 * @author Rodrigo Valle
 */
public class Player {
	
    protected String name; 
    protected int score;
    protected JPanel panelPlayer;
    
    public Player(JPanel panel){ 
    	this.panelPlayer = panel; 
    	this.score = 0;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    } 
    
    public JPanel getPanel() {
    	return panelPlayer;
    }
    
    public void setPanel(JPanel panel) {
    	this.panelPlayer = panel;
    }
    
 
    
}
