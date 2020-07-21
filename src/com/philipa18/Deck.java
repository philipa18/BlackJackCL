package com.philipa18;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        // Populate deck with standard 52 cards
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                cards.add(new Card(suit, rank));
            }
        }

        // Shuffle cards
        Collections.shuffle(cards);
    }

    // Removes card at the "top"  of the deck (front of the arraylist) and returns it.
    public Card draw() {
        return cards.remove(cards.size()-1);
    }
}
