//***************************************
//
//@Author: <Davit Barblishvili>
//@UNI:<db3230>
//@Date:<11/15/2018>
//
//***************************************
 


public class Talk implements Comparable<Talk>{
    private String speaker;
    private int startTime, endTime;
    private int totalTalk;
  
public Talk(String sp, int s, int e){
    speaker = sp;
    startTime = s; 
    endTime = e;
    totalTalk = endTime - startTime;
}
    
    public int compareTo(Talk t){
        if(this.endTime > t.endTime){
            return 1;
        }
        if(this.endTime < t.endTime){
            return -1;
        }
        if(this.endTime == t.endTime){
            if(this.totalTalk > t.totalTalk){
                return 1;
            }
            if(this.totalTalk < t.totalTalk){
                return -1;
            }
            if(this.totalTalk == t.totalTalk){
                return 0;
            }
           
        }
        return -2;
      }
    
    
    
    public int getEnd(){
        return endTime;
    }
    
    public int getStart(){
        return startTime;
    }
    
    public String getSpeaker(){
        return speaker;
    }
    
    public boolean isCompatible(Talk a){
           
        if(this.startTime >= a.getEnd()){
           
            return true;
        }
        else{
            return false;
        }
           
           
    }
    
    public String toString(){
        
        String scheduledTalker = (speaker + " " + startTime + " " + endTime);
        
        return scheduledTalker;
    }
    
}
    
    
   