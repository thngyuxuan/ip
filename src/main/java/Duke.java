import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Duke {
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

    public static void main(String[] args) {
        final int MAX_TASKS = 100;
        printGreeting();

        Scanner sc = new Scanner(System.in);
        int inputCount = 0;
        Task[] list = new Task[MAX_TASKS];

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
                    System.out.println("Here are the tasks in your list:");
                    for(int i = 0;i < inputCount; i++) {
                        System.out.print((i+1) + ".");
                        System.out.println(list[i].toString());
                    }
                    break;

                case ("done"):
                    try {
                        String done = sc.nextLine();
                        int doneTask = Integer.parseInt(done);
                        list[doneTask - 1].markAsDone();
                        System.out.println(list[doneTask - 1].toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Did not specify which task is completed!");
                    }
                    break;

                case ("todo"):
                    try {
                        String description = sc.nextLine();
                        if(description.equals("")) {
                            throw new DukeException();
                        }
                        list[inputCount] = new ToDo(description);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(list[inputCount].toString());
                        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
                        inputCount++;
                    } catch (DukeException e) {
                        System.out.println("Error: Did not specify todo task!");
                    }
                    break;

                case ("deadline"):
                    try {
                        String desc = sc.nextLine();
                        if(desc.equals("")) {
                            throw new DukeException();
                        }
                        String[] splitDesc = desc.split("/by");
                        list[inputCount] = new Deadline(splitDesc[0], splitDesc[1]);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(list[inputCount].toString());
                        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
                        inputCount++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Did not specify deadline correctly!");
                    } catch (DukeException e) {
                        System.out.println("Error: Did not specify deadline!");
                    }
                    break;

                case ("event"):
                    try {
                        String event = sc.nextLine();
                        if(event.equals("")) {
                            throw new DukeException();
                        }
                        String[] splitEvent = event.split("/at");
                        list[inputCount] = new Event(splitEvent[0],splitEvent[1]);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(list[inputCount].toString());
                        System.out.println("Now you have " + (inputCount + 1) + " tasks in the list.");
                        inputCount++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Did not specify event correctly!");
                    } catch (DukeException e) {
                        System.out.println("Error: Did not specify event!");
                    }
                    break;

                default:
                    System.out.println("Please specify task type!");
                }
            }
        }
    }
}
