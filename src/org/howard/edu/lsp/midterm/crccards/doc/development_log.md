# Development Log - Question 1

## Resource 1: ChatGPT
**Prompt/Questions Asked:**
- What is the correct file structure for this project?
A: File structure:  
  src/org/howard/edu/lsp/midterm/crccards with Task.java, TaskManager.java, Driver.java, and a doc folder for markdown files.

- Assist me with creating CRC cards.
A: CRC Cards:  
  Task → stores task data, updates status  
  TaskManager → stores tasks, prevents duplicates, retrieves by status

- Help me implement Task and TaskManager classes.
A: Implementation guidance:  
  Use a HashMap to store tasks by taskId and an ArrayList to return filtered results.

**How it helped:**
Provided the correct package structure (`org/howard/edu/lsp/midterm/crccards`) and clarified where each file should be placed. Helped design CRC cards by identifying responsibilities and collaborators. Also guided implementation of Task and TaskManager, including use of HashMap to prevent duplicate task IDs and retrieve tasks by status.


## Resource 2: Lecture Notes

**How it helped:**
Reinforced how to assign responsibilities to classes and how TaskManager collaborates with Task.


## Summary
These resources helped structure the project correctly, implement required functionality, and design proper CRC cards.