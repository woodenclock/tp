# WildWatch Developer Guide 🦣

## Table of Contents  
- [Acknowledgements](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#acknowledgements)
    - [Purpose](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#purpose)
    - [Audience](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#audience)
    - [How to use the Developer Guide](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#how-to-use-the-developer-guide)
- [Introduction](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#introduction)
- [Design & Implementation](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#design--implementation)
- [Product Scope](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#product-scope)
  - [Target User Profile](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#target-user-profile)
  - [Value Proposition](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#value-proposition)
- [User Story](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#user-stories)
- [Non-Funtional Requirements](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#non-functional-requirements)
- [Manual Testing](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#manual-testing)
- [Command Summary](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#command-summary)
- [Glossary](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#glossary)

--------------------------------------------------------------------------------------------------------------------------------------

## Acknowledgements  
[woodenclock](https://github.com/woodenclock/ip.git) - Reference  
[AB3 Developer Guide](https://se-education.org/addressbook-level3/DeveloperGuide.html) - Reference  
Meet the [people](https://ay2324s1-cs2113t-w11-2.github.io/tp/AboutUs.html) behind WildWatch!  

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Introduction 🐻

Wildwatch is a program for a clerk managing wildlife data in a wildlife reserve via the [Command Line Interface (CLI)](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#glossary).  
Its main job is to store and present animal data required in everyday operations of the wildlife reserve.  

### Purpose
This document specifies the architectural and software design decisions in the implementation of the WildWatch.  
For a detailed guide on how to use the program and explanations on the individual commands, we have our very own [**WildWatch User Guide**](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html) for your perusal.

### Audience
The intended audience for this document are developers who would like to look under the hood and understand how WildWatch works, and are looking to introduce new functionalities into WildWatch.

### How to use the Developer Guide  
- Are you new here?  
No worries, head to the [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#quick-start-) page.
- Lost among the pages?  
Head to the [Table of Contents](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents) to look for the right pages.  
- Need help with the functionalities?  
Head to the [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#features-) page for detailed guidance.  
- Do you have a question for us?  
Head to the [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#faq-) page.  
- Do you want a concise summary of all functionalities?  
Head to the [Command Summary](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#command-summary-) page for a summary of all commands.
- Not sure what that word meant?  
Head to the [Glossary](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#glossary-) page for its meaning.  

### Legend

| Symbol         | Meaning                                                     |
| -------------- |------------------------------------------------------------ |
| ❗ IMPORTANT   | These are important instructions that you should follow.   |
| ⬆ Back to top  | Click to scroll back up to the `Table of Contents`.         |
| 🐵 🦊 🦁      | Animals indicate you have reached a new section.            |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Quick Start 🐵

1. Ensure you have Java 11 or above installed in your Computer. (What is my [Java version](https://www.java.com/en/download/help/version_manual.html)?)
   
2. Download the latest `WildWatch.jar` from [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your WildWatch.

4. Open a command terminal, `cd` into the folder you put the jar file in, and run the following command: `java -jar WildWatch.jar`.
You should see the welcome screen as the diagram below.

5. Type commands beside `>>>` below the horizontal line and press `Enter` to execute it. Some example commands you can try:
- `help` : Shows the help page.  
- `bye` : Exits the program.  

```
____________________________________________________________
____    __    ____  __   __       _______
\   \  /  \  /   / |  | |  |     |       \
 \   \/    \/   /  |  | |  |     |  .--.  |
  \            /   |  | |  |     |  |  |  |
   \    /\    /    |  | |  `----.|  '--'  |
    \__/  \__/     |__| |_______||_______/
____    __    ____  ___   .___________.  ______  __    __
\   \  /  \  /   / /   \  |           | /      ||  |  |  |
 \   \/    \/   / /  ^  \ `---|  |----`|  ,----'|  |__|  |
  \            / /  /_\  \    |  |     |  |     |   __   |
   \    /\    / /  _____  \   |  |     |  `----.|  |  |  |
    \__/  \__/ /__/     \__\  |__|      \______||__|  |__|
____________________________________________________________
Hello there! Welcome to WildWatch!

Checking if "WildWatch.txt" already exists...
File does not exist.
Creating new file...
File created successfully.
What would you like to do?
____________________________________________________________
>>> 
```

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Design & Implementation

### System Architecture

![System Architecture](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/7bdda637-1c7a-4358-a648-a9972184cd3d)

The **_Architecture Diagram_** shows the high-level architectural design of WildWatch.  
Actual detailed implementation may differ from the architectural diagram.  
WildWatch is comprised of 7 major components.  
- `Main`: Entry point of the program.
- `UI`: A class that receives input from, and prints output to the user.
- `Parser`: A class that processes and interpretes the input command of the user.
- `Command`: A set of classes that does specific task according to the command of the user.
- `EntryList`: A class that stores all the wildlife data, while the program is running.
- `Entry`: A class that stores individual wildlife data, while the program is running.
- `FileHandler`: A class that saves and retrieves all the wildlife data from the local storage

### Parser component 
The `Parser` component is responsible for for parsing an input from the user, and returns an `XYZCommand` class. 

### Command component 
//TODO: incomplete
For the diagram below, the command `add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper` has been substituted by `input`. 

![](diagrams/AddSequenceDiagram.svg)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Product scope


### Target user profile

Target user profile for WildWatch is the clerks working in wildlife reserves, who manages the wildlife data.
Since our program is interacted through the [Command Line Interface (CLI)](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#glossary), someone who can type fast will definitely benefit from WildWatch.
This would significantly boost one's productivity.
Since clerks are already accustomed to typing and working with a computer, this program would be ideal for this user profile.


### Value proposition

- **Effortless User Experience**: Designed with simplicity in mind, our product ensures that even users with minimal technical experience can easily navigate and interact with the software.
- **Rapid CLI Interaction**: Unlike traditional GUIs that require multiple clicks and drags, our Command Line Interface (CLI) offers direct command inputs, allowing for faster and more efficient operations.
- **Light & Versatile**: Built to be lean and light, our program ensures seamless performance across a variety of devices, as long as Java is installed, from high-end workstations to older laptops. Regardless of your computer's specifications, our product guarantees a smooth and efficient functioning.
- **Robust Data Protection**: Say goodbye to the vulnerabilities of paper records! Our digital solution offers enhanced data protection, ensuring your records remain safe from damage, loss, or unauthorized access. With advanced encryption and backup mechanisms in place, your data's safety is our priority.
- **Eco-Friendly**: Transition from paper to digital and contribute to a greener planet. Not only does this transition reduce clutter and the risk of loss, but it also significantly diminishes your carbon footprint.
- **Cost-Effective**: Eliminate the recurring costs of paper, printing, and storage. With our solution, you'll experience a noticeable reduction in operational expenses while benefiting from advanced data management capabilities.

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see help instructions|refer to them when I forget how to use the application|
|v1.0|zoo clerk|add an animal entry|record the animals in the zoo, and refer to them afterwards|
|v1.0|zoo clerk|delete an animal entry|remove redundant or invalid animal entry|
|v1.0|zoo clerk|list all the entries|see what entries I have entered previously, and refer to them|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------



## Non-Functional Requirements

{Give non-functional requirements}

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------


## Manual Testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Command Summary

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Glossary

* *glossary item* - Definition

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------
