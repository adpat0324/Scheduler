Aditi Patil
aap2205
11/20/18
COMS 1004
---------------------------------------------------------------------------------------------------------
I started the project by creating the algorithm for which the most amount of talks can be planned. 
The algorithm is to look for the talk with the earliest end time, and sort the rest of talks by end time. 

In Talk.java, I began by creating a constructor which initialized the name, start time, and end time of 
the talk. Then, I create a compare To method which implemented the aforementioned algorithm that compares
end times of two talks and if the end times are the same, then it looks at the start times. Lastly, a 
boolean method looks to check to see if two talks overlap at all, which will be used in Scheduler.java. 

In Scheduler.java, I threw all the exceptions that would need to be accounted for in the project. For 
example, I checked to make sure the file given is in the right format: a name, start time, and end 
time (3 arguments). Next, I checked to see if the times were in "0000" format. The next exception I 
checked for was to make sure that the times were in the right format. For example, the time 1680 could
not exist because time only goes up to 60. In the same if statement, I also made sure to check if the 
end time came after the start time. If these exceptions did not occur, then the name, start time, and 
end time would be added to makeSchedule. Then, in the static method scheduleTalks, the list was sorted 
such that I could check if there is any conflict and if not, then the talk would be added to scheduledTalks. 
Lastly, this is what is returned. 