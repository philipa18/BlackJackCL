package com.philipa18;

import com.philipa18.hands.Hand;
import com.philipa18.hands.HittableHand;

import java.util.ArrayList;
import java.util.Arrays;

// We'll have dealer just stand on 17 for now
public class Dealer {
    private Hand dealerHand;
    private boolean hits17;
    private Card hidden;
    private Deck deck;

    public Dealer(Deck deck, boolean hits17) {
        this.deck = deck;
        // Draw cards before creating hand so we can hide second one
        Card card1 = deck.draw();
        Card card2 = deck.draw();
        card2.flip();
        this.hits17 = hits17;
        this.hidden = card2;
        this.dealerHand = new HittableHand(new ArrayList<>(Arrays.asList(card1, card2)));
    }
    public void playHand() {
        // Dealers hidden card and point total is revealed.
        hidden.flip();
        System.out.println("Dealer shows hand: " + toString());
        ArrayList<Card> cards = dealerHand.getHand();

        // Hit and print hand until point value is 17 or over
        while(getPoints() < 17) {
            cards.add(deck.draw());
            System.out.println("Dealer hits. Hand is now: " + toString());
        }

        // Check to see if dealer is busted before standing
        if (getPoints() > 21) System.out.println("Dealer Busts!");
        else System.out.println("Dealer stands. Dealer hand is " + getPoints());
    }

    //Returns value of hand in same manner as player.getPoints()
    public int getPoints() {
        int sum = 0;
        int numAces = 0;
        ArrayList<Card> cards = dealerHand.getHand();

        for (Card card:cards) {
            sum += Math.min(card.getRank(), 10);
            if (card.getRank() == 1) numAces++;
        }

        while (numAces > 0 && sum < 11) {
            numAces--;
            sum+= 11;
        }
        return sum;
    }

    // Returns String of cards in hand, with point total if all are facing up.
    public String toString() {
        return hidden.faceUp ? dealerHand.toString() + " = " + getPoints() : dealerHand.toString();
    }

    // Flips hidden card
    public void reveal() {
        hidden.flip();
    }
}
