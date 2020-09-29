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
            Ui.printInvalidInput("delete");
        } catch (NullPointerException e) {
            Ui.printEmptyInput("delete");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printInvalidInput("deleteOOB");
        }
    }

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
