/**
 * Class to handle the user's interaction wtih Duke.
 * The functions to print messages are mostly here.
 */

public class Ui {
    // Print greeting message upon startup of program
    public static void printGreeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        // Greeting Message
        System.out.println("Hello, I'm Duke!");
        System.out.println("What can I do for you?");
    }
    // Print goodbye message upon exiting
    public static void printGoodbye() {
        System.out.println(Messages.EXIT_MESSAGE);
    }

    /**
     * Prints the messages when a new task is added.
     */
    public static void addTaskMessages() {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.ADDED_TASK_MESSAGE);
        System.out.println(Messages.INDENTATION + TaskList.list.get(TaskList.inputCount).toString());
        System.out.println("Now you have " + (TaskList.inputCount + 1) + " tasks in the list.");
        System.out.println(Messages.BORDER);
    }

    /**
     * Prints the entire list when the list command
     * is read.
     */
    public static void listTasks() {
        System.out.println(Messages.LIST_TASKS_MESSAGE);
        System.out.println(Messages.BORDER);
        for(int i = 0; i < TaskList.inputCount; i++) {
            System.out.println((i+1) + "." + TaskList.list.get(i).toString());
        }
        System.out.println(Messages.BORDER);
    }

    /**
     * Prints the messages when a task is deleted from
     * the list. It tells the user what task is being
     * deleted and the number of tasks remaining.
     * The argument task must be a string that represents
     * the task that is being deleted.
     *
     * @param task
     */
    public static void deleteTaskMessages(String task) {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.DELETED_TASK_MESSAGE);
        System.out.println(Messages.INDENTATION + task);
        System.out.println("Now you have " + TaskList.inputCount + " tasks in the list.");
        System.out.println(Messages.BORDER);
    }

    /**
     * Prints the message when Duke cannot
     * locate the text file.
     */
    public static void printMissingFile() {
        System.out.println(Messages.MISSING_FILE_MESSAGE);
    }

    /**
     * Prints the messages when the find command
     * is read.
     */
    public static void findTaskMessages() {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.FIND_TASK_MESSAGE);
        System.out.println(Messages.BORDER);

    }

    /**
     * Prints the messages when a task is being marked
     * as done. The argument task must be a string that
     * represents the task that is being marked done.
     *
     * @param task a string that represents
     *             the task that is being marked
     *             as done
     */
    public static void markDoneMessages(String task) {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.MARK_AS_DONE_MESSAGE);
        System.out.println(Messages.INDENTATION + task.toString());
        System.out.println(Messages.BORDER);
    }

    /**
     * Prints the error messages for invalid user inputs.
     * The argument type specifies the type of invalid input
     * error messages the function displays.
     *
     * @param type the type of error message to display
     */
    public static void printInvalidInput(String type) {
        switch(type) {
        case "done":
            System.out.println(Messages.INVALID_DONE_INPUT);
        case "doneOOB":
            System.out.println(Messages.INVALID_DONE_INPUT_OUT_OF_BOUNDS);
        case "delete":
            System.out.println(Messages.INVALID_DELETE_INPUT_FORMAT);
        case "deleteOOB":
            System.out.println(Messages.INVALID_DELETE_INPUT_OUT_OF_BOUNDS);
        }
    }

    /**
     * Prints the error messages for empty user input.
     * The argument type specifies the type of empty input
     * error messages the function displays.
     *
     * @param type the type of error message to display
     */
    public static void printEmptyInput(String type) {
        switch(type) {
        case "done":
            System.out.println(Messages.EMPTY_DONE_INPUT);
        case "delete":
            System.out.println(Messages.EMPTY_DELETE_INPUT);
        case "find":
            System.out.println(Messages.EMPTY_FIND_INPUT);
        }
    }

    /**
     * Prints out message for when there is no tasks found
     * with user's 'find' keyword.
     */
    public static void printEmptySearchList() {
        System.out.println(Messages.EMPTY_FIND_LIST);
    }
}

