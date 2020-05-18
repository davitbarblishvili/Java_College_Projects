
//*******************************
//
//@author: <Davit Barblishvili>
//@UNI:<db3230>
//
//*******************************
  

import java.util.Collections;
import java.util.*;

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck
       

	
	
	public Deck(){
		// making a 52 card deck here
        cards = new Card[52];
		int top = 0;
        String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9",
                          "10","Jack","Queen","King"};
           int counter = 0;
          for(int i = 0; i<suits.length;i++){
              for(int j = 0; j<ranks.length;j++){
                 cards[counter] = new Card(i+1, j+1);
                 counter++;
                  
          
              }   
         } 
              
                  
	}
         
	
	public void shuffle(){
		// shuffling the deck here
		
		Collections.shuffle(Arrays.asList(cards));
		
		
	}
    
    
    
	
	public Card deal(){
		// dealing the top card in the deck
		  
		    
            return cards[top++];
          
           
		
	}
    }
	
	


