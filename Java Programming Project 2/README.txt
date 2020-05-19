Davit Barblishvili
UNI:db3230
PP_5


1) In Talk.java, I created an object with Speaker Name, Start time
and End time; By using CompareTo method, I sorted the array of 
talks (in Scheduler.java) according to the earliest end time; 
in other words, the talks with earliest end time are sorted first;
If end times are equal, I compare total time elapsed after
a speaker starts the presentation; compareTo() sorts the talks
with the shortest interval, if their end times are equal;
In addition to accessor methods for start time, end time, and 
total time, I have a boolean method that checks if the talks
overlapp or no. Finally, by utilizing toString() method
Tester class print String with speaker name, start time and 
end time;

2)In Scheduler.java,I left public class Scheduler and its 
constructor empty, because later, I am using static methods, 
and they are not able to access instance variables.
Public static ArrayList<Talk> makeTalks() is reading the file
and stores object(talks)in the arrayList, Talks. Before reading
I created file and scanner, and used hasNext() and "\\s+"
to read my file line by line and split them according to 
whitespace. In addition, by detecting if file is empty or not
I later catch the exception. Plus, I check if the number of 
elements of String is more than 3; by utilizing catch exception
method I prevent a single line from having more than 3 elements
separated by whitespace. In addition, I check if number format 
is appropriate to 2400 format. FInally, in this method, I create
an object with speaker name, start time, and end time, 
and I store all 50 talks in arraylist "talks." At the end of method
I listed all of the exception I detected in makeTalks() method.

in scheduleTalks() class, I sorted array of 50 talks, according 
to compareTo method, and created new arraylist, where I am 
going to store scheduled talks. Before utilizing "for" loop
I added first element of an array to scheduled talks, because it
has the earliest end time; after that, by having int j
I am using boolean method "isCompatible" to compare each talk to
the last scheduled talk(j), and add compatible talks to 
my organized arraylist.
Finally, I return my scheduled talks arraylist, which will be
printed by scheduletest.class


