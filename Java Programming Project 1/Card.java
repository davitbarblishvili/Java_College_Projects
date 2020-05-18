
//*************************************
//
//@author: | Davit Barblishvili |
//@UNI: | db3230 |
//10/29/2018
//
//**************************************
 
    

public class Card implements Comparable<Card>{
	
	private int suit; // integers 1-4 to encode the suit
	private int rank; // integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
        rank = r;
        
		
	}
	
	public int compareTo(Card c){
		//  method to compare cards so they 
		// will be easily sorted
		if(this.rank > c.rank){
            return 1;
        }
        if(this.rank < c.rank){
            return -1;
        }
        if(this.rank == c.rank){
           if(this.suit > c.suit){
               return 1;
           }
           if(this.suit < c.rank){
               return -1;
           }
           if(this.suit == c.rank){
               return 0;
           }   
        }
        return 2;
	  }
	
	public String toString(){
		// method to easily print a Card object
		String cardSuit = "suit";
        String cardRank = "rank";
		   
		  if(suit == 1){
             cardSuit = "Clubs";
          }
          if(suit == 2){
             cardSuit = "Diamonds";
          }
          if(suit == 3){
              cardSuit = "Hearts";
          }
          if(suit == 4){
              cardSuit = "Spades";
          }
          if(rank == 1){
              cardRank = "Ace";
              }
          if(rank == 2){
              cardRank = "2";
              }
          if(rank == 3){
              cardRank = "3";
          }
          if(rank == 4){
              cardRank = "4";
          }
          if(rank == 5){
              cardRank = "5";
          }
          if(rank == 6){
              cardRank = "6";
          }
          if(rank == 7){
              cardRank = "7";
          }
          if(rank == 8){
              cardRank = "8";
          }
          if(rank == 9){
              cardRank = "9";
          }
          if(rank == 10){
              cardRank = "10";
          }
          if(rank == 11){
              cardRank = "Jack";
          }
          if(rank == 12){
              cardRank = "Queen";
          }
          if(rank == 13){
              cardRank = "King";
          }
        String card_Def = ( cardRank+ " of " +cardSuit);
        return card_Def;
        
	}
    
    
    public int getSuit(){
        //method to return suit
        return suit;
    }
    
    public int getRank(){
        //method to return rank
        return rank;
    }
    
    
	// add some more methods here if needed

}
