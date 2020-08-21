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
        String[] list = new String[100];
        while(true) {
            String input = sc.nextLine();
            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if(input.equals("list")) {
                for(int i = 0;i < inputs; i++) {
                    System.out.println((i+1) + ": " + list[i]);
                }
            } else {
                System.out.println(input);
                list[inputs] = input;
                inputs++;
            }
        }
    }
}
