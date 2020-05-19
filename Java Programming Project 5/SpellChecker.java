import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class SpellChecker implements SpellCheckerInterface{   
   
    HashSet<String> hashWords = new HashSet<>();
    private List<String> wordsToCompare = new ArrayList<>();
    private List<String> misspelledWords= new ArrayList<>();
    private Set<String> wordSuggestions = new HashSet<>();
    public boolean notFound;
   
    
    public SpellChecker(String dictionary)  {
        try{
       notFound = false;     
       Scanner fileReader = new Scanner(new File(dictionary));
         while(fileReader.hasNextLine()){      
           hashWords.add(fileReader.nextLine().toLowerCase().trim());  
       }
    }
        catch(FileNotFoundException ex){
            notFound = true;
            System.out.println("Dictionary File Not Found");   
        }
    }
    
    public List<String> getIncorrectWords(String filename){
        try{
           if(notFound == true)
               System.out.println("Try to upload correct dictionary file and then come back to this method");
           else{
        File fileToCheck = new File(filename);
        Scanner reader = new Scanner(fileToCheck);
        
        while(reader.hasNextLine()){
            String list = reader.nextLine();
            String[] words = list.replaceAll( "\\p{Punct}", "").toLowerCase().trim().split("\\s+");
            for(int i = 0; i < words.length; i++)
                wordsToCompare.add(words[i]);     
        }   
            for(int i = 0; i < wordsToCompare.size() - 1; i++){
                if(wordsToCompare.get(i).length() == 0){
                    
                }else
                if(hashWords.contains(wordsToCompare.get(i))){
                    
                }else{
                    misspelledWords.add(wordsToCompare.get(i));
                }   
         }   
      }           
    }
    catch(FileNotFoundException e){
        System.out.println("file not found");
        
    }
        return misspelledWords;
    }
	public Set<String> getSuggestions(String word){
        if(notFound == true){
            System.out.println("Please, upload correct dictionary file and then come back to this method");
        }else if(hashWords.contains(word)){
           System.out.println("The word: " + "'"+ word +"'" + " is spelled correctly!");  
        }
        else{
        Set<String> wordsToSuggest = prepareSuggestions(word);
        for(String suggestion : wordsToSuggest){
            if(hashWords.contains(suggestion)){
                wordSuggestions.add(suggestion);     
            }
         }    
      }     
        return wordSuggestions;
    }
    
    private Set<String> prepareSuggestions(String word){
        Set<String> craftWords = new HashSet<>();
        
        for(int i = 0; i < word.length() - 1; ++i){
            //swapping characters
            String temp = word.substring(0,i) + word.substring(i+1, i+2) + word.substring(i, i + 1) + word.substring(i+2);        
            craftWords.add(temp);
            
        }  
        //removing each character at a time
          for(int i = 0; i < word.length();i++){
            String tempRemove = word.substring(0,i) + word.substring(i+1);
            craftWords.add(tempRemove);    
        }
          for(int i = 0; i < word.length(); ++i){
             // adding characters
              for(char letter = 'a'; letter <= 'z'; ++letter)
             craftWords.add(word.substring(0,i) + letter + word.substring(i));     
        }
         return craftWords;
    }
}