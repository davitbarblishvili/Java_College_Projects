
//********************************************
//
//@author: <Davit Barblishvili>
//UNI : <db3230>
//
//********************************************
  

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Game {
	
	private Player p;
	private Deck cards;
    public int choice;
    public int removeOrNot;
    public double betChoice;
    public double payOut;
    private int suit;
    private int rank;
    private int addBalance ;
    private double addedBalance;
   
   
    
	
	
	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		 
		cards = new Deck();
        p = new Player();
        suit = 0;
        rank = 0;
        
        //Constructor that takes input and uses CheckHand method
        //to evaluate boolean methods
       ArrayList<Card> tests = new ArrayList<Card>();
       for(int i = 0; i < testHand.length; i++){
            if(testHand[i].substring(0,1).equals("c")){
               suit = 1;
            }
            else if(testHand[i].substring(0,1).equals("d")){
               suit = 2;
           }
          else if(testHand[i].substring(0,1).equals("h")){
                suit = 3;
            }
           else  if(testHand[i].substring(0,1).equals("s")){
               suit = 4;
           }
           else{
               System.out.println("you entered invalid number");
           }
        
         rank = Integer.parseInt(testHand[i].substring(1,testHand[i].length()));
          Card c = new Card(suit, rank);
          tests.add(c);
       }
	      System.out.println(checkHand(tests));	
    }
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();
        cards = new Deck();
        choice = 0;
        betChoice = 0;
        cards.shuffle();
        payOut = 0;
        addBalance = 0;
        addedBalance = 0;
		
	}
	
	public void play(){
		// this method should play the game	
		// Created scanner
		Scanner scannerInt = new Scanner(System.in);
       
		//Greetings
		//Receive information from the user 
        System.out.println("Welcome to Poker Game!");
        System.out.println();
        System.out.println("Ranks are - Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King");
        System.out.println("Suits are - Clubs, Diamonds, Hearts, Spades");
        System.out.println("If you would like to remove cards, you are allowed to remove 5 cards olny");
        System.out.println("Enjoy the game!");
        System.out.println();
        System.out.println("P.S Luck does not exist! Everything is all about probability");
        
        System.out.println("You currently have" +" "+ p.getBankroll() +" " + "tokens");
        System.out.println("How much would you like to bet?");
        System.out.println();
        System.out.println("Please choose number between 1 and 5");
        
        
        betChoice = scannerInt.nextInt();
        p.bets(betChoice);
        
        
        System.out.println("Okay! your bet is");
        System.out.print(betChoice + "" + " tokens");
                           
        System.out.println();
        //Shuffling the deck of cards;
        cards.shuffle();
        
        //Dealing 5 cards
        for(int j = 0; j < 5; j++){
        p.addCard(cards.deal());
        }
        
       
        //Printing five cards for the player;
        System.out.println("You have the following cards:");
        for(int i = 0; i<5; i++){
          System.out.println(p.getUserHand().get(i));  
          System.out.println();
            
        }
        
        System.out.println();
        System.out.println("Would you like to replace your cards?");
        
        System.out.println("Please enter 1 for Yes, 0 for No");
        choice = scannerInt.nextInt();
        
        //Created arraylist to use it for storing the replacing/removing
        //cards
        ArrayList<Card> temp = new ArrayList<>();
        
        //Asking the player if they want to replace 
        //individual card
        if(choice == 1){
           for(int i = 0; i < 5; i++){
           System.out.println("Would you like to remove:" 
                               + p.getUserHand().get(i));
           System.out.println("Enter 1 for Yes; Enter 0 for No");
           removeOrNot = scannerInt.nextInt();
           
            if(removeOrNot == 1){
                temp.add(p.getUserHand().get(i));
                //Storing cards in temp array list
            }   
           
           }    
             for(int m = 0; m < temp.size(); m++){
                p.removeCard(temp.get(m)); 
                 //Removing cards from the hand
                 //using temp arraylist;
                 
             }
            for(int n = 0; n <temp.size();n++){
               p.addCard(cards.deal());
                //Dealing cards again after removing cards from the hand
            }
            
            System.out.println("Here are your new cards:");
            System.out.println();
            System.out.print(p.getUserHand());
            //Printing new set of cards for the player
            
            
          } 
             //Printing current set of cards if they 
             //declined to change any of the cards;
             if(choice == 0){
                System.out.println("Nothing has been changed");
                System.out.println("You have the following cards");
                System.out.println();
                System.out.print(p.getUserHand());
            }
          //sorting the cards using Collections.sort() method forevaluation
          Collections.sort(p.getUserHand()); 
          
          
       
          System.out.println();
          System.out.println(checkHand(p.getUserHand()));
        //evaluation of the hands
        
        
         p.winnings(payOut);
         
        //Calculating the current balance
        //Asking player if they want to play the game again;
         System.out.println();
         System.out.println("Your current balance is");
         System.out.println(p.getBankroll());
         System.out.println();
         System.out.println("Would you like to play again?");
         System.out.println("Enter 1 for Yes, 0 for No");
         int playAgain = scannerInt.nextInt();
        
         //Checking if they have necessary funds for playing
         //and taking the five cards out of player's hand;
         if(playAgain == 1 && p.getBankroll()>0){
             if(p.getUserHand().size()>0){
             p.removeCard(p.getUserHand().get(0));
             p.removeCard(p.getUserHand().get(0));
             p.removeCard(p.getUserHand().get(0));
             p.removeCard(p.getUserHand().get(0));
             p.removeCard(p.getUserHand().get(0));
             
             }
         
             
                
             play();
         }
        
         //Offering the player if they want to add money to their balance
         else if( playAgain == 1 && p.getBankroll() < 1){
             System.out.println("Unfortunately you do not have enough balace");
             System.out.println("Would you like to add balance to your account?");
             System.out.println("Enter 1 for Yes; 2 for No");
             addBalance = scannerInt.nextInt();
             
             //Adding the money to player's account and
             //emptying the player's hand
             if(addBalance == 1){
                 System.out.println("How much would you like to add?");
                 addedBalance = scannerInt.nextInt();
                 p.winnings(addedBalance);
                 System.out.println("Your new balance is");
                 System.out.println(p.getBankroll());
                 if(p.getUserHand().size()>0){
                   p.removeCard(p.getUserHand().get(0));
                   p.removeCard(p.getUserHand().get(0));
                   p.removeCard(p.getUserHand().get(0));
                   p.removeCard(p.getUserHand().get(0));
                   p.removeCard(p.getUserHand().get(0));
             
             }
                 play();
             }
             // Printing the final result for user
             else{
                 System.out.println("Unfortunately You did not win anything today");
                 System.out.println("Alright! Have a nice day");
                }
                 
            }
        else{
            //calculating and printing final results for player
             System.out.println("Your Winnings for Today:");
             System.out.println(p.getBankroll() + " " + "Tokens");    
             System.out.println("Thank you for playing Video Poker");
         }
      }
        
        public String checkHand(ArrayList<Card> hand){
		// this method  takes an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		
       
        
		if(isRoyalFlush(hand)){
            payOut = betChoice * 250;
            return "Awesome!Royal Flush. Your Winnings:" + payOut;
        }
        else if(isStraightFlush(hand)){
            payOut = betChoice * 50;
            return "Perfect! Straight Flush! Your Winnings:" + payOut;
        }
        else if(isFourKind(hand)){
            payOut = betChoice * 25;
            return "Great! Four of a Kind. Your Winnings:" + payOut;
        }
        else if(isFullHouse(hand)){
            payOut = betChoice * 6;
            return "Good! Full House! Your Winnings:" + payOut;
        }
        else if(isFlush(hand)){
            payOut = betChoice * 5;
            return "Nice! Flush! Your Winnings:" + payOut;
        }
        else if(isStraight(hand)){
            payOut = betChoice * 4;
            return "Good! Stright! Your Winnings:" + payOut;
        }
        else if(isThreeKind(hand)){
            payOut= betChoice * 3;
            return "Not Bad! Three of a Kind! Your Winnings:" + payOut;
        }
        else if(isTwoPairs(hand)){
            payOut = betChoice * 2;
            return "Two Pairs! Your Winnings:" + payOut;
        }
        else if(isOnePair(hand)){
            payOut = betChoice * 1;
            return "One Pair! Your Winnings:" + payOut ;
        }
        else{
            payOut = betChoice * 0;
            return "No Pair! Your Winnings:" + payOut;
        }
        
		
		
	}
    //Using boolean method to check the hand
    private boolean isRoyalFlush(ArrayList<Card> hand){
        if(hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 &&
           hand.get(2).getRank() == 11&& hand.get(3).getRank() == 12 &&
           hand.get(4).getRank() == 13){
            if(hand.get(0).getSuit() == hand.get(1).getSuit() &&
               hand.get(1).getSuit() == hand.get(2).getSuit() &&
               hand.get(2).getSuit() == hand.get(3).getSuit() &&
               hand.get(3).getSuit() == hand.get(4).getSuit()){
                   return true;
               }
        }
                   return false;
    }
        
    
        
     //Using boolean method to check the hand   
    private boolean isStraightFlush(ArrayList<Card> hand){
           if((isFlush(hand)==true) && (isStraight(hand)==true)){
               return true;
           }
               return false;
    }
     //Using boolean method to check the hand   
    private boolean isFourKind(ArrayList<Card> hand){
            boolean a = hand.get(0).getRank() == hand.get(1).getRank() &&
                        hand.get(1).getRank() == hand.get(2).getRank() &&
                        hand.get(2).getRank() == hand.get(3).getRank();
            
            boolean b = hand.get(1).getRank()== hand.get(2).getRank() &&
                        hand.get(2).getRank() == hand.get(3).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank();
    
         if(a  || b){
                return true;
         }
                return false;
                
     }   
     //Using boolean method to check the hand   
    private boolean isFullHouse(ArrayList<Card> hand){
            boolean a = hand.get(0).getRank() == hand.get(1).getRank() &&
                        hand.get(1).getRank() == hand.get(2).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank();
            
            boolean b = hand.get(2).getRank() == hand.get(3).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank() &&
                        hand.get(0).getRank() == hand.get(1).getRank();
            if(a || b ){
                return true;
            }
                return false;
        }
      //Using boolean method to check the hand  
    private boolean isFlush(ArrayList<Card> hand){
            
                if(hand.get(0).getSuit() == hand.get(1).getSuit() &&
                   hand.get(1).getSuit() == hand.get(2).getSuit() &&
                   hand.get(2).getSuit() == hand.get(3).getSuit() &&
                   hand.get(3).getSuit() == hand.get(4).getSuit()){
                    return true;
                    
                }
            
                    return false;
        }
      //Using boolean method to check the hand  
    private boolean isStraight(ArrayList<Card> hand){
            for(int i = 0; i<hand.size() -1; i++){
                if(hand.get(i).getRank() != hand.get(i+1).getRank()){
                    if(hand.get(4).getRank() - hand.get(0).getRank() == 4){
                        return true;
                    }
                }
                    
            }
                        return false;
        }  
        
        
     //Using boolean method to check the hand   
    private boolean isThreeKind(ArrayList<Card> hand){
            boolean a = hand.get(0).getRank() == hand.get(1).getRank() &&
                        hand.get(1).getRank() == hand.get(2).getRank();
            boolean b = hand.get(1).getRank() == hand.get(2).getRank() &&
                        hand.get(2).getRank() == hand.get(3).getRank();
            boolean c = hand.get(2).getRank() == hand.get(3).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank();
    
    
               if(a == true || b == true || c == true){
                return true;
                   
               }
                return false;
        }
            
            
            
            
        
     //Using boolean method to check the hand   
    private boolean isTwoPairs(ArrayList<Card> hand){
        
            boolean a = hand.get(0).getRank() == hand.get(1).getRank() &&
                        hand.get(2).getRank() == hand.get(3).getRank();
            boolean b = hand.get(0).getRank() == hand.get(1).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank();
            boolean c = hand.get(1).getRank() == hand.get(2).getRank() &&
                        hand.get(3).getRank() == hand.get(4).getRank();
            
            if(a || b  || c){
                return true;
            }
                return false;
         }
     //Using boolean method to check the hand   
    private boolean isOnePair(ArrayList<Card> hand){
            for(int i = 0; i<hand.size() - 1; i++){
            if(hand.get(i).getRank()== hand.get(i+1).getRank()){
                return true;
           }
          }
                return false;
                }
                
          
    } 
    
    
    
        
	
	
	
