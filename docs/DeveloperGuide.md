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
Meet the [people](https://ay2324s1-cs2113t-w11-2.github.io/tp/AboutUs.html) behind WildWatch, get to know them better!  
Some code snippets were referenced from [woodenclock](https://github.com/woodenclock/ip.git).  

--------------------------------------------------------------------------------------------------------------------------------------

## Introduction 🐻

Wildwatch is a program for a clerk managing wildlife data in a wildlife reserve via the [Command Line Interface (CLI)](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#glossary).  
Its main job is to store and present animal data required in everyday operations of the wildlife reserve.  

### Purpose
This document specifies the architectural and software design decisions in the implementation of the WildWatch.

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

--------------------------------------------------------------------------------------------------------------------------------------

## Quick Start 🐵

1. Ensure you have Java 11 or above installed in your Computer. (What is my [Java version](https://www.java.com/en/download/help/version_manual.html)?)
   
2. Download the latest `WildWatch.jar` from [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your WildWatch.

4. Open a command terminal, `cd` into the folder you put the jar file in, and run the following command: `java -jar WildWatch.jar`.
You should see the welcome screen as the diagram below.

5. Type commands below the horizontal line and press `Enter` to execute it. (e.g. typing `help` and pressing `Enter` will show the help page).
Some example commands you can try:
- `list` : Lists all entries.  
- `bye` : Exits the program.  

![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/b790d1a9-9f9f-461b-962d-0183055b15d5)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/DeveloperGuide.html#table-of-contents)

## Design & Implementation

### System Architecture

![System Architecture](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/7bdda637-1c7a-4358-a648-a9972184cd3d)

The **_Architecture Diagram_** above explains the high-level design of the application.  
WildWatch is comprised of 7 major components.  
- `Main`: Entry point of the program.
- `UI`: A class that receives input from, and prints output to the user.
- `Parser`: A class that processes and interpretes the input command of the user.
- `Command`: A set of classes that does specific task according to the command of the user.
- `EntryList`: A class that stores all the wildlife data, while the program is running.
- `Entry`: A class that stores individual wildlife data, while the program is running.
- `FileHandler`: A class that saves and retrieves all the wildlife data from the local storage


## Product scope
### Target user profile

Target user profile are the clerks working in zoos.


### Value proposition

{Describe the value proposition: what problem does it solve?}


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see help instructions|refer to them when I forget how to use the application|
|v1.0|zoo clerk|add an animal entry|record the animals in the zoo, and refer to them afterwards|
|v1.0|zoo clerk|delete an animal entry|remove redundant or invalid animal entry|
|v1.0|zoo clerk|list all the entries|see what entries I have entered previously, and refer to them|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|



## Non-Functional Requirements

{Give non-functional requirements}



## Manual Testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}



## Command Summary


## Glossary

* *glossary item* - Definition
