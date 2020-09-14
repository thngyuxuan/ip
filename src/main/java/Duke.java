import java.util.Scanner;

public class Duke {
    // Maximum number of tasks
    final static int MAX_TASKS = 100;
    // Initialize array of tasks
    public static Task[] list = new Task[MAX_TASKS];
    // Keep track of number of existing tasks in list
    public static int inputCount = 0;
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
    // Function to label task as done
    public static void doneTask(String task) throws NumberFormatException {
        try {
            int doneTask = Integer.parseInt(task.replaceAll("[\\D]",""));
            list[doneTask - 1].markAsDone();
            System.out.println("______________________________________________");
            System.out.println("Done. I have marked this task as done:");
            System.out.println("   " + list[doneTask - 1].toString());
            System.out.println("______________________________________________");
        } catch (NumberFormatException e) {
            System.out.println("Error: Did not specify which task is completed!");
        }
    }
    // Function to list all tasks stored
    public static void listTasks() {
        System.out.println("Here are the tasks in your list:");
        System.out.println("______________________________________________");
        for(int i = 0; i < inputCount; i++) {
            System.out.println((i+1) + "." + list[i].toString());
        }
        System.out.println("______________________________________________");
    }

    public static void deleteTask(String delete) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int toDelete = Integer.parseInt(delete.replaceAll("[\\D]", ""));
            toDelete--;
            String toPrint = list[toDelete].toString();
            System.out.println("______________________________________________");
            System.out.println("Noted. I've removed this task:");
            System.out.println("   " + toPrint);
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
            System.out.println("______________________________________________");
        } catch (NumberFormatException e) {
            System.out.println("Error: Did not specify which task to delete!");
        } catch (NullPointerException e) {
            System.out.println("Error: Task does not exist!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid number!");
        }
    }

    public static void addToDo(String description) {
        list[inputCount] = new ToDo(description);
        System.out.println("______________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println("______________________________________________");
        inputCount++;
    }

    public static void addDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        list[inputCount] = new Deadline(splitDesc[0], splitDesc[1]);
        System.out.println("______________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println("______________________________________________");
        inputCount++;
    }

    public static void addEvent(String event) {
        String[] splitEvent = event.split("/at");
        list[inputCount] = new Event(splitEvent[0],splitEvent[1]);
        System.out.println("______________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(list[inputCount].toString());
        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
        System.out.println("______________________________________________");
        inputCount++;
    }

    public static void main(String[] args) {
        printGreeting();

        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.next();
            // Exit Command
            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
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
                        System.out.println("Error: Did not specify todo description!");
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
                        System.out.println("Error: Did not specify deadline correctly!");
                    } catch (DukeException e) {
                        System.out.println("Error: Did not specify deadline!");
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
                        System.out.println("Error: Did not specify event correctly!");
                    } catch (DukeException e) {
                        System.out.println("Error: Did not specify event!");
                    }
                    break;

                default:
                    sc.nextLine();
                    System.out.println("Please specify task type!");
                }
            }
        }
    }
}