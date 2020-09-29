import Task.DukeException;
import java.util.Scanner;

public class Parser {
    public static void parseAndExecute() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String keyCommand = sc.next();
            // Exit Command
            if (keyCommand.equals("bye")) {
                Storage.saveFileContents();
                Ui.printGoodbye();
                break;
            } else {
                // Check for other commands
                switch (keyCommand) {
                case ("find"):
                    String keyWord = sc.nextLine();
                    TaskList.findTask(keyWord);
                    break;

                case ("list"):
                    Ui.listTasks();
                    break;

                case ("done"):
                    String done = sc.nextLine();
                    TaskList.doneTask(done);
                    break;

                case ("delete"):
                    String delete = sc.nextLine();
                    TaskList.deleteTask(delete);
                    break;

                case ("todo"):
                    String description = sc.nextLine();
                    // Throw exception if description is empty
                    try {
                        if (description.equals("")) {
                            throw new DukeException();
                        }
                        TaskList.addToDo(description);
                    } catch (DukeException e) {
                        System.out.println(Messages.EMPTY_TODO_INPUT);
                    }
                    break;

                case ("deadline"):
                    String desc = sc.nextLine();
                    try {
                        if (desc.equals("")) {
                            throw new DukeException();
                        }
                        TaskList.addDeadline(desc);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(Messages.INVALID_DEADLINE_INPUT);
                    } catch (DukeException e) {
                        System.out.println(Messages.EMPTY_DEADLINE_INPUT);
                    }
                    break;

                case ("event"):
                    String event = sc.nextLine();
                    try {
                        if (event.equals("")) {
                            throw new DukeException();
                        }
                        TaskList.addEvent(event);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(Messages.INVALID_EVENT_INPUT);
                    } catch (DukeException e) {
                        System.out.println(Messages.EMPTY_EVENT_INPUT);
                    }
                    break;

                default:
                    sc.nextLine();
                    System.out.println(Messages.INVALID_INPUT);
                }
            }
        }
    }
}
