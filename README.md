# Technical Assessment for NGCP 2024-25
## Table of Contents
- Hold On!
	- What we will test you on
	- What we will NOT test you on
- Technical Assessment
	- **Someone Check the Weather!**
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
3. Whether you had experience with the technologies GCS uses beforehand. 
## Technical Assessment
Please **read everything carefully** before begin coding your solution. Once you're done, **read everything one more time!** *(just to make sure!)*
### Someone Check the Weather!
The Ground Control Station is planning on a testing flight with their other vehicle software teams later in the week, so they need upcoming weather forecasts to see what day has the best and worst weather. 

Use the included `forecasts.json` file and create a program that can do the following
1. Ask user what kind of info they wanna look for? `temperature`, `relative_humidity`, or `apparent_temperature`
2. Ask user whether they want `highest` value of the upcoming week or `lowest` value of the upcoming week?
3. Print a response stating the `time`, as well as the `temperature`, `relative_humidity`, and `apparent_temperature` that fits the criteria given by the users in Question 1 & Question 2. Remember to use the correct units!

**NOTE:** Each index of the `time`, `temperature`, `relative_humidity`, and `apparent_temperature` corresponds with each other. That means the first element of the `time` list corresponds with the first element of the `temperature`, `relative_humidity`, and `apparent_temperature` lists, and so on.

**Example 1:** If the user chooses `temperature` & `highest`, you should print the time that is indicated to have the highest temperature of the week, as well as the actual `temperature`, `relative_humidity`, and `apparent_temperature` during that time.

**Example 2:**
```shell
What info are you looking? 
# User can type: temperature 
Lowest or Highest? 
# User can type: highest 
Highest temparature will be at <time here>. Here are some more info:
- temperature: <temp of that time>
- relative humidity: <relative humidity of that time>
- apparent_temperature: <apparent temperature of that time>
```
### How do I Submit my Code?
1. Clone the repository and work on your solution.
2. After you're done working on it, push your solution to a new branch called `solution`.
3. Finally, make a pull request to the `main` branch once you're ready for us to interview you!
### Rules?
There are only a few quick rules:
1. **No ChatGPT or AI assistance!** I want to see how YOU think, not how an AI thinks!
2. However, **please take advantage of other online resources (Google, Stack Overflow, tutorials, documentations,...)** to help you out!. 
3. You can choose **any programming language you want!** *(you can use detailed pseudo-code too!)*
4. You are free to make any assumptions about the problem that hasn't been mentioned above. **Make sure to mention any assumptions inside your solution files.**  
5. And most importantly...
#### You don't need to solve it perfectly! As long as you have some code, we'll interview you!

Good luck and have a safe flight out there!