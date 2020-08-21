import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello, I'm Duke!");
        System.out.println("What can I do for you?");
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        int inputs = 0;
        Task[] list = new Task[100];
        while(true) {
            String input = sc.nextLine();
            // Exit Command
            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            // List Command
            else if(input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int i = 0;i < inputs; i++) {
                    System.out.print((i+1) + ". ");
                    list[i].printTask();
                }
            }
            else {
                // Split into words to check whether done command is given
                String[] words = input.split(" ");
                if(words[0].equals("done")) {
                    if(words[1] == null) {
                        System.out.println("Invalid command!");
                    }
                    int doneTask = Integer.parseInt(words[1]) - 1;
                    list[doneTask].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    list[doneTask].printTask();
                } else {
                    System.out.println(input);
                    Task t = new Task(input);
                    list[inputs] = t;
                    inputs++;
                }
            }
        }
    }
}
