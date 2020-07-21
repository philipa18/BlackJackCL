package com.philipa18.hands;

import com.philipa18.Card;

import java.util.ArrayList;
import java.util.Arrays;

public class InitialHand implements Hand{
    ArrayList<Card> cards = new ArrayList<>();

    public InitialHand(Card card1, Card card2) {
        cards.add(card1);
        cards.add(card2);
    }

    @Override
    public int availableActions() {
        return 3;
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
