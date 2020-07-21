package com.philipa18;


public class Card {
    // 0, 1, 2, & 3 maps to Hearts, Diamonds, Clubs, & Spades
    private final int suit;
    // [1,13] maps to [Ace, King]
    private final int rank;
    // Determines if player can see face of card
    boolean faceUp = true;

    private final static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private final static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    // If card is hidden, [-FACE DOWN-] is returned, if not. Format {Rank} of {Suit} is returned
    public String toString() {
        return faceUp ?  "["+ ranks[rank - 1] + " of " + suits[suit]+"]"
                : "[-FACE DOWN-]";
    }
}
