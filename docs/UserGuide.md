# WildWatch User Guide 🐘

## Table of Contents 
- [Introduction](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#introduction-)
    - [How to use the User Guide](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#how-to-use-the-user-guide)
    - [Legend](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#legend)
- [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#quick-start-)
- [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features-)
    - [Adding Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#1-adding-entries-add): `add`
        -  [Standard Mode](#11-standard-mode)
        -  [Interactive Mode](#12-interactive-mode-add-i)
    - [Deleting Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#2-deleting-entries-delete): `delete`
    - [Listing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#3-listing-entries-list): `list`
    - [Editing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#4-editing-entries-edit): `edit`
    - [Summarizing Entries](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#5-summarizing-entries-summary): `summary`
    - [Exporting Entries](#6-exporting-your-entries-export)
    - [Getting Help](#7-getting-help--help): `help` 
- [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#faq-)
- [Command Summary](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#command-summary-)
- [Glossary](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#glossary-)
    
--------------------------------------------------------------------------------------------------------------------------------------
  
## Introduction 🐻
Welcome aboard fellow animal lover! We are really excited to have you here! 😉  
Wildwatch is a program for a clerk managing wildlife data in a wildlife reserve via the [Command Line Interface (CLI)](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#glossary-).  
The purpose of this user guide is to familiarize you with the program and help you when you face a problem using it.  
Its main job is to store and present animal data, this would make your job so much more convenient!

### How to use the User Guide  
- Are you new here?  
No worries, head to the [Quick Start](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#quick-start-) page, and you will be up and running in no time!  
- Lost among the pages?  
Head to the [Table of Contents](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents) to look for the right pages.  
- Need help with the functionalities?  
Head to the [Features](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#features-) page for detailed guidance.  
- Do you have a question for us?  
Head to the [FAQ](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#faq-) page.  
- Do you want a concise summary of all functionalities?  
Head to the [Command Summary](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#command-summary-) page for a summary of all commands.
- Not sure what that word meant?  
Head to the [Glossary](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#glossary-) page for its meaning.  

### Legend

 Symbol         | Meaning
 -------------- |------------------------------------------------------------
 ❗ IMPORTANT   | These are important instructions that you should follow.  
 ⬆ Back to top  | Click to scroll back up to the `Table of Contents`.
 🐵 🦊 🦁      | Your cute animal friends pop up to let you know that you have reached a new section.

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Quick Start 🐵

1. Ensure you have Java 11 or above installed in your Computer. (What is my [Java version](https://www.java.com/en/download/help/version_manual.html)?)
   
2. Download the latest `WildWatch.jar` from [here](https://github.com/AY2324S1-CS2113T-W11-2/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your WildWatch.

4. Open a command terminal, `cd` into the folder you put the jar file in, and run the following command: `java -jar WildWatch.jar`.
You should see the welcome screen as the diagram below.

5. Type commands  beside `>>>` and press `Enter` to execute it. (e.g. typing `help` and pressing `Enter` will show the help page).
Some example commands you can try:
- `list` : Lists all entries.  
- `bye` : Exits the program.  

![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/c110856f-dd16-4c5c-8205-446d86425ddb)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Features 🦊
> ❗ IMPORTANT
> * Capitalized words between angle brackets `< >` are information to be written appropriately by the user.
> * E.g., `delete <INDEX>` should be `delete 2`
  
  
### 1. Adding Entries: `add`
Adds a new entry to the system.

#### 1.1 Standard Mode 
Format: `add D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`

`<date>` should be in the format **DD-MM-YY**

Example:  
![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/db83c0d5-5ba6-4db7-9f57-bb86b4f4cc07)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

#### 1.2 Interactive Mode: `add i/`
If you're prone to forgetting fields to include in the `add` command, have no fear, we've got your back! You may choose to use the `add i/` command instead, which triggers the interactive add mode. 
It helpfully prompts you for data each step of the way, and notifies you when you've left a mandatory field blank, so you don't have to worry about getting it wrong!

Format: `add i/`

![image](https://github.com/lctxct/tp/assets/70379887/21db0b5d-1f76-40b0-a73d-92fbc5204b04)


### 2. Deleting Entries: `delete`
Deletes an entry. 

Format: `delete INDEX`
Deletes the entry at the specified INDEX. 
The index refers to the index number shown in the displayed entry list.

>❗ IMPORTANT
> * Index must be a positive integer 1, 2, 3, ...
> * Deleted items may not be recoverable

Example:  
![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/6c43700c-909b-490e-b497-ef370664ff9e)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
  
  
### 3. Listing Entries: `list`
Shows a list of all entries of wildlife in the WildWatch so far.
Shows useful information about each entry.
Information such as the species, name, age, gender, size, remarks are shown together.

Format: `list` 

Example:  
![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/ef21314f-fb23-4bd6-bcfd-fddfa8fb0330)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
  
  
### 4. Editing Entries: `edit`
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

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
  
  
### 5. Summarizing Entries: `summary`
Shows a summary of all wildlife in the WildWatch system by the species type.

Format: `summary <SPECIES>`

`<SPECIES>` argument is optional. When specified, it will show a summary of the wildlife recorded for the specified species.

Example:  
![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/4a089c9f-ef0a-4c57-96a1-48479614ac9c)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)  

### 6. Exporting your entries: `export` 
Maybe you need to share the entries you've collected with someone else. In that case, we also provide the option for you to export your data as a Comma Separated Values (CSV) file. CSV files can be recognized and imported into universally-used tools such as Microsoft Excel, allowing you to share your data and insights with others. 

Format: `export <FILENAME>`

`<FILENAME>` is optional. However, if you choose to include it, note that it should end with the file extension `.csv` so that it can be recognized as a CSV. If unspecified, your data will be written to the default file `WildWatch.csv`. 

We also guide you through the process of selecting the columns that you want to include in your CSV, if you only want to share some parts of the data. 

![image](https://github.com/lctxct/tp/assets/70379887/bf1d866f-3003-4deb-818a-e1023fb9813c)

    
### 7. Getting Help : `help`
Shows the user how to use all the commands.

Format: `help`

Example:  
![image](https://github.com/AY2324S1-CS2113T-W11-2/tp/assets/69474977/2e76abd5-64bc-4739-ab6e-cc57b243900b)

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## FAQ 🦁

> **Q**: Why do I get the `OOPS!!! Invalid Date input :-(` error?  

Ensure the day, month, year is separated by `-` e.g., `23-05-23` in **DD-MM-YY** format.  

> **Q**: I found a bug! What do I do?  

Great! Please contact [Min](https://github.com/woodenclock), your help is greatly appreciated!

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Command Summary 🐱

| Action                    | Format                                                     |
| ------------------------- | ---------------------------------------------------------- |
| Getting Help              | `help`                                                     |
| Add Entries               | `add D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>`            |
| Add Entries (interactive) | `add i/`                                                   |
| Delete Entries            | `delete <INDEX>`                                           |
| Edit Entries              | `edit I/<INDEX> D/<DATE> S/<SPECIES> N/<NAME> R/<REMARKS>` |
| Summarizing Entries       | `summary <SPECIES>`                                        |
| List Entries              | `list`                                                     |
| Export Entries            | `export <FILENAME>`                                        |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)

--------------------------------------------------------------------------------------------------------------------------------------

## Glossary 🐨
We are here to help you with terminologies used in the user guide, that may not be familiar to you.

| Terminology    | Meaning                                                     |
| -------------- |------------------------------------------------------------|
| Command Line Interface   | A way to communicate with your computer using texts. |

[⬆ Back to top](https://ay2324s1-cs2113t-w11-2.github.io/tp/UserGuide.html#table-of-contents)
