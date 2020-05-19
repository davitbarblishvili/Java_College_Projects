import java.util.*;

public class ExpressionTreeTester{
    
      public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
       // String ExpressionS = dato.nextLine();
     //   ExpressionTree david = new ExpressionTree(ExpressionS);
          
          ExpressionTree binaryTree = new ExpressionTree("-6 3 / 10  9  -2 * - +");
          
    /*    System.out.println(david.eval());
        System.out.println(david.infix());
        System.out.println(david.prefix());
        System.out.println(david.postfix());
    */      
        System.out.println(binaryTree.eval());
        System.out.println(binaryTree.infix());
        System.out.println(binaryTree.prefix());
        System.out.println(binaryTree.postfix());
    }
}