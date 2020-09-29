/**
 * Class to read the user's input and execute the respective commands.
 */

import task.DukeException;
import java.util.Scanner;

public class Parser {
    /**
     * Reads in the user input and determines whether
     * it is a valid command. It then executes the
     * respective functions.
     */
    public static void parseAndExecute() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String keyCommand = sc.next();
            // Exit Command
            if (keyCommand.equalsIgnoreCase("bye")) {
                Storage.saveFileContents();
                Ui.printGoodbye();
                break;
            } else {
                if(keyCommand.equalsIgnoreCase("find")) {
                    String keyWord = sc.nextLine();
                    TaskList.findTask(keyWord);
                }
                else if(keyCommand.equalsIgnoreCase("list")) {
                    Ui.listTasks();
                }
                else if(keyCommand.equalsIgnoreCase("done")) {
                    String done = sc.nextLine();
                    TaskList.doneTask(done);
                }
                else if(keyCommand.equalsIgnoreCase("delete")) {
                    String delete = sc.nextLine();
                    TaskList.deleteTask(delete);
                }

                else if(keyCommand.equalsIgnoreCase("todo")) {
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
                }
                else if(keyCommand.equalsIgnoreCase("deadline")) {
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
                }
                else if(keyCommand.equalsIgnoreCase("event")) {
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
                } else {
                    sc.nextLine();
                    System.out.println(Messages.INVALID_INPUT);
                }
            }
        }
    }
}
