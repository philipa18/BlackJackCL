package com.philipa18.hands;

import com.philipa18.Card;

import java.util.ArrayList;

public class HittableHand implements Hand {
    ArrayList<Card> cards = new ArrayList<>();

    public HittableHand(ArrayList<Card> cards) {
        this.cards = cards;
    }
    @Override
    public int availableActions() {
        return 2;
    }

    @Override
    public ArrayList<Card> getHand() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        for (Card card : cards) {
            response.append(card.toString());
        }
        return response.toString();
    }
}
