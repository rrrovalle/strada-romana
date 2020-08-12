 /**
 * Player Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

package br.udesc.ppr55.sr.model;
import javax.swing.JPanel;
public class Player {
	
    protected String name; 
    protected int score;
    protected JPanel panelPlayer;
    
    public Player(JPanel panel, String name){ 
    	this.panelPlayer = panel; 
    	this.name = name;
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

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", panelPlayer=" + panelPlayer + "]";
	} 
    
}
