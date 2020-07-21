package com.philipa18;

import com.philipa18.hands.Hand;
import com.philipa18.hands.HittableHand;
import com.philipa18.hands.InitialHand;
import com.philipa18.hands.RestrictedHand;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Hand playerHand;
    private int bet;
    Deck deck;


    public Player(Deck deck, int bet) {
        this.deck = deck;
        this.bet = bet;
        this.playerHand = new InitialHand(deck.draw(), deck.draw());
    }

    /*
     Returns point value of hand.
     This is calculated by initially treated aces as 1, then adding 10 to the sum until its <=11 or the number of 10s
     added is equal to the number of aces in the hand.
     */
    public int getPoints() {
        int sum = 0;
        int numAces = 0;
        ArrayList<Card> cards = playerHand.getHand();

        for (Card card:cards) {
            // Face cards are worth 10, so a min function between the cards rank and the integer 10 is used
            sum += Math.min(card.getRank(), 10);
            if (card.getRank() == 1) numAces++;
        }

        while (numAces > 0 && sum < 12) {
            numAces--;
            sum+= 10;
        }
        return sum;
    }


    // Returns a string of valid actions of hand, along with codes to enter to perfrom them
    public String getActions() {
        switch (playerHand.availableActions()) {
            case 1:
                return "[St]and";
            case 2:
                return "[H]it or [St]and";
            case 3:
                return "[H]it, [St]and, or [D]ouble down";
            case 4:
                return "[H]it, [St]and, [Sp]lit, or [D]ouble down";
            default:
                return "Issue: Can't retrieve valid moves";
        }
    }

    public boolean playHand() {
        // Is returned and indicates if player has busted or stood down.
        boolean notDone = true;
        Scanner moveEntry = new Scanner(System.in);
        System.out.println("Available moves: " + getActions());
        String choice = moveEntry.next();

        // If choice is invalid, turn starts again, if not move is performed.
        switch (choice) {
            // Double down: Bet is doubled, one more card is drawn, and player ends turn
            case "D":
                if (playerHand.availableActions() < 3) System.out.println("Can't do this move.");
                else {
                    System.out.println("You've chosen to double down.");
                    notDone = false;
                    bet *= 2;
                    ArrayList<Card> cards = playerHand.getHand();
                    cards.add(deck.draw());
                    playerHand = new RestrictedHand(cards);
                    System.out.println(toString());
                }
                break;
            // Hit: Another card is drawn
            case "H":
                if (playerHand.availableActions() < 2) System.out.println("Can't do this move.");
                else {
                    System.out.println("You've chosen to hit.");
                    ArrayList<Card> cards = playerHand.getHand();
                    cards.add(deck.draw());
                    playerHand = new HittableHand(cards);
                    System.out.println(toString());
                }
                break;
            // Stand: Player ends their turn
            case "St":
                System.out.println("You've chosen to stand. Point total is " + getPoints());
                notDone = false;
                break;
            default:
                System.out.println("Not a valid entry, try again.");
        }
        // Player's turn is also ended if they bust
        if (getPoints() > 21) notDone = false;

        return notDone;
    }


    @Override
    public String toString() {
        return playerHand.toString() + " = " + getPoints();
    }

    public int getBet() {
        return bet;
    }
}
