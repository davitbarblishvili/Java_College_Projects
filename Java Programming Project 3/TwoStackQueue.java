import java.util.*;

public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
    
    private MyStack<T> S1;
    private MyStack<T> S2;
    int sizeQ;
    
    public TwoStackQueue(){
        S1 = new MyStack<T>();
        S2 = new MyStack<T>();
        
        }
    
    public void enqueue(T x){
      
        S1.push(x);
    }
    
    public T dequeue(){
         if(S2.isEmpty()){
             while(!S1.isEmpty()){
                 S2.push(S1.pop());
             }
         }
        return S2.pop();
    }
    
    public int size(){
        sizeQ = S1.size() + S2.size();
        return sizeQ;
        
    }
    
    public boolean isEmpty(){
        
        return S1.isEmpty() && S2.isEmpty();
    }
       
    
    
}