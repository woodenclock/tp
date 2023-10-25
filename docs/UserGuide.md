# WildWatch 

Wildwatch is a program for recording, and finding animals in a wildlife reserve via the Command Line Interface (CLI).

---
## Table of Contents 
- [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#quick-start)
- [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features)
    - [Getting Help](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#1-getting-help--help): `help`
    - [Adding Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#2-adding-entries-add): `add`
    - [Deleting Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#3-deleting-entries-del): `del`
    - [Listing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#4-listing-entries-list): `list`
- [Command reference](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#command-reference)
    
--- 

## Quick Start

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

Refer to the [features](https://hackmd.io/r8Nj6jFWTW2axYiqpQ_PHw?both#Features) below for details of each command.

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

## Features

### 1. Getting Help : `help`
Will display a URL/link to the complete online user guide, along with a  condensed summary of how to use every command.

//TODO: insert image of output 

Format: `help`

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

### 2. Adding Entries: `add`
Adds new entry. 

Format: `add D/<date> S/<species> N/<name> R/<remarks>`
`<date>` should be in the format **DD-MM-YY**

> :pencil: More than 1 species may be specified in one go if multiple new animals are added to the reserve on the same day. A new set of (species, name, remarks) should be specified for each addition. 

Examples: 
```
add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper
```
```
add D/10-11-20 S/Bali Myna N/Myna_1 R/ S/Malayan Water Monitor N/Monitor_1 R/Aggressive
```

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

---

### 3. Deleting Entries: `del`
Deletes entry. 

Format: `delete INDEX`
Deletes the observation at the specified INDEX. 
The index refers to the index number shown in the displayed observation list.

> :pencil: Notes on `INDEX`
> * Index must be a positive integer 1, 2, 3, ...
> * Deleted items may not be recoverable

Examples:
//TODO: insert the following 
list followed by delete 2 deletes the 2nd observation in the displayed list of observations.


[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

### 4. Listing Entries: `list`
Shows a list of all entries of wildlife in the WildWatch so far.
Shows useful information about each entry.
Information such as the species, name, age, gender, size, remarks are shown together.

Format: `list` 

Examples: 
```
________________________________________
list
________________________________________
There are 2 entries in the list:

Species: Low land gorilla | Name: gorilla_01 | Age: | Gender: | Size: | Remarks:

Species: African elephant | Name: strongOne | Age: 25 | Gender: M | Size: 5.5M | Remarks: Herd leader
```

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--- 

## Command Reference 

| Action         | Format |
| -------------- | ------ |
| List Entries   | `list` |
| Add Entries    | `add`  |
| Delete Entries | `del`  |
| Getting Help   | `help` |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
