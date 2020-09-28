public class Messages {
    public static String FILEPATH = "duke.txt";
    // String constants in program
    public static final String BORDER = "______________________________________________";
    public static final String INDENTATION = "   ";

    public static final String INVALID_INPUT = "Please specify command! (Available commands: todo, deadline, event, bye)";
    public static final String EMPTY_TODO_INPUT = "Error! Did not specify to-do task description! (Command format: todo <description>)";
    public static final String INVALID_DEADLINE_INPUT = "Error! Did not specify deadline correctly! (Command format: deadline <description> /by <input>)";
    public static final String EMPTY_DEADLINE_INPUT = "Error! Did not specify deadline! (Command format: deadline <description> /by <input>)";
    public static final String INVALID_EVENT_INPUT = "Error! Did not specify event correctly! (Command format: event <description> /at <input>)";
    public static final String EMPTY_EVENT_INPUT = "Error! Did not specify event! (Command format: event <description> /at <input>)";
    public static final String INVALID_DELETE_INPUT_FORMAT = "Error! Please check that you have input only numbers. (Command format: delete <Task Number>)";
    public static final String INVALID_DELETE_INPUT_OUT_OF_BOUNDS = "Error! Please check that you have input only numbers. (Command format: delete <Task Number from 1 to 100>)";
    public static final String EMPTY_DELETE_INPUT = "Error! Task does not exist! Please check if task exists in list. (Use 'list' command to find out existing tasks)";
    public static final String INVALID_DONE_INPUT = "Error! Did not specify which task is completed! (Command format: done <Task Number>)";
    public static final String EMPTY_DONE_INPUT = "Error! Task does not exist! Please check if task exists in list. (Use 'list' command to find out existing tasks)";
    public static final String INVALID_DONE_INPUT_OUT_OF_BOUNDS = "Error! Please check that you have input only numbers. (Command format: done <Task Number from 1 to 100>)";

    public static final String LIST_TASKS_MESSAGE = "Here are the tasks in your list:";
    public static final String ADDED_TASK_MESSAGE = "Got it. I've added this task:";
    public static final String MARK_AS_DONE_MESSAGE = "Done. I have marked this task as done:";
    public static final String DELETED_TASK_MESSAGE = "Noted. I've removed this task:";
    public static final String EXIT_MESSAGE = "Goodbye! Hope to see you again soon!";
    public static final String SAVE_SUCCESS_MESSAGE = "File saved successfully.";
    public static final String SAVE_FAILED_MESSAGE = "Error: File not found! (IOException)";
    public static final String MISSING_FILE_MESSAGE = "Error: File not found! New file created.";
}
