package br.udesc.ppr55.sr.model.composite;

import java.util.ArrayList;
import java.util.List; 

/**
 * Composite class
 */
public class DeckComposite implements Card {

	private List<Card> deck = new ArrayList<>(); 
	
	public DeckComposite(List<Card> deck) {
		this.deck = deck;
	}
	
	public void add(Card card) {
		deck.add(card);
	}
	
	public Card findByName(String cardName) { 
		for(Card card: deck) {
			if(card.getName().equalsIgnoreCase(cardName)) {
				return card;
			} 
		} 
		return null;
	}
	
	public void remove(Card card) {
		deck.remove(card);
	}
	
	public List<Card> getDeck(){
		return this.deck;
	}
	
	public int count() {
		return deck.size();
	}

	protected void printThisBefore() {}

	protected void printThisAfter() {}

	/**
	 * Print.
	 */
	public void print() {
		for(Card card: deck) {
			System.out.println(card.getCard());
		}
	}

	@Override
	public String getCard() { 
		return null;
	}

	@Override
	public String getName() { 
		return null;
	} 
}