/*
 * @author: Aditi Patil
 * @date: 11/16/18
 * 
 * Talk.java: This class is used to model a talk and may be used to provide the title 
 * and/or speaker for a talk along with the start and stop times of the talk. This class 
 * should implement the Comparable interface.
 * 
*/
import java.util.Collections;
import java.util.ArrayList;

public class Talk implements Comparable<Talk>{
    
    private String name; 
    private int startTime;
    private int endTime;
    
    public Talk(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String toString() {
        String list = "";
        list = name + "\t" + startTime + "-" + endTime;
        return list;
    }
    
    public int compareTo(Talk other) {
        int endTimeDifference = endTime - other.endTime;
        //if they have the same ending times:
        if (endTimeDifference == 0)
            return (startTime - other.startTime);
        else
            return endTimeDifference;
    }
    
    //checks if this starts later than (or at the same time as) when other ends
    public boolean startsLaterThanEnds(Talk other) {
        return startTime >= other.endTime;
    } 
}