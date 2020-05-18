1) Card Class - in card class I have created two 
objects: suit and rank that are useful to sort and
print deck of cards. CompareTo method compares
cards by the rank and then by the suit in case
of necessity. toString() method prints a Card
object. I have two method getSuit() and getRank()
to return suit and rank.

2)Deck Class - In this class, all of the methods
are used to manipulate the deck of cards.
First, I created a 52-card deck by using
two "for" loop; To shuffle I used built-in Java
method Coll.ections.shuffle; however, I used 
arraylist of converted array. Card deal() method
deals the top card of the deck.

3)Player class - In this class I created an object 
of Player, and all methods of PLayer class are used
to manipulate player's data. Initial bankroll
of the player is 10.00(unit).
addCard() method adds the card to the player's hand
removeCard()method removes the card from the player's
hand.
bets() methods adjusting the final amount of bankroll
after the player bets
winnings() methods adds the money to bankroll.
getBankroll() simply returns the data of bankroll
getUserHand() methods return the player's current
hand( 5 cards);

4) Game class - Game class is using the all the 
classes to actually play the game. In game class
I have two constructor - one for normal game, 
and another one to test if the checkHand()
methods works properly;
Play() method is the actual execution of the poker;
I created Scanner for user's input in play();
The first part of play() is greetings and explaning
a little bit of rules to the player. After, the player
bets the tokens between 1 and 5. Next, the method
suffles cards, deals them and print the hand
for the player.  In the middle of Play() method
the cards are replaced or not changed according to
the player's desire. After, the hand is evaluated
and the result is printed on the screen.
checkHand() methods checks the hand and prints
the value of hand along with String statement
exaplining what the evaluation of the hand was.
After this, I have several boolean methods that 
are checking the hands and returning the result.
