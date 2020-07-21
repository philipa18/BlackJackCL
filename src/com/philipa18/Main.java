package com.philipa18;

import java.util.Scanner;

public class Main {
    // This type indicates if the game is over and if so what the outcome is.
    enum Condition {PLAY, WIN, BLACKJACK, TIE, LOSS}

    public static void main(String[] args) {

	    System.out.println("Welcome to Blackjack!");
	    // Each call of game is a different game. Returning false means the user is done
	    while(game());

    }

    private static boolean game() {
        Condition outcome = Condition.PLAY;
        Scanner userInput = new Scanner(System.in);

        // Get player bet.
        System.out.println("How many dollars would you like to bet?");
        int bet = userInput.nextInt();

        // Deck returned is a standard 52-card deck, shuffled
        Deck deck = new Deck();

        // A player object. Deck is passed in so it can draw cards a bet is passed in case of a doubling down.
        Player player = new Player(deck, bet);

        System.out.println("You were dealt two cards: " + player);

        Dealer dealer = new Dealer(deck, true);
        System.out.println( "Dealer draws two cards: " + dealer);

        // Check if player has gotten a blackjack
        if (player.getPoints() == 21) {
            // Now we know their first two cards add to 21, we need to check the dealer's hand
            dealer.reveal();
            System.out.println("A blackjack! Let's see the dealer's hand: " + dealer);
            if (dealer.getPoints() == 21) {
                System.out.println("Dealer has blackJack, too!");
                outcome = Condition.TIE;
            } else outcome = Condition.BLACKJACK;
        }

        // Loop will continue until player busts or stands
        while (player.playHand());

        // In case bet was doubled via a double down.
        bet = player.getBet();

        // Check if player busted
        if (player.getPoints() > 21) {
            outcome = Condition.LOSS;
            System.out.println("Your hand is busted!");
        }

        // If player has not busted or blackjacked, dealer will play
        if (outcome == Condition.PLAY) dealer.playHand();

        // Check to see if dealer busted, won, or tied, and adjust outcome accordingly
        if (player.getPoints() == dealer.getPoints()) outcome = Condition.TIE;
        else if (dealer.getPoints() > 21 || (dealer.getPoints() < player.getPoints() && player.getPoints() <= 21) ) outcome = Condition.WIN;
        else outcome = Condition.LOSS;

        // Deliver final message and net winnings depending on outcome
        switch (outcome) {
            case WIN:
                System.out.println("You won! Net Winnings: $" + bet);
                break;
            case BLACKJACK:
                System.out.println("Only you have a blackjack, congrats! Net Winnings: $" + 3 * bet / 2);
                break;
            case TIE:
                System.out.println("A tie! Net Winnings: $0");
                break;
            case LOSS:
                System.out.println("You lost. Net Winnings: -$" + bet);
                break;
            default:
                System.out.println("Apologies, but there was an error");
        }

        // Allow user to start again if they wish
        System.out.println("Enter y to start again, any other key to quit");
        String answer = userInput.next();

        return answer.equals("y");
    }
}
