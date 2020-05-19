import java.util.*;


@SuppressWarnings("unchecked")
public class KWorstCounter<T extends Comparable<? super T>> implements KWorst<T>{
   
    PriorityQueue<T> maxHeap;
    public int nValues; 
   
    public KWorstCounter(int k){
        try{
        nValues = k;   
        if(nValues < 1){    
            throw new IllegalArgumentException();    
        }else{ 
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());      
          }
        }
        catch(IllegalArgumentException t){
             System.out.println("Please, choose the value for K between 1 and positive infinity");
        }
    }
    
    public void count(T x){
     if(nValues < 1){}   
     else if(maxHeap.size() < nValues){
         maxHeap.offer(x);
     }else if(x.compareTo(maxHeap.peek()) < 0 && maxHeap.size() == nValues){
                maxHeap.remove();
                maxHeap.offer(x);                       
            }           
        }      
         
   public List<T> kworst(){   
       
      List<T> printVal = new ArrayList<>(); 
       if(nValues < 1){
           return printVal;
       }else{  
      while(maxHeap.size() != 0)
          printVal.add(0,maxHeap.poll());       
           for(int i = printVal.size() - 1; i >= 0;i--)
              maxHeap.offer(printVal.get(i));       
        return printVal;
      }
   } 
}





