/**
 * Class to hold the list of Tasks in the Duke program.
 */

import task.*;
import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> list = new ArrayList<>();
    public static int inputCount = 0;

    /**
     * Adds a new Event task to the list of stored tasks.
     * The event argument must be a string, and contains
     * the delimiter '/at'.
     * @param event
     */
    // Add event from user input
    public static void addEvent(String event) {
        String[] splitEvent = event.split("/at");
        Task toAdd = new Event(splitEvent[0],splitEvent[1]);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    /**
     * Adds a new ToDo task to the list of stored tasks.
     * The description argument must be a string, and can be
     * of any length, as long as it is not empty.
     * @param description a description of the todo task
     */
    public static void addToDo(String description) {
        Task toAdd = new ToDo(description);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    /**
     * Adds a new Deadline task to the list of stored tasks.
     * The desc argument must be a string, and contains the
     * delimiter '/by'. desc must contain the description of
     * the task as well as the deadline, which must be specified
     * right after the delimiter '/by'.
     *
     * @param desc contains the description of the deadline task
     *             as well as the deadline of the task, which comes right
     *             after the delimiter '/by'
     */
    public static void addDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        Task toAdd = new Deadline(splitDesc[0], splitDesc[1]);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    /**
     * Marks the selected task as done. The task argument must be a String so that
     * Duke can parse the correct Integer, which tells Duke which task in the list
     * is being marked as done.
     * @param task
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void doneTask(String task) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int doneTask = Integer.parseInt(task.replaceAll("[\\D]",""));
            Task markedDone = list.get(doneTask - 1);
            markedDone.markAsDone();
            Ui.markDoneMessages(markedDone.toString());
        } catch (NumberFormatException e) {
            Ui.printInvalidInput("done");
        } catch (NullPointerException e) {
            Ui.printEmptyInput("done");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printInvalidInput("doneOOB");
        }
    }

    /**
     * Deletes the selected task from the stored list of tasks.
     * The argument indexToDelete must be a string that can be
     * parsed into an integer.
     * @param indexToDelete a string that can be parsed into
     *                      an integer, giving the index of
     *                      the task in the list that is
     *                      going to be deleted.
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void deleteTask(String indexToDelete) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int toDelete = Integer.parseInt(indexToDelete.replaceAll("[\\D]", ""));
            toDelete--;
            Task toRemove = list.get(toDelete);
            String toPrint = toRemove.toString();
            inputCount--;
            Ui.deleteTaskMessages(toPrint);
            list.remove(toRemove);
        } catch (NumberFormatException e) {
            Ui.printInvalidInput("delete");
        } catch (NullPointerException e) {
            Ui.printEmptyInput("delete");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printInvalidInput("deleteOOB");
        }
    }

    /**
     * Finds all tasks in the stored list of task that contain
     * the keyword(s).
     * The argument toFind must be a String, and can be of any
     * length.
     * @param toFind a string that contains the word(s) the
     *               user wishes to find in the list of
     *               stored tasks
     */
    public static void findTask(String toFind) {
        ArrayList<Task> searchList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getDescription().contains(toFind)) {
                searchList.add(list.get(i));
            }
        }
        if(searchList.size() == 0) {
            Ui.printEmptySearchList();
        }
        else if(toFind.equals("")) {
            Ui.printEmptyInput("find");
        } else {
            Ui.findTaskMessages();
            for (int j = 0; j < searchList.size(); j++) {
                System.out.println((j + 1) + "." + searchList.get(j).toString());
            }
            System.out.println(Messages.BORDER);
        }
    }
}
