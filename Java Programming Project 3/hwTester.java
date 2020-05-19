import java.util.Scanner;
import java.util.*;
import java.io.File;



public class hwTester{
 @SuppressWarnings("unchecked")
  public static void main(String[] args){
    
    SymbolBalance david = new SymbolBalance();
    
   
    david.setFile(args[0]);
      System.out.println(david.checkFile());
      
}
}