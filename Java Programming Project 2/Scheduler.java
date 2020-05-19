//***********************************************
//
//@author:<Davit Barblishvili>
//@UNI:<db3230>
//@Date:<11/15/2018
//
//***********************************************
import java.util.Collections;
import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Scheduler{
   
    
    public Scheduler(){
       
 }
   public static ArrayList<Talk> makeTalks(String textFile )      throws IOException 
   //throws an exception for the makeTalks method 
   {
        ArrayList<Talk> talks;
        talks = new ArrayList<Talk>();
     try{
        //creates new arraylist file, and scanner; 
        File talkList = new File(textFile);
         if(talkList.length() == 0){
             throw new NullPointerException();
             //detection if the file is empty or not
             //and throwing the exception
         }
        Scanner organizer = new Scanner(talkList);
        
       while(organizer.hasNext()){
            //reading the file line by line
             String talk1 = organizer.nextLine();
            
            //splitting the string according to whitespace
            String[] talker = talk1.split("\\s+");
            
           if(talker.length != 3){
               throw new IndexOutOfBoundsException();
               //detecting the number of elements 
               //of string; throwing the exception
            }
            String speakerName = talker[0];
           if(speakerName.matches("[0-9]+")){
               throw new IllegalArgumentException();
               //detecting if first element of an array 
               //is containing digits or letters
              
           }
            int startTime =Integer.parseInt(talker[1]);
            if(startTime > 2399){
                throw new NumberFormatException();
                //check if time format is appropriate
             }
            int endTime = Integer.parseInt(talker[2]);
            if(endTime > 2399){
                throw new NumberFormatException();
                //check if time format is appropriate
            }
            //assigning parts of String to appropriate variables
            Talk speakern = new Talk(speakerName, startTime, endTime);
               talks.add(speakern);
            //adding each talk to the arraylist of talks.
            
         }
         
        organizer.close();
        
        
     } 
       catch(NumberFormatException exception)
       {
            getMessage();
            System.exit(0);
       }
      
       catch(IndexOutOfBoundsException ex )
       {  
            getMessage();
            System.exit(0);
       }
      
       catch(NullPointerException emptyFile)
       {
           System.out.println("Your file is empty");
           System.out.println("Try to proceed with appropriate file");
           System.exit(0);
       } 
       catch(IllegalArgumentException typo){
           getMessage();
           System.exit(0);
       }
       
       
     return talks;
       
    }
    public static void getMessage(){
          System.out.println("Error! There is a problem with your file");
          System.out.println("Modify your file accordingly");
         
        
    }
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks){    
        Collections.sort(talks);
        //sorting the arraylist;
        ArrayList<Talk> scheduledTalks;
        scheduledTalks = new ArrayList<Talk>();
        
        scheduledTalks.add(talks.get(0));
        int j = 0;
       for(int i = 1;i<talks.size()-1;i++){
           if(talks.get(i).isCompatible(scheduledTalks.get(j))){
               scheduledTalks.add(talks.get(i));
               j++;
               //incrementing to newly scheduled talks;
           }
           //using for loop to added compatible talks 
           //to new arraylist; "int j" is used to compare
           //the last added talk to following talks
           
           else{
              
               continue;
               
            }
       }
           System.out.println("We have scheduled your talks!");
           System.out.println("Here are the results:\n");
           return scheduledTalks;
     
                              
    }
  }
