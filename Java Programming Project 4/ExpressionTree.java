import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.lang.*;

@SuppressWarnings("unchecked")
public class ExpressionTree implements ExpressionTreeInterface{
    private ExpressionNode<String> root;
    public String data;
    private Stack<ExpressionNode> tokenStack;
    private String[] opString;
    private int result; 
    
   
    
   
    public ExpressionTree(String expression){
        opString = new String[20];
        tokenStack = new Stack<>();
        result = 0;
     
        try{  
          opString = expression.trim().split("\\s+");
       
           for(int i = 0; i < opString.length; i++){       
               
               if(i == opString.length){
                   resizeArray(opString.length * 2);
               }
               if(isOther(opString[i]) == true){
                   throw new IllegalArgumentException();
               }
               if(opString.length % 2 == 0){
                   throw new IOException();
               }
            if(isOperator(opString[i]) == false){
                root = new ExpressionNode(opString[i]);
              
                tokenStack.push(root);
                              
            }
            else {
                root = new ExpressionNode(opString[i], tokenStack.pop(), tokenStack.pop());
                
                tokenStack.push(root);
         }
       }
    
    }
        catch(IOException e){
            System.out.println("Naah! Do not do that. Unbalanced number of operators and operands");
            System.exit(0);
        }
        catch(IllegalArgumentException et){
            System.out.println("Your input includes symbol that are different from integers and operators");
            System.exit(0);
            
        }
        catch(EmptyStackException ex){
            System.out.println("I am confused");
            System.exit(0);
        }
    }
   
    
    public int eval(){
       
      return eval(root);         
    }
    
    private int eval(ExpressionNode root){
        
     if(isOperator(getData(root))){
              int leftOp = eval(root.left);
              int rightOp = eval(root.right);
              
        if(root.rootElement.equals("+")){
                                    
              result = leftOp + rightOp;
         }
        if(root.rootElement.equals("-")){
          
            result = leftOp - rightOp;   
        }
        if(root.rootElement.equals("*")){
          
            result = leftOp * rightOp;
        }
        if(root.rootElement.equals("/")){
          
            result = leftOp / rightOp;
        }
       }else{
                result = Integer.parseInt(getData(root));
            }
    
                root = new ExpressionNode(result);
                tokenStack.push(root);
         ExpressionNode finAnswer = tokenStack.pop();
        int x = Integer.parseInt(getData(finAnswer)); 
        
        return x;
    }
    
    
    public String getData(ExpressionNode root){
        String rawData = String.valueOf(root.rootElement);
        return rawData;
    }
        
    public String postfix(){
        return postfix(root);    
    }
    
    private String postfix(ExpressionNode root){
     
        StringBuilder postStr = new StringBuilder();
        
        if(root != null){
            postStr.append(postfix(root.left));
            postStr.append(" ");
            postStr.append(postfix(root.right)); 
            postStr.append(" ");
            postStr.append(getData(root));
          

        }
        String finalData = postStr.toString();
       
      return finalData.trim();
 
    }
    
    public String prefix(){
        return prefix(root);
        
    }
    
    private String prefix(ExpressionNode root){
        StringBuilder preStr = new StringBuilder();
        
        if(root != null){
            preStr.append(getData(root));
            preStr.append(" ");
            preStr.append(prefix(root.left));
            preStr.append(prefix(root.right));
        }
        String finalData = preStr.toString();
        return finalData;
    }
    
    public String infix(){
        return infix(root);
        
    }
    
    private String infix(ExpressionNode root){
      StringBuilder inStr = new StringBuilder();
        
        if(root != null){
            inStr.append("(");
            inStr.append(infix(root.left));
            inStr.append(' ');
            inStr.append(getData(root));
            inStr.append(" ");
            inStr.append(infix(root.right));
            inStr.append(")");
        }
         String finalData = inStr.toString();
         return finalData;
    }
    
    public boolean isOperator(String opToken){
        if(opToken.equals("/") || 
           opToken.equals("-") || 
           opToken.equals("*") ||
           opToken.equals("+")){
            return true;
        }else{
        return false;
        }
    }
    
    
    public void resizeArray(int newSize){
       if(newSize < opString.length)
          return; 
        
       String[] oldArr = new String[opString.length];
       oldArr = opString;
       opString = new String[newSize];
        
      for(int i = 0; i < oldArr.length; i++)
           opString [i] = oldArr[i];   
    }
    
    public boolean isOther(String et){
        if(!(et.matches(".*[0-9].*") || et.equals("-") || 
             et.equals("/") || et.equals("+") || et.equals("*"))){
            return true;
        }
        return false;
    }
    
    private static class ExpressionNode<String>{
        
        ExpressionNode<String> left;
        ExpressionNode<String> right;
        String rootElement;
        
        ExpressionNode(String rootData){
            this ( rootData, null, null);
        }
        
        ExpressionNode(String rootData, ExpressionNode<String> rightChild, ExpressionNode<String> leftChild){
            
            left = leftChild;
            right = rightChild;
            rootElement = rootData;
            
        }
        
      
    }
    
    
  
}
            
          
           
            
        
    
        
        
      
      
        
       
      
        
        
        
   
