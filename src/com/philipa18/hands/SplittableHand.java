package com.philipa18.hands;

import com.philipa18.Card;

import java.util.ArrayList;

public class SplittableHand implements Hand {
    Card card1, card2;

    public SplittableHand(Card card1, Card card2) {

    }
    @Override
    public int availableActions() {
        return 4;
    }

    @Override
    public ArrayList<Card> getHand() {
        return null;
    }

    public Hand split(Card deck) {

        return null;
    }
}
