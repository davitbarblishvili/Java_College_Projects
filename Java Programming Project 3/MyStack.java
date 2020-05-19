 import java.util.Arrays;

public class MyStack<T> implements MyStackInterface<T> {
    
    private T[] myStackArr;
    private int arrSize;
    
    @SuppressWarnings("unchecked")
    public MyStack(){
        arrSize = 0;
        myStackArr = (T[]) new Object[100];
     
 
   }
    
    
    public void push(T x){
        if(myStackArr.length == size())
            resizeArray(size() * 2 + 1);
        
       
        myStackArr[arrSize++] = x;
    }
    public T pop(){
        
            
     return myStackArr[--arrSize];
        
     
    }
    
    public T peek(){
        
        return myStackArr[arrSize-1];
    }
    
    public boolean isEmpty(){
        
        return arrSize == 0;
       
    }
    
    public int size(){
        
        return arrSize+1;
    }
    
   
   public void resizeArray(int newSize){
       if(newSize < size())
          return; 
        
        T[] oldArr = myStackArr;
       myStackArr =(T[]) new Object[newSize];
        
      for(int i = 0; i < size(); i++)
           myStackArr [i] = oldArr[i];   
    }
}