package com.philipa18.hands;

import com.philipa18.Card;
import java.util.ArrayList;
/* Interface inherited by each type of hand*/
public interface Hand {
    /* Returns number of available moves*/
    public int availableActions();
    /*Returns arraylist holding hand's cards*/
    public ArrayList<Card> getHand();
}
