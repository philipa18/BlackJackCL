package com.philipa18.hands;

import com.philipa18.Card;

import java.util.ArrayList;

public class RestrictedHand implements Hand{
    ArrayList<Card> cards = new ArrayList<>();

    public RestrictedHand(ArrayList<Card> cards) {
        this.cards = cards;
    }
    @Override
    public int availableActions() {
        return 1;
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
