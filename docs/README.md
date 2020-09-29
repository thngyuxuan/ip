# User Guide

## Introduction
Duke is a program which runs on Java 11. This guide will explain to you how to use Duke to keep track of your tasks in your everyday life.

## Features 
Duke allows you to store 3 different kinds of tasks in your everyday life: ToDo, Event and Deadline. Coupled with simple commands, you can tell Duke to store these tasks and keep track of what has been done and what's not. Also, it includes a simple search function that tells you the tasks you have which contains a keyword.

### Add Todo Task
This feature allows you to add a task simply with a description. For example, it can be something as simple as 'buy milk' or 'do laundry'.

### Add Event Task
This feature allows you to add a task which is an event. You may do so by adding its description, followed by a '/at', and finally the location of the event. Duke will store the description as well as the location of the event for you.

### Add Deadline Task
This feature allows you to add a task which is a deadline. You may do so by adding its description, followed by '/by', and finally the deadline itself. Duke will store the deadline description as well as the deadline itself.

### Find
This feature allows you to find a task in Duke that contains a certain keyword. For example, if you want to find all tasks that contain the word 'milk', Duke can search and tell you the tasks that have the word 'milk'.

### List
This feature allows you to list all tasks existing in Duke.

### Delete
This feature allows you to delete tasks in Duke. Type 'delete' followed by the task number to delete that specific task in Duke.

## Usage

### `todo` - Adds Todo Task

Adds a todo task to Duke. Duke will store the task.

Example of usage: 

`todo buy milk`

Expected outcome:

`Got it. I've added this task:`
   
`[T][✘] buy milk`

`Now you have 1 tasks in the list.`

### `event` - Adds Event Task

Adds an event task to Duke. Duke will store the task.

Example of usage: 

`event CS2113 Lecture /at COM1`

Expected outcome:

`Got it. I've added this task:`
    
`[E][✘] CS2113 lecture (at: COM1)`
 
`Now you have 2 tasks in the list.`
 
 
### `deadline` - Adds Deadline Task

Adds a deadline task to Duke. Duke will store the task.

Example of usage: 

`deadline CS2113 IP /by this friday`

Expected outcome:

`Got it. I've added this task:`
    
`[D][✘] CS2113 IP (by: this friday)`
 
`Now you have 3 tasks in the list.`

### `list` - Lists All Tasks

Lists all tasks stored in Duke. Duke will print out all tasks that is currently stored.

Example of usage:

`list`

Expected outcome:

`Here are the tasks in your list:`
`______________________________________________`

`1.[T][✘] buy milk`

`2.[E][✘] CS2113 Lecture (at: COM1)`

`3.[D][✘] CS2113 IP (by: this friday)`

`______________________________________________`

### `done` - Marks Selected Task As Done

Marks the selected task as done. Type 'done' followed by the task number in Duke. You may use the list command to find the task number of each task in Duke.

Example of usage:

`done 1`

Expected outcome:

`Done. I have marked this task as done:`

`[T][✓] buy milk`

### `find` - Finds Task With Keyword

Finds all tasks stored in Duke that contains the keyword. Type 'find' followed by the keyword. Note that the task numbers displayed here do not represent the actual task numbers.

Example of usage:

`find CS2113`

Expected outcome:

`Here are the matching tasks in your list:`
`______________________________________________`

`1.[E][✘] CS2113 Lecture (at: COM1)`

`2.[D][✘] CS2113 IP (by: this friday)`

`______________________________________________`
 
### `delete` - Deletes Selected Task

Deletes the selected task in Duke. Duke will no longer store the task. Type 'delete' followed by the task number. You may find the task numbers in Duke by using the list command.

Example of usage:

`delete 2`

Expected outcome:

`Noted. I've removed this task:`

`[E][✘] CS2113 Lecture (at: COM1)`

`Now you have 2 tasks in the list.`




