public class BSTester{
    
    public static void main(String[] args){
        
        BetterBST<Integer> david = new BetterBST<>();
        
      david.insert(40);
        
       
       david.insert(20);
        
      david.insert(60);
        david.insert(30);
        david.insert(55);
      david.insert(70);
        david.insert(2);
        david.insert(100);
        david.insert(1);
        
      //  david.insert(20000);
   // david.insert(200);
 //   david.insert(170);
      
            
  
     
        
       
//     System.out.println(david.smallestGreaterThan(60001));
      
  //  System.out.println(david.imbalance());  
       
 //  david.mirror();
        
       //
       // System.out.println(david.height());
       // 
       david.prettyPrint();
     
    }
}