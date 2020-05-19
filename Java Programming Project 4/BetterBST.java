import java.util.*;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{
   
    private static final int ALLOWED_IMBALANCE = 1;   
    public BetterBST(){
           root = null;   
    }
    
     public int height(){
        
        return height(root);
    }
    
    private int height(BinaryNode<T> node)
    {      
        if(node == null){
            return -1;
        }
        
        int leftSideH = height(node.left);
        int rightSideH= height(node.right);
    
    if(leftSideH > rightSideH){       
        return leftSideH + 1;
    }
    else{
        return rightSideH + 1;
    }    
}
    
    public T imbalance(){
        
        return imbalance(root);
    }
    
    private T imbalance(BinaryNode<T> node){
        int treeHeight = 0;
          
        if(node == null){
            return null;
        }
      
       T Rimbalanced =   imbalance(node.right);
       T Limbalanced =   imbalance(node.left);
         
       int leftSide = height(node.left);
       int rightSide= height(node.right);
      
       treeHeight = (Math.abs(leftSide - rightSide));
        
        if(treeHeight > ALLOWED_IMBALANCE){
            return node.data;
        }
        else if(treeHeight <= ALLOWED_IMBALANCE  ){
           if(Limbalanced !=null){
               return Limbalanced;
           }
            else if(Rimbalanced != null){
                return Rimbalanced;
            }     
        }       
        return null;      
    }
    
    public BinarySearchTree<T> mirror(){
        BetterBST<T> mirroredTree = new BetterBST<>();
        return mirror(root, mirroredTree);
    }
    private BinarySearchTree<T> mirror(BinaryNode<T> node, BetterBST<T> mirroredTree){
        
        if(node == null){
            
            return null;
        }else{
                  
            BinaryNode<T> tempNode = new BinaryNode<T>(null);
            mirror(node.left, mirroredTree);
            mirror(node.right, mirroredTree);
            tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;       
            
        }
        
        return mirroredTree;
      }
    
    public T smallestGreaterThan(T t){
        BinaryNode<T> rootNode = new BinaryNode<T>(null); 
        return smallestGreaterThan(t,root, rootNode);
    }
    
    private T smallestGreaterThan(T t, BinaryNode<T> node, BinaryNode<T> RootNode){  
        
        if(node == null){
            
            return null;
        }
        int compResult = t.compareTo(node.data);        
        if(compResult < 0){
            if((node.left == null && node.right == null) || (node.left == null)){
                return node.data;
            }else{  
            RootNode = node;
            return smallestGreaterThan(t, node.left, RootNode);
            }
        }
          if(compResult > 0 ){
            
            return smallestGreaterThan(t, node.right, RootNode);
        }
         if(compResult == 0){
             
            if( node.right != null){
                node = node.right;
                while(node.left != null){
                    node = node.left;
                }
                return node.data;
            }
            
            else{
                return RootNode.data;
            }   
        }
         return RootNode.data; 
  }
  
    
    
    public void prettyPrint(){
        int treeHeight = height(root);
        for(int i = 1; i <= treeHeight + 1; i++){
            prettyPrint(root, i);
         
            System.out.println();
        }
    }
    
    private void prettyPrint(BinaryNode<T> root, int nodeDepth){
     
        if(root == null){
            printSpaces((int)(Math.pow(2, nodeDepth + 1) - 1 ) );
          System.out.print(" ");
       
           return;
       }
        if(nodeDepth == 1){
             printSpaces((int)(Math.pow(2, height(root) + 1)- 1));
             System.out.print( " " + root.data + "   ");         
             printSpaces((int)(Math.pow(2, height(root) + 1) - 1));
        }else
            if(nodeDepth > 1){
               prettyPrint(root.left, nodeDepth - 1);
               printSpaces((int)(Math.pow(2, height(root.left) + 1 ) - 1));
               prettyPrint(root.right, nodeDepth - 1 );
               printSpaces((int)(Math.pow(2, height(root.right) + 1 ) - 1));
            
            }
            
        }
    
    
   private static void printSpaces(int count){
        
        
        
       for(int i = 0; i < count; i++){
           System.out.print("  ");
      }
        
        
   }
}
   
    
   
    



