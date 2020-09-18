import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import Task.*;

public class Duke {
    // Maximum number of tasks
    final static int MAX_TASKS = 100;
    // Initialize array of tasks
    public static Task[] list = new Task[MAX_TASKS];
    // Keep track of number of existing tasks in list
    public static int inputCount = 0;
    // FilePath
    public static String filePath = "duke.txt";
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
    public static final String MISSING_FILE_MESSAGE = "Error: File not found!";
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
        System.out.println(EXIT_MESSAGE);
    }
    // Label task as done
    public static void doneTask(String task) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int doneTask = Integer.parseInt(task.replaceAll("[\\D]",""));
            list[doneTask - 1].markAsDone();
            System.out.println(BORDER);
            System.out.println(MARK_AS_DONE_MESSAGE);
            System.out.println(INDENTATION + list[doneTask - 1].toString());
            System.out.println(BORDER);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_DONE_INPUT);
        } catch (NullPointerException e) {
            System.out.println(EMPTY_DONE_INPUT);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(INVALID_DONE_INPUT_OUT_OF_BOUNDS);
        }
    }
    // List all tasks stored
    public static void listTasks() {
        System.out.println(LIST_TASKS_MESSAGE);
        System.out.println(BORDER);
        for(int i = 0; i < inputCount; i++) {
            System.out.println((i+1) + "." + list[i].toString());
        }
        System.out.println(BORDER);
    }
    // Delete the selected task
    public static void deleteTask(String indexToDelete) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int toDelete = Integer.parseInt(indexToDelete.replaceAll("[\\D]", ""));
            toDelete--;
            String toPrint = list[toDelete].toString();
            System.out.println(BORDER);
            System.out.println(DELETED_TASK_MESSAGE);
            System.out.println(INDENTATION + toPrint);
            Task[] newList = new Task[MAX_TASKS];
            for (int i = 0, j = 0; i < inputCount; i++) {
                if (i == toDelete) {
                    continue;
                }
                newList[j++] = list[i];
            }
            inputCount--;
            list = newList;
            System.out.println("Now you have " + inputCount + " tasks in the list.");
            System.out.println(BORDER);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_DELETE_INPUT_FORMAT);
        } catch (NullPointerException e) {
            System.out.println(EMPTY_DELETE_INPUT);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(INVALID_DELETE_INPUT_OUT_OF_BOUNDS);
        }
    }
    // Add todo task from user input
    public static void addToDo(String description) {
        list[inputCount] = new ToDo(description);
        System.out.println(BORDER);
        System.out.println(ADDED_TASK_MESSAGE);
        System.out.println(INDENTATION + list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println(BORDER);
        inputCount++;
    }
    // Load todo from text file
    public static void loadToDo(int i, String description) {
        list[i] = new ToDo(description);
        inputCount++;
    }
    // Add deadline from user input
    public static void addDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        list[inputCount] = new Deadline(splitDesc[0], splitDesc[1]);
        System.out.println(BORDER);
        System.out.println(ADDED_TASK_MESSAGE);
        System.out.println(INDENTATION + list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println(BORDER);
        inputCount++;
    }
    // Load deadline from text file
    public static void loadDeadline(int i,String desc) {
        String[] splitDesc = desc.split("/by");
        list[i] = new Deadline(splitDesc[0], splitDesc[1]);
        inputCount++;
    }
    // Add event from user input
    public static void addEvent(String event) {
        String[] splitEvent = event.split("/at");
        list[inputCount] = new Event(splitEvent[0],splitEvent[1]);
        System.out.println(BORDER);
        System.out.println(ADDED_TASK_MESSAGE);
        System.out.println(list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println(BORDER);
        inputCount++;
    }
    // Load event from text file
    public static void loadEvent(int i, String event) {
        String[] splitEvent = event.split("/at");
        list[i] = new Event(splitEvent[0],splitEvent[1]);
        inputCount++;
    }
    // Format task details to save in text file
    public static String toSave(Task t) {
        return(t.getType() + " > " + t.isDone + " > " + t.toStringToSave());
    }
    // Load text file contents into program
    private static void loadFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        if(!sc.hasNext()) {
            inputCount = 0;
        } else {
            int inputCount = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < inputCount; i++) {
                String taskLine = sc.nextLine();
                // Split the task details into type, isDone, and description
                String[] taskDetails = taskLine.split(" > ");
                // Load each existing task in text file into the program
                switch(taskDetails[0]) {
                    case "E":
                        loadEvent(i,taskDetails[2]);
                        list[i].isDone = Boolean.parseBoolean(taskDetails[1]);
                        break;
                    case "T":
                        loadToDo(i,taskDetails[2]);
                        list[i].isDone = Boolean.parseBoolean(taskDetails[1]);
                        break;
                    case "D":
                        loadDeadline(i,taskDetails[2]);
                        list[i].isDone = Boolean.parseBoolean(taskDetails[1]);
                        break;

                }
            }
        }
    }
    // Save contents in program into text file
    public static void saveFileContents(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            // Write inputCount to first line of file
            fw.write(Integer.toString(inputCount));
            fw.write(System.lineSeparator());
            for(int i = 0; i < inputCount; i++) {
                fw.write(toSave(list[i]));
                fw.write(System.lineSeparator());
            }
            fw.close();
            System.out.println(SAVE_SUCCESS_MESSAGE);
        } catch (IOException e) {
            System.out.println(SAVE_FAILED_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Load file
        try {
            loadFileContents(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(MISSING_FILE_MESSAGE);
        }
        printGreeting();

        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.next();
            // Exit Command
            if(input.equals("bye")) {
                saveFileContents(filePath);
                printGoodbye();
                break;
            }
            else {
                // Check for other commands
                switch(input) {
                case ("list"):
                    listTasks();
                    break;

                case ("done"):
                    String done = sc.nextLine();
                    doneTask(done);
                    break;

                case ("delete"):
                    String delete = sc.nextLine();
                    deleteTask(delete);
                    break;

                case ("todo"):
                    String description = sc.nextLine();
                    // Throw exception if description is empty
                    try {
                        if (description.equals("")) {
                            throw new DukeException();
                        }
                        addToDo(description);
                    } catch (DukeException e) {
                        System.out.println(EMPTY_TODO_INPUT);
                    }
                    break;

                case ("deadline"):
                    String desc = sc.nextLine();
                    try {
                        if(desc.equals("")) {
                            throw new DukeException();
                        }
                        addDeadline(desc);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(INVALID_DEADLINE_INPUT);
                    } catch (DukeException e) {
                        System.out.println(EMPTY_DEADLINE_INPUT);
                    }
                    break;

                case ("event"):
                    String event = sc.nextLine();
                    try {
                        if(event.equals("")) {
                            throw new DukeException();
                        }
                        addEvent(event);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(INVALID_EVENT_INPUT);
                    } catch (DukeException e) {
                        System.out.println(EMPTY_EVENT_INPUT);
                    }
                    break;

                default:
                    sc.nextLine();
                    System.out.println(INVALID_INPUT);
                }
            }
        }
    }
}