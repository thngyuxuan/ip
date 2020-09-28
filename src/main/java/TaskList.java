import Task.*;
import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> list = new ArrayList<>();
    public static int inputCount = 0;

    // Add event from user input
    public static void addEvent(String event) {
        String[] splitEvent = event.split("/at");
        Task toAdd = new Event(splitEvent[0],splitEvent[1]);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    // Add todo task from user input
    public static void addToDo(String description) {
        Task toAdd = new ToDo(description);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    // Add deadline from user input
    public static void addDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        Task toAdd = new Deadline(splitDesc[0], splitDesc[1]);
        list.add(toAdd);
        Ui.addTaskMessages();
        inputCount++;
    }

    // Label task as done
    public static void doneTask(String task) throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            int doneTask = Integer.parseInt(task.replaceAll("[\\D]",""));
            list.get(doneTask - 1).markAsDone();
            System.out.println(Messages.BORDER);
            System.out.println(Messages.MARK_AS_DONE_MESSAGE);
            System.out.println(Messages.INDENTATION + list.get(doneTask - 1).toString());
            System.out.println(Messages.BORDER);
        } catch (NumberFormatException e) {
            System.out.println(Messages.INVALID_DONE_INPUT);
        } catch (NullPointerException e) {
            System.out.println(Messages.EMPTY_DONE_INPUT);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Messages.INVALID_DONE_INPUT_OUT_OF_BOUNDS);
        }
    }

    // Delete the selected task
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
            System.out.println(Messages.INVALID_DELETE_INPUT_FORMAT);
        } catch (NullPointerException e) {
            System.out.println(Messages.EMPTY_DELETE_INPUT);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Messages.INVALID_DELETE_INPUT_OUT_OF_BOUNDS);
        }
    }
}
