import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        // Greeting Message
        System.out.println("Hello, I'm Duke!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        int inputs = 0;
        Task[] list = new Task[100];
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
                    for(int i = 0;i < inputs; i++) {
                        System.out.print((i+1) + ".");
                        System.out.println(list[i].toString());
                    }
                    break;

                case ("done"):
                    int done = sc.nextInt();
                    list[done - 1].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(list[done - 1].toString());
                    break;

                case ("todo"):
                    String description = sc.nextLine();
                    list[inputs] = new ToDo(description);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(list[inputs].toString());
                    System.out.println("Now you have " + (inputs + 1) + " tasks in the list.");
                    inputs++;
                    break;

                case ("deadline"):
                    String desc = sc.nextLine();
                    String[] splitDesc = desc.split("/by");
                    list[inputs] = new Deadline(splitDesc[0], splitDesc[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(list[inputs].toString());
                    System.out.println("Now you have " + (inputs + 1) + " tasks in the list.");
                    inputs++;
                    break;

                case ("event"):
                    String event = sc.nextLine();
                    String[] splitEvent = event.split("/at");
                    list[inputs] = new Event(splitEvent[0],splitEvent[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(list[inputs].toString());
                    System.out.println("Now you have " + (inputs + 1) + " tasks in the list.");
                    inputs++;
                    break;
                default:
                    System.out.println("Please specify your task type!");
                    break;
                }

            }
        }
    }
}
