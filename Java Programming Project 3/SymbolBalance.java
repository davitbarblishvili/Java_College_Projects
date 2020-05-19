import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;


public class SymbolBalance implements SymbolBalanceInterface{
        public int lineNumber;
        private File textFile;
        private String fileStr;
        private boolean isCommentLine;
        private boolean iSlashSym;
        private boolean isAsteriks;
        private boolean isQuote;
        char nextSymbol;
        int counter;
        char currentSymbol;
        
    
    
    public SymbolBalance(){
        lineNumber = 0;
        isCommentLine = false;
        isAsteriks = false;
        iSlashSym = false;
        isQuote = false;
        counter=0;
        
     }
    
    public void setFile(String filename){
         
          textFile = new File(filename);
         
     }
    
    public BalanceError checkFile(){ 
       
     MyStack<Character> stackFile = new MyStack<Character>();
      try{
      Scanner fileReader = new Scanner(textFile); 
            
           while(fileReader.hasNextLine()){
               
              String fileStr = fileReader.nextLine();
                    lineNumber++;
               
                  for(int i = 0; i<fileStr.length();i++){
                       currentSymbol = fileStr.charAt(i);
                      
                      if(currentSymbol == '/' && iSlashSym == false){
                          if(isCommentLine == false){
                         System.out.println(currentSymbol);
                         iSlashSym = true;
                         isCommentLine = false;
                         isAsteriks = false;     
                          continue;
                          
                          }
                      }
                      if(currentSymbol == '*' && iSlashSym == true){
                      
                         stackFile.push(currentSymbol);
                         isCommentLine = true;
                         iSlashSym = false;
                         continue;
                        
                      }
                       if(isCommentLine){
                      if(currentSymbol == '*' && stackFile.peek() == '*'){
                          stackFile.pop();
                          iSlashSym = false;
                          isAsteriks = true;
                          continue;
                        } 
                     }
                      
                     
                     if(currentSymbol == '/' && isAsteriks == true) { 
                         
                           isCommentLine = false;
                           isAsteriks = false; 
                           continue;
                    }
                      if(isCommentLine == false){
                      if(currentSymbol == '"' && isQuote == false){
                          isQuote = true;
                         
                          stackFile.push(currentSymbol);
                          continue;
                       }
                          
                     else if(isQuote == true && isCommentLine == false){
                         if(stackFile.peek() == '"' && fileReader.hasNextLine() == false){
                             isQuote = false;
                             return new NonEmptyStackError(stackFile.pop(), stackFile.size());
                          
                     }
                         continue; 
                       
                      
                     }    else if(isQuote == true && stackFile.peek() == '"'){
                           if(isCommentLine == false){
                               stackFile.pop();
                               isQuote = false;
                                 continue;
                           }
                                 
                         
                      }
                          
                      
                }
                                 
                     System.out.println(isCommentLine);    
                      
                   if(isCommentLine == false){
                      if(currentSymbol == '{' || currentSymbol == '(' || currentSymbol == '['  ){ 
                       
                         stackFile.push(currentSymbol);
                  
                            }
                        }
                      
                       switch (currentSymbol){
                              
                          case '}': 
                             // System.out.println(stackFile.peek());
                              if(!(isCommentLine)){
                              if(stackFile.isEmpty()){
                                  return new EmptyStackError(lineNumber);
                              }
                              else if(stackFile.peek() == '{'){
                                  stackFile.pop();
                                 
                              }
                                  else{
                                  return new MismatchError(lineNumber, currentSymbol, stackFile.pop());
                              }
                              break;
                              }
                          case ')':
                              if(!(isCommentLine)){
                              if(stackFile.isEmpty()){
                              
                                  return new EmptyStackError(lineNumber);
                              }
                                 else if(stackFile.peek() == '('){
                                  stackFile.pop();
                                 }else{
                                
                                  return new MismatchError(lineNumber, currentSymbol, stackFile.pop());
                              }
                              break;
                              }
                          case ']': 
                              if(!(isCommentLine)){
                              if(stackFile.isEmpty()){
                                  return new EmptyStackError(lineNumber);
                              } else if(stackFile.peek() == '[' ){
                                  stackFile.pop();
                                    
                                  
                              }
                                  else{
                                 return new MismatchError(lineNumber, currentSymbol, stackFile.pop());
                              }
                          break;
                      
                              }
                         
                              
                      }
                      if(stackFile.isEmpty() == false && fileReader.hasNextLine() == false){
                         
                          return new NonEmptyStackError(stackFile.pop(), stackFile.size());
                   }
            }
   
         }
      
      }      
        catch(IOException e){
            return null;
        }
   return null; }
   
    
}
        
  



    
          
