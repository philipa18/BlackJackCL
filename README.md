# BlackJackCL
Blackjack you can play on the command line

What I have not yet implemented: Splitting hands, Configuarble dealer.

How I would implement them:
A splitting hand could just have a method which returns an array of two new hands.
Player would also need an array of hands array than just a hand field, 
and a loop within the game to make sure each hand is played with.
I've already added a parameter to adjust dealer behaviour, it would basically just require user input at the begining.

What I would do differently:
I followed the advice at the start a bit to strongly and shoudl've planned more.
Instead of having a hand interface, I should've just had the most unrestricted hand, a splittable one,
be a superclass for the other hands instead of reimplmenting simular methods. The same goes for
how I constructed the dealer class. In retrospect it probably should have been a subclass of player.
