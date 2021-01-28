# BlackJackCL
Blackjack you can play on the command line
---
The goal of the game is either to build a hand whose value is higher than that of the
dealer’s without exceeding 21 (in which case, the player is said to be “bust” and loses,
regardless of the value of the dealer’s hand), or by standing and hoping that the dealer
busts instead.
Each hand’s value is the sum of its card values, subject to the following rules:
- The value of a numbered card (any card 2-10) is equivalent to its number.
- Face cards (Jacks, Kings, and Queens) are worth 10 points.
- Aces can be worth 1 or 11 points. (If the other cards in the hand sum to 10 or
less, the Ace will be worth 11. Otherwise, the Ace will be worth 1, since a value
of 11 would cause the player to bust.)

After receiving his or her initial cards, the player can choose to do the following:
- Hit: The player is dealt another card
- Stand: The player takes no more cards. Once the player stands, the dealer then
reveals his or her second card and plays the hand according to the ‘Dealer
behavior’ section below.
- Double down: The player increases his or her bet up to 100% and must draw
exactly one more card, then stand. Can only be used after the player has
received his or her first two cards.
---
What I have not yet implemented: Splitting hands, Configuarble dealer.

How I would implement them:
A splitting hand could just have a method which returns an array of two new hands.
Player would also need an array of hands array than just a hand field, 
and a loop within the game to make sure each hand is played with.
I've already added a parameter to adjust dealer behaviour, it would basically just require user input at the begining.

What I would do differently:
I should've planned more. Instead of having a hand interface, I should've just had the most unrestricted hand, a splittable one,
be a superclass for the other hands instead of reimplmenting simular methods. The same goes for
how I constructed the dealer class. In retrospect it probably should have been a subclass of player.
