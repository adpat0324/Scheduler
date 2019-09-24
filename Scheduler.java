/*
 * @author: Aditi Patil
 * @date: 11/16/18
 * 
 * Scheduler.java: This class will serve as a repository for static 
 * methods that you will use to schedule the talks.
 * 
*/
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Collections;

public class Scheduler {
    
    // this will handle all exceptions
    public static ArrayList<Talk> makeTalks(String fileName) throws IOException 
    {
        ArrayList<Talk> makeSchedule = new ArrayList<Talk>();
        
        File inFile = new File(fileName);
        
        if (inFile.length() >= 0 && inFile.length() < 4) {
            System.out.println("This is not a valid file.");
            throw new IOException();
        }
        
        Scanner inputFile = new Scanner(inFile);
        int line = 1;
        
        while(inputFile.hasNext()) {
            String tokens[] = inputFile.nextLine().split("\\s+");
            String name;
            int startTime;
            int endTime;
            
            if (tokens.length != 3) {
                System.out.println("There is an invalid number of arguments " 
                                   + "one line " + line);
                throw new IOException();
            }
            else {
                name = tokens[0];
            }
            if(tokens[1].length() != 4 && tokens[2].length()!=4) {
                System.out.println("Invalid time on line " + line);
                throw new IOException();
            }
            try {
                startTime = Integer.parseInt(tokens[1]);
                endTime = Integer.parseInt(tokens[2]);
                
                //make sure times are not over 60 minutes
                int lastTwoStart = startTime % ((startTime / 100) * 100);
                int lastTwoEnd = endTime % ((endTime / 100) * 100);
                if (lastTwoStart >= 60 || lastTwoEnd >= 60 
                   || startTime > 2359 || endTime > 2359
                   || startTime > endTime) {
                    throw new NumberFormatException();
                }
            }
            catch(NumberFormatException numE) {
                System.out.println("Times are formatted incorrectly on line "
                                      + line);
                throw new IOException();
            }
            
            
            Talk talk = new Talk(name, startTime, endTime);
            makeSchedule.add(talk);
            
            line++;
        }
        return makeSchedule;
    }
      
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> sortedList) {
        Collections.sort(sortedList);
        
        ArrayList<Talk> scheduledTalks = new ArrayList<Talk>();
        scheduledTalks.add(sortedList.get(0));
        Talk lastTalk = scheduledTalks.get(0);
        
        //loop to check for conflicts
        for(int i = 1; i < sortedList.size(); i++) {
            Talk candidate = sortedList.get(i);
            if (candidate.startsLaterThanEnds(lastTalk)) {
                scheduledTalks.add(candidate);
                lastTalk = candidate;
            }
        }
        return scheduledTalks; 
    }     
}