package final_proj;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    // Add a card to the hand
    public void addCard(Card card) {
        if (cards.size() < 6) { // Assuming a hand limit of 6 cards
            cards.add(card);
        } else {
            System.out.println("Hand is full! Cannot add more cards.");
        }
    }

    // Remove a card from the hand
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    // Get a card by index
    public Card getCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index!");
    }

    // Return the number of cards in hand
    public int size() {
        return cards.size();
    }

    // Check if the hand is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Display all cards in hand
    public void showHand() {
        if (cards.isEmpty()) {
            System.out.println("Hand is empty.");
        } else {
            System.out.println("Cards in hand:");
            for (int i = 0; i < cards.size(); i++) {
                System.out.println((i + 1) + ": " + cards.get(i));
            }
        }
    }
}