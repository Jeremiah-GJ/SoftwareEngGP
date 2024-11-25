package gui;

import java.util.ArrayList;

public class Deck {
	
	
	public ArrayList<Card> deck;
	public ArrayList<Card> RemovedCards;
	
	public Deck(ArrayList<Card> deck) {
		
		this.deck = deck;
		
	}
	
	public ArrayList<Card> getDeck(){
		
		return deck;
	}
	
	
	public int getLen() {
		
		return deck.size();
		
	}
	
	public Card drawCard() {
		
		Card tc = deck.get(0);
		deck.remove(0);
		RemovedCards.add(tc);
		
		return tc;
		
	}
	
	
	public void resetDeck() {
		
		deck.addAll(RemovedCards);
		
	}
	
	

}
