
//********************************************
//
//@author: <Davit Barblishvili>
//@UNI: <db3230>
//
//********************************************

import java.util.*;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;
   

	
		
	public Player(){		
	    // creating a player here
	    hand = new ArrayList<Card>();
        bankroll = 10.00;
        bet = 0;
	}

	public void addCard(Card c){
	    // adding the card c to the player's hand
	    
	    hand.add(c);
       
        
	}

	public void removeCard(Card c){
	    // removing the card c from the player's hand
	        hand.remove(c);
        }
		
        public void bets(double amt){
            // player making a bet
            bankroll = bankroll - amt;
        }

        public void winnings(double odds){
            //	adjusting bankroll if player wins
            
            bankroll = bankroll + odds;
        }

        public double getBankroll(){
            // returning current balance of bankroll
            return bankroll; 
        }
     
       public ArrayList<Card> getUserHand(){
           //returning the player's hand (5 cards)
           return hand;
       }

        
}


