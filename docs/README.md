# User Guide

Duke is a task management software that keeps track of todos, deadlines and events.

Please refer to the Setting Up section to learn how to set up Duke.



## Features

### Add task

Add a todo, deadline or event to Duke's task list.

### List all tasks

View all tasks in Duke's task list.

### Delete task

Remove a task from Duke's task list.

### Mark task as done

Change status of task to completed.

### Find tasks

Find a list of tasks matching search term.

### Auto-Save

Automatically saves to hard drive after every command and retrieves data from hard drive on startup.

## Usage

###  `todo`: Add Todo

Adds a todo to the task list.

Format: `todo NAME`

Examples of usage:

* `todo Math Homework`

### `deadline `: Add Deadline

Adds a deadline to the task list.

Format: `deadline NAME /by DEADLINE`

> :bulb: Follow the format `YYYY-MM-DD` for `DEADLINE` to be recognised as a date by Duke.

Examples of usage:

`deadline Math Homework /by 2020-09-11`

Adds `Math Homework` to the task list with a deadline of `11 Sep 2020`. This date is recognised as such by Duke.

* `deadline pay taxes /by Tuesday`

  Adds `pay taxes` to the task list with a deadline of `Tuesday` . Tuesday is not recognised as a date by Duke.

### `event`: Add Event

Adds an event to the task list.

Format: `event NAME`

Examples of usage:

* `event NDP Parade /at 09 Aug`

  Adds `NDP Parade` to the task list with a deadline of `09 Aug`.

### `list`: List All Tasks

Displays list of all tasks in task list.

Format of usage:

`list`

Expected outcome:

    ____________________________________________________________
     Here are the tasks in your list:
     1.[T][✓] read book
     2.[D][✗] return book (by: June 6th 2020)
     3.[E][✗] project meeting (at: Aug 6th 2-4pm)
     4.[T][✓] join sports club
     5.[T][✗] borrow book
    ____________________________________________________________
### `delete`: Deletes specified task.

Deletes specified task from task list. Command is used after `list` to get index number of task.

Format of usage:

`delete INDEX`

Examples of usage:

`delete 3`

Expected outcome:

    ____________________________________________________________
     Noted. I've removed this task: 
       [E][✗] project meeting (at: Aug 6th 2-4pm)
     Now you have 4 tasks in the list.
    ____________________________________________________________
### `done`: Marks Task as Done

Marks specified task as done. Command is used after `list` to get index number of task.

Format of usage:

`done INDEX`

Examples of usage:

`done 2` 

Expected outcome:

    ____________________________________________________________
     Nice! I've marked this task as done: 
      [T] [✓] return book
    ____________________________________________________________
### `find`: Find Matching Tasks

Search for tasks with names containing search term.

Examples of usage:

`find`

Expected outcome:

    ____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][✓] read book
     2.[D][✓] return book (by: June 6th)
    ____________________________________________________________
### `bye`: Exits Program

Exits Duke.

Format of usage:

`bye`

Expected outcome:

    ____________________________________________________________
     Bye. Hope to see you again soon!
    ____________________________________________________________


