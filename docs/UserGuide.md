# WildWatch User Guide 🐘


Wildwatch is a program for a clerk managing animal entries in a wildlife reserve via the Command Line Interface (CLI).

--------------------------------------------------------------------------------------------------------------------------------------
## Table of Contents 
- [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#quick-start-)
- [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features-)
    - [Adding Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#2-adding-entries-add): `add`
    - [Deleting Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#3-deleting-entries-delete): `delete`
    - [Listing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#4-listing-entries-list): `list`
    - [Edit Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#4-adding-entries-edit): `edit`
    - [Show Summary](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#5-listing-entries-summary): `summary`
    - [Getting Help](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#1-getting-help--help): `help` 
- [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#faq)
- [Command Reference](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#command-reference-)
    
--------------------------------------------------------------------------------------------------------------------------------------

## Quick Start 🐵

1. Ensure you have Java 11 or above installed in your Computer. (What is my [Java version](https://www.java.com/en/download/help/version_manual.html)?)
   
2. Download the latest `WildWatch.jar` from [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your WildWatch.

4. Open a command terminal, `cd` into the folder you put the jar file in, and run the following command: `java -jar WildWatch.jar`.
You should see the welcome screen as in Fig. 1.

5. Type commands below the horizontal line and press `Enter` to execute it. (e.g. typing `help` and pressing `Enter` will show the help page).
Some example commands you can try:
- `list` : Lists all entries.  
- `bye` : Exits the program.  

![Image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/1dcd7951-eb68-46d5-bdae-4cb4e275d94f)  
                                                Figure 1

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Features 🦊
> ❗ IMPORTANT
> * Capitalized words between angle brackets `< >` are information to be written appropriately by the user.
> * E.g., `delete <INDEX>` should be `delete 2`


### 1. Adding Entries: `add`
Adds a new entry to the system.

Format: `add D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`
`<date>` should be in the format **DD-MM-YY**

Example: 
```
add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper
____________________________________________________________
The following entry has been added:
Date: [02-03-2023] | Species: [Annam Leaf Turtle] | Name: [Ariel] | Remark: [Injured left flipper]
Now you have 1 entries in the list.
____________________________________________________________
```


[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

---

### 2. Deleting Entries: `delete`
Deletes an entry. 

Format: `delete INDEX`
Deletes the entry at the specified INDEX. 
The index refers to the index number shown in the displayed entry list.

> ✏ Notes on `INDEX`
> * Index must be a positive integer 1, 2, 3, ...
> * Deleted items may not be recoverable

Example:
```
delete 1
____________________________________________________________
The entry has been removed.
Now you have 0 entries in the list.
____________________________________________________________
```


[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

### 3. Listing Entries: `list`
Shows a list of all entries of wildlife in the WildWatch so far.
Shows useful information about each entry.
Information such as the species, name, age, gender, size, remarks are shown together.

Format: `list` 

Example: 
```
________________________________________
list
________________________________________
There are 2 entries in the list:

Species: Low land gorilla | Name: gorilla_01 | Age: | Gender: | Size: | Remarks:

Species: African elephant | Name: strongOne | Age: 25 | Gender: M | Size: 5.5M | Remarks: Herd leader
```

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

### 4. Adding Entries: `edit`
Edits an entry in the system.

Format: `edit I/<INDEX> D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`
`<date>` should be in the format **DD-MM-YY**

`I/<INDEX>` argument is required.

Example:
```
edit I/1 D/02-03-24 S/Annam Leaf Turtle N/Ariel R/Injured left flipper
____________________________________________________________
The following entry has been edited:
Date: [02-04-2024] | Species: [Annam Leaf Turtle] | Name: [Javier] | Remark: [Injured right flipper]
____________________________________________________________
```
```
edit I/1 S/Green Leaf Turtle
____________________________________________________________
The following entry has been edited:
Date: [02-03-2023] | Species: [Green Leaf Turtle] | Name: [Ariel] | Remark: [Injured left flipper]
____________________________________________________________
```

--------------------------------------------------------------------------------------------------------------------------------------
### 5. Listing Entries: `summary`
Shows a summary of all wildlife in the WildWatch system.

Format: `summary <SPECIES>`

`<SPECIES>` argument is optional. When specified, it will show a summary of the wildlife recorded for the specified species.

Example:
```
________________________________________
summary
________________________________________
Here are the species recorded: 
Annam Leaf Turtle - (2)
Green Leaf Turtle - (1)
```
```
____________________________________________________________
summary Annam Leaf Turtle
____________________________________________________________
Here is the data for the Annam Leaf Turtle, grouped by their names
Javier - (1)
Ariel - (1)
____________________________________________________________
```

### 6. Getting Help : `help`
Shows the user how to use all the commands.

Format: `help`

Example:
```
____________________________________________________________
help
____________________________________________________________
No worries, I'm here to help!
____________________________________________________________

---------------------------HELP PAGE-----------------------------

_________________________________________________________________
1.  Get help - show the list of commands available for this app
     Format: help
     Examples: 
       help

_________________________________________________________________
2.  To add a new wildlife
     Format: add D/DATE S/SPECIES N/NAME R/REMARKS
       DATE should be in the format DD-MM-YY
     Examples: 
       add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper

_________________________________________________________________
3.  To list all wildlife,
     Format: list
     Examples: 
       list

_________________________________________________________________
4.  To delete a wildlife
     Format: delete INDEX
       The index refers to the index number shown in the displayed observation list.
       Note:
           - The index must be a positive integer:
           - Deleted items may not be recoverable:
     Examples: 
       delete 1
_________________________________________________________________

-------------------------HELP PAGE END---------------------------
```

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

## FAQ

> **Q**: Why do I get the `OOPS!!! Invalid Date input :-(` error?  

Ensure the day, month, year is separated by `-` e.g., `23-05-23` in **DD-MM-YY** format.  

> **Q**: I found a bug! What do I do?  

Great! Please contact [Min](https://github.com/woodenclock), your help is greatly appreciated!

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Command Reference 🐱

| Action         | Format                                                     |
| -------------- |------------------------------------------------------------|
| Getting Help   | `help`                                                     |
| Add Entries    | `add D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`            |
| Delete Entries | `delete <INDEX>`                                           |
| Delete Entries | `edit I/<INDEX> D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>` |
| Delete Entries | `summary <SPECIES>`                                        |
| List Entries   | `list`                                                     |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
