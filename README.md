
# Preface 
_Updated Aug 1, 2025 by Chau Nguyen Developer_

This Weather Forcast Application program will try to create and display a Graphical User Interface (GUI) (a Swing window), so you will need a display to show visual windows/graphics directly (it can be your laptop/PC screen or monitor). GitHub Codespaces is not recommended to run the program, as it is a headless environment.  

You can clone this repository to your local machine, and then compile and run with a GUI-capable Java Developer Kit (JDK). I used IntelliJ in the past when I wrote this program.  

I chose GUI-based method instead of terminal-based because I believe in the importance of creating a product that is accessible and user-friendly for everybody, not only those who work in technology field. I used the Java Swing library to enable my program to respond to user interactions, such as button clicks and other triggered events.

[The Northrop Grumman Collaboration Project (NGCP)](https://www.cpp.edu/engineering/ngcp/index.shtml) is a joint technology demonstration between Cal Poly Pomona and Cal Poly San Luis Obispo. Past missions revolve around the search and rescue of an immobile hiker, survivor, or patient.  

GCS stands for Ground Control Station. People use ground control station to remotely operate and manage un-manned vehicles, such as drones and robots, during missions. GCS is also crucial in obtaining and analyzing data.  



# Technical Assessment for GCS 2024-25 (by Khoi and GCS team)

```
# Information about you:
1. Name:
2. Preferred email:
3. Availability within next week (i.e., 9AM-5PM everyday except for weekends,...):
    - 
```

## Table of Contents
- Hold On!
	- What we will test you on
	- What we will NOT test you on
- Technical Assessment
	- **Problem: Someone Check the Weather!**
	- How do I Submit my Code?
	- Rules?
## Hold On!
**DO NOT SHARE THIS WITH ANYONE!**
I know you are very nervous, but I am here to promise you that you will be all okay! If you're feeling not prepared right now, I recommend go outside and take a quick walk or touch some grass! 

Once you're done, read the instructions below and begin!
### What we will test you on:
1. Ability to do independent research confidently. **(most important!)**
2. Ability to propose a solution based on said research. 
3. Ability to apply basic coding skills to sketch up said solution (*i.e. reading files, for loops, arrays,...*). 
### What we will NOT test you on:
1. Ability to grind problems on LeetCode. 
2. Ability to know and use complex & abstract data structures and sorting algorithms. 

## Technical Assessment
Please **read everything carefully** before begin coding your solution. Once you're done, **read everything one more time!** *(just to make sure!)*
### Problem: Someone Check the Weather!
The Ground Control Station is planning on a testing flight with their other vehicle software teams later in the week, so they need upcoming weather forecasts to see what day has the best and worst weather. 

Use the included `forecasts.json` file and create a program that can do the following
1. Ask user what kind of info they wanna look for? `temperature`, `percipitation`, or `wind_speed`
2. Ask user whether they want `highest` value of the upcoming week or `lowest` value of the upcoming week?
3. Print a response stating the `time`, as well as the `temperature`, `percipitation`, and `wind_speed` that fits the criteria given by the users in Question 1 & Question 2. Remember to use the correct units!

**NOTE:** Each index of the `time`, `temperature`, `percipitation`, and `wind_speed` corresponds with each other. That means the first element of the `time` list corresponds with the first element of the `temperature`, `percipitation`, and `wind_speed` lists, and so on.

**Example 1:** If the user chooses `temperature` & `highest`, you should print the time that is indicated to have the highest temperature of the week, as well as the actual `temperature`, `percipitation`, and `wind_speed` during that time.

**Example 2:**
```shell
What info are you looking? 
# User can type: temperature 
Lowest or Highest? 
# User can type: highest 
Highest temparature will be at <time here>. Here are some more info:
- temperature: <temp of that time>
- percipitation: <percipitation of that time>
- wind_speed: <wind speed of that time>
```
### How do I Submit my Solution?
1. Clone this GitHub repository and work on your solution. 
2. After you're done working on it, fill out the information box above and push your version to a new branch called `solution`. You can also add your resume to your repository if you so choose! 
3. Finally, make a pull request to the `main` branch once you're ready for us to interview you! If you think we forgot your pull request, please let us know via the NGCP Recruitment Discord!


### Rules?
There are only a few quick rules:

1. You can choose **any programming language you want!** *(you can even use detailed pseudo-code too!)*
2. **No ChatGPT or AI assistance!** I want to see how YOU think, not how an AI thinks!
3. However, **please take advantage of other online resources (Google, Stack Overflow, tutorials, documentations,...)** to help you out!. 
4. You are free to make any assumptions about the problem that hasn't been mentioned above.  
5. And most importantly...
#### It's completely okay if you can't solve the problem fully! As long as you have something, we'll interview you!

Good luck and have a safe flight out there!
