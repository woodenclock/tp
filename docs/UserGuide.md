# WildWatch User Guide 🐘


Wildwatch is a program for a clerk managing animal entries in a wildlife reserve via the Command Line Interface (CLI).

--------------------------------------------------------------------------------------------------------------------------------------
## Table of Contents 
- [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#quick-start-)
- [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features-)
    - [Getting Help](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#1-getting-help--help): `help`
    - [Adding Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#2-adding-entries-add): `add`
    - [Deleting Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#3-deleting-entries-del): `del`
    - [Listing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#4-listing-entries-list): `list`
- [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#faq)
- [Command reference](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#command-reference-)
    
--------------------------------------------------------------------------------------------------------------------------------------

## Quick Start 🐵

1. Ensure you have Java 11 or above installed in your Computer.
   
1. Download the latest `WildWatch.jar` from [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases).

1. Copy the file to the folder you want to use as the home folder for your WildWatch.

1. Open a command terminal, `cd` into the folder you put the jar file in, and run the following command: `java -jar WildWatch.jar`.
You should see the welcome screen as follows.

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
```

5. Type commands below the horizontal line and press `Enter` to execute it. (e.g. typing `help` and pressing `Enter` will show the help page).
Some example commands you can try:
- `list` : Lists all entries.
- `bye` : Exits the program.

Refer to the features below for details of each command.

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Features 🦊
>❗IMPORTANT
> * Capitalized words between <> chevrons are parameters to be substituted appropriately
> * E.g., `delete <INDEX>` should be `delete 2`


### 1. Getting Help : `help`
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

### 2. Adding Entries: `add`
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

### 3. Deleting Entries: `del`
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

### 4. Listing Entries: `list`
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

--------------------------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: Why do I get the `Invalid Date/Time input` error?
**A**: Ensure there is only 1 whitespace between date and time.

**Q**: I found a bug! What do I do?
**A**: Great! Please contact [Min](https://github.com/woodenclock), your help is greatly appreciated!

--------------------------------------------------------------------------------------------------------------------------------------

## Command Reference 🐱

| Action         | Format |
| -------------- | ------ |
| Getting Help   | `help` |
| Add Entries    | `add D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`  |
| Delete Entries | `delete <INDEX>`  |
| List Entries   | `list` |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
