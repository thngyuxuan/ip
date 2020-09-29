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

    public static void addTaskMessages() {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.ADDED_TASK_MESSAGE);
        System.out.println(Messages.INDENTATION + TaskList.list.get(TaskList.inputCount).toString());
        System.out.println("Now you have " + (TaskList.inputCount + 1) + " tasks in the list.");
        System.out.println(Messages.BORDER);
    }

    // List all tasks stored
    public static void listTasks() {
        System.out.println(Messages.LIST_TASKS_MESSAGE);
        System.out.println(Messages.BORDER);
        for(int i = 0; i < TaskList.inputCount; i++) {
            System.out.println((i+1) + "." + TaskList.list.get(i).toString());
        }
        System.out.println(Messages.BORDER);
    }

    public static void deleteTaskMessages(String task) {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.DELETED_TASK_MESSAGE);
        System.out.println(Messages.INDENTATION + task);
        System.out.println("Now you have " + TaskList.inputCount + " tasks in the list.");
        System.out.println(Messages.BORDER);
    }

    public static void printMissingFile() {
        System.out.println(Messages.MISSING_FILE_MESSAGE);
    }

    public static void findTaskMessages() {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.FIND_TASK_MESSAGE);
        System.out.println(Messages.BORDER);

    }

    public static void markDoneMessages(String task) {
        System.out.println(Messages.BORDER);
        System.out.println(Messages.MARK_AS_DONE_MESSAGE);
        System.out.println(Messages.INDENTATION + task.toString());
        System.out.println(Messages.BORDER);
    }

    // Prints error messages for invalid user input
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

    // Prints error messages for empty user input
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

    public static void printEmptySearchList() {
        System.out.println(Messages.EMPTY_FIND_LIST);
    }
}

