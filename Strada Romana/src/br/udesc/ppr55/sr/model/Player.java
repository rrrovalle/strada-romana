 package br.udesc.ppr55.sr.model;

/**
 *
 * @author Rodrigo Valle
 */
public class Player {
	
    protected String name;
    protected String imperator;
    protected int score;
    
    public Player(String name, String imperator, int score){
        this.name = name;
        this.imperator = imperator;
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

    public String getImperator() {
        return imperator;
    }

    public void setImperator(String imperator) {
        this.imperator = imperator;
    }
    
    
}
