# WildWatch Developer Guide 🐘

## Table of Contents  
- [Introduction](#introduction-)
    - [Purpose](#purpose)
    - [Audience](#audience)
    - [How to use the Developer Guide](#how-to-use-the-developer-guide)
    - [Legend](#legend)
- [Quick Start](#quick-start-)
- [Design & Implementation](#design--implementation-)
- [Product Scope](#product-scope-)
    - [Target User Profile](#target-user-profile)
    - [Value Proposition](#value-proposition)
- [User Stories](#user-stories-)
- [Non-Funtional Requirements](#non-functional-requirements-)
- [Manual Testing](#manual-testing-)
- [Command Summary](#command-summary-)
- [Glossary](#glossary-)
- [Acknowledgements](#acknowledgements-)

--------------------------------------------------------------------------------------------------------------------------------------

## Introduction 🐻

Welcome aboard fellow animal lover! We are really excited to have you here! 😉    
Wildwatch is a program for a clerk managing wildlife data in a wildlife reserve via the [Command Line Interface (CLI)](#glossary-).  
Its main job is to store and present animal data required in everyday operations of the wildlife reserve.  

### Purpose
This document specifies the architectural and software design decisions in the implementation of the WildWatch.  
For a detailed guide on how to use the program and explanations on the individual commands, we have our very own [**WildWatch User Guide**](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html) for your perusal.

### Audience
The intended audience for this document are developers who would like to look under the hood and understand how WildWatch works, and are looking to introduce new functionalities into WildWatch.

### How to use the Developer Guide  
- Are you new here?  
No worries, head to the [Quick Start](#quick-start-) page.
- Lost among the pages?  
Head to the [Table of Contents](#table-of-contents) to look for the right pages.  
- Need help with the functionalities?  
Head to the [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features-) page in the User Guide for detailed guidance.  
- Do you have a question for us?  
Head to the [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#faq-) page in the User Guide.  
- Do you want a concise summary of all functionalities?  
Head to the [Command Summary](#command-summary-) page for a summary of all commands.
- Not sure what that word meant?  
Head to the [Glossary](#glossary-) page for its meaning.  

### Legend

| Symbol         | Meaning                                                     |
| -------------- |------------------------------------------------------------ |
| ❗ IMPORTANT   | These are important instructions that you should follow.   |
| ✏ Note   | These are important details that you should take note of.   |
| ⬆ Back to top  | Click to scroll back up to the `Table of Contents`.         |
| 🐵 🦊 🦁      | Animals indicate you have reached a new section.            |

[⬆ Back to top](#table-of-contents)

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

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Design & Implementation 🐹

### System Architecture

![System Architecture](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/90309a3c-f784-4ffb-8eef-65735c05ec52)

The **_Architecture Diagram_** above shows a high-level overview of the architectural design of WildWatch.  
Actual detailed implementation may differ from the architectural diagram.  
(e.g., `Parser` in the diagram encompasses the `Execute`, `Error`, and `Parser` packages).  
  
WildWatch is comprised of 7 major components.  
- `Main`: Entry point of the program.
- `UI`: A class that receives input from, and prints output to the user.
- `Parser`: A class that processes and interpretes the input command of the user.
- `Command`: A set of classes that does specific task according to the command of the user.
- `EntryList`: A class that stores all the wildlife data, while the program is running.
- `Entry`: A class that stores individual wildlife data, while the program is running.
- `Storage`: A class that saves and retrieves all the wildlife data from the local storage
  
![General Sequence Diagram](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/6cef0c5a-c924-4f20-bf82-3ccee9eb61c0)  
 
The **_Generic Sequence Diagram_** above shows how the components in the architecture interact with each other for a generic command input in WildWatch.  
> ✏ Note: `Command` here is a placeholder, and will be replaced by actual commands. e.g., `ListCommand`.

### Main Component  
The `Main` component, residing as a method in the `WildWatch` class, which is the only class without a package, is the entry point of the program.  
  
![Main Class Diagram](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/2745b29a-da1d-423e-b460-10f65dbc8e0d)  
  
### UI Package  
The `UI` components can be found within the `UI` package.  
It prompts and reads commands from the user and sends the command to `Execute` package to be executed.  
Lastly, it prints an output message upon completion of the command, to show the success of failure of the command execution.  
  
![UI Class Diagram](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/d44324ea-ca0a-4094-8082-32ddafc7e694)  
  
### Parser Package 
The `Parser` components can be found within the `Parser` package.  
It is responsible for parsing the input String of the user, and returning an appropriate `XYZCommand` class.  
If the input is invalid, it throws exceptions to the `Error` package for error handling.  
The **_Parser Class Diagram_** below shows how `Execute`, `Parser`, `Error`, `Command` classes of their respective packages work together.  
  
![Parser Class Diagram](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/1c8a8ae1-a14d-427f-8ecd-aa5038fb4fc7)
  
### Command Package  
The `Command` components can be found within the `Command` package.  
![Command Sequence Diagram](images/AddSequenceDiagram.png)  

[⬆ Back to top](#table-of-contents)  

### EntryList Package  
The `EntryList` class can be found within the `Entry` package.  

[⬆ Back to top](#table-of-contents)  

### Entry Package  
The `Entry` class can be found within the `Entry` package.  

![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/ee46913d-dfc5-4fd5-85ef-53bb03546085)
The class diagram above shows the relationship beteen the `Entry`, `EntryList`, and `ArrayList` classes.

[⬆ Back to top](#table-of-contents)  

### Storage Package  
The `Storage` components can be found within the `Storage` package.  

[⬆ Back to top](#table-of-contents)  
  
--------------------------------------------------------------------------------------------------------------------------------------

## Product scope 🦁

### Target user profile

Target user profile for WildWatch is the clerks working in wildlife reserves, who manages the wildlife data.
Since our program is interacted through the [Command Line Interface (CLI)](#glossary-), someone who can type fast will definitely benefit from WildWatch.
This would significantly boost one's productivity.
Since clerks are already accustomed to typing and working with a computer, this program would be ideal for this user profile.


### Value proposition

- **Effortless User Experience**: Designed with simplicity in mind, our product ensures that even users with minimal technical experience can easily navigate and interact with the software.
- **Rapid CLI Interaction**: Unlike traditional GUIs that require multiple clicks and drags, our Command Line Interface (CLI) offers direct command inputs, allowing for faster and more efficient operations.
- **Light & Versatile**: Built to be lean and light, our program ensures seamless performance across a variety of devices, as long as Java is installed, from high-end workstations to older laptops. Regardless of your computer's specifications, our product guarantees a smooth and efficient functioning.
- **Robust Data Protection**: Say goodbye to the vulnerabilities of paper records! Our digital solution offers enhanced data protection, ensuring your records remain safe from damage, loss, or unauthorized access. With advanced encryption and backup mechanisms in place, your data's safety is our priority.
- **Eco-Friendly**: Transition from paper to digital and contribute to a greener planet. Not only does this transition reduce clutter and the risk of loss, but it also significantly diminishes your carbon footprint.
- **Cost-Effective**: Eliminate the recurring costs of paper, printing, and storage. With our solution, you'll experience a noticeable reduction in operational expenses while benefiting from advanced data management capabilities.

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## User Stories 🦊

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see help instructions|refer to them when I forget how to use the application|
|v1.0|zoo clerk|add an animal entry|record the animals in the zoo, and refer to them afterwards|
|v1.0|zoo clerk|delete an animal entry|remove redundant or invalid animal entry|
|v1.0|zoo clerk|list all the entries|see what entries I have entered previously, and refer to them|
|v1.0|zoo clerk|have a exit command|close the program safely|
|v2.0|zoo clerk|find an entry item by name|locate the entry I want, without having to go through the entire list|
|v2.0|zoo clerk|edit a command|change the entry contents to reflect the changes in the zoo|
|v2.0|zoo clerk|see a summary of all entries|have an idea of the entries at a glance|
|v2.1|zoo clerk|export the entries|easily move my data from one place to another|

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Non-Functional Requirements 🐯

1. Should be portable and working on any mainstream OS as long as it has Java 11 or above installed.
2. Should be able to hold up to 1000 wildlife records without a noticeable drop in performance for typical usage.
3. The average user who is familiar with typing on a keyboard should accomplish their tasks faster with WildWatch than a typical GUI app

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Manual Testing 🐼

### Launching the App
1. Download the latest JAR file from our release page [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases)
2. Double-click the JAR file to run the app

### Getting help
1. Run the `help` command by typing `help` and hitting the `Enter` key on your keyboard

### Adding a Wildlife Entry
1. Run the following command `add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/looks healthy`

Expected: Wildlife recorded successfully added

2. Run the following command `add D/02-03-23`

Expected: No new recorded added.

### Listing Wildlife Entries
1. Run the following command `list`

Expected: All wildlife records shown


### Editing a Wildlife Entry
1. Run the following command `edit I/1 D/02-03-23 S/Annam Leaf Turtle N/Ariel R/looks healthy`

Expected: Successfully edited the wildlife record
3. Run the following command `edit I/-1 D/02-03-23 S/Annam Leaf Turtle N/Ariel R/looks healthy`

Expected: Failed to edit as -1 is not a valid index


### Deleting a Wildlife Entry
1. Run the following command `delete 1`

Expected: Successfully deleted the first record

2. Run the following command `delete 0`

Expected: Failed to delete a record as 0 is an invalid record

### Getting a summary of the wildlife data
1. Run the following command `summary`

Expected: A summary of the wildlife record is displayed

### Exporting wildlife data to a local file
1. Run the following command `export myobservations.csv`

Expected: You will be prompted with further questions

### Exiting the app
1. Run the `bye` command

Expected: The app stops
[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Command Summary 🐱

| Action                    | Format                                                             |
|---------------------------|--------------------------------------------------------------------|
| Getting Help              | `help`                                                             |
| Adding Entries               | `add D/<DATE> S/<SPECIES> N/<NAME> {R/<REMARKS>}`                  |
| Adding Entries (interactive) | `add i/`                                                           |
| Deleting Entries            | `delete <INDEX>`                                                   |
| Finding Entries            | `find <SEARCH>`
| Editing Entries              | `edit I/<INDEX> {D/<DATE>} {S/<SPECIES>} {N/<NAME>} {R/<REMARKS>}` |
| Summarizing Entries       | `summary {<SPECIES>}`                                              |
| Listing Entries              | `list`                                                             |
| Exporting Entries            | `export {<FILENAME>}`                                              |
| Exit                      | `bye`                                                              |

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Glossary 🐨
We are here to help you with terminologies used in the user guide, that may not be familiar to you.

| Terminology    | Meaning                                                     |
| -------------- |------------------------------------------------------------|
| Command Line Interface   | A way to communicate with your computer using texts. |

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Acknowledgements 🐶
[woodenclock](https://github.com/woodenclock/ip.git) - Reference  
[AB3 Developer Guide](https://se-education.org/addressbook-level3/DeveloperGuide.html) - Reference  
Meet the [people](https://ay2324s1-cs2113t-w11-2.github.io/tp/AboutUs.html) behind WildWatch!  

[⬆ Back to top](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------
