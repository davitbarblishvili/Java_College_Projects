<h3>Talk Scheduling (70 points)</h3>
<p>Imagine you are a conference organizer and you are tasked with scheduling the largest possible subset from a set of talks all in the same room. Each talk in the set has a given start time and end time. These times cannot change. No talks that have times that overlap can be scheduled in the same room. For the sake of this assignment assume that one talk can begin instantly upon completion of the previous talk. Consider the example below with three talks in the set:</p>
<p><strong>Talks:</strong></p>
<ol>
<li>Fred Flinstone 9:00AM-11AM</li>
<li>Barney Rubble 10:30AM-4PM</li>
<li>Bam Bam Rubble 1PM-1:15PM</li>
</ol>
<p>The optimal schedule (the one that schedules the most talks) in this example would be to schedule Fred's talk and Bam Bam's talk. <strong>Note:</strong> Optimal does <em>NOT</em> mean the room is used for the longest time, it means the greatest possible number of talks are scheduled.</p>
<p><strong><em>This Assignment</em></strong>
<br  /><em>Step 1:</em> Come up with an algorithm that will lead to scheduling the greatest number of talks.
<br  /><em>Step 2:</em> Implement your algorithm in Java using the design outline below.</p>
<p>Included on Codio is a file containing a list of 50 talks along with their start and end times. I used a 24 hour time format to make this a little easier. Your application must read a file in this format and schedule the maximium number of talks that can be scheduled in a single room. To do this write the following two classes:</p>
<ol>
<li><p>Talk.java- This class is used to model a talk and may be used to provide the title and/or speaker for a talk along with the start and stop times of the talk. This class should implement the Comparable interface.</p>
</li>
<li><p>Scheduler.java - This class will serve as a repository for static methods that you will use to schedule the talks.</p>
</li>
</ol>
<p>Included on Codio is a test class, ScheduleTest.java. Your code <em>must</em> work with our tester.</p>
<p><strong><em>For the aspiring hacker (not for credit)</em></strong>
<br  />Write a separate application (you may use some of the classes above) to schedule ALL of the talks in the minimum number of rooms.</p>
<p><strong>What to hand in</strong>:</p>
<p>The test file ScheduleTest.java is already located on Codio. You must create files: Talk.java and Scheduler.java as described above. In addition to the source files include a text file named readMe.txt with an explanation of how your program works. That is, write in plain English, instructions for using your software, explanations for how and why you chose to design your code the way you did. The readMe.txt file is also an opportunity for you to get partial credit when certain requirements of the assignment are not met.</p>
<h3>Submitting your work:</h3>
<p>Please sumbit the source code and the <code>readMe.txt</code> on Canvas. You must export them from codio, compress them into a single zip file, and submit them on Canvas. The compressed file you submit should be called [your UNI]_pp5.zip so for example my submission would be called ac1076_pp5zip</p>
<h3>A word about Grading:</h3>
<p>This assignment is worth 70 points. we will use the following guideline for awarding points:</p>
<ul>
<li>30% if it compiles</li>
<li>30% if it runs properly (expected output for given input, etc.)</li>
<li>20% for style (formatting of code, variable names, comments, etc. Use the style guide posted on Coursworks!)</li>
<li>20% for design (efficiency, short methods, etc.)</li>
</ul>
<p>Please make sure your program at least compiles before you submit it! There will be no partial credit for a program that &ldquo;almost&rdquo; compiles.</p>
</div>