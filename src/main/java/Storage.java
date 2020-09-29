import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import task.*;

public class Storage {
    /**
     * Loads a task of To-do type from text file.
     * The argument description provides a description
     * of the to-do task which is being loaded
     * from the text file.
     *
     * @param description a string giving the details
     *                    of the to-do task which is being
     *                    loaded from the text file
     */
    public static void loadToDo(String description) {
        Task toAdd = new ToDo(description);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    /**
     * Loads a task of Event type from text file.
     * The argument event provides a description
     * of the event task, as well as the event
     * details that comes after the delimiter
     * '/at'.
     *
     * @param event a string giving the details
     *              of the event task which is being
     *              loaded from the text file
     */
    public static void loadEvent(String event) {
        String[] splitEvent = event.split("/at");
        Task toAdd = new Event(splitEvent[0],splitEvent[1]);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    /**
     * Loads a task of Deadline type from text file.
     * The argument desc provides a description
     * of the deadline task, as well as the deadline
     * details that comes after the delimiter
     * '/by'.
     *
     * @param desc a string giving the details of the
     *             deadline task which is being loaded
     *             from the text file
     */
    public static void loadDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        Task toAdd = new Deadline(splitDesc[0],splitDesc[1]);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    /**
     * Loads all the contents from text file on to Duke.
     * @throws FileNotFoundException
     */
    public static void loadFileContents() throws FileNotFoundException {
        File f = new File(Messages.FILEPATH);
        Scanner sc = new Scanner(f);
        if (!sc.hasNext()) {
            TaskList.inputCount = 0;
        } else {
            int inputCount = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < inputCount; i++) {
                String taskLine = sc.nextLine();
                // Split the task details into type, isDone, and description
                String[] taskDetails = taskLine.split(" > ");
                // Load each existing task in text file into the program
                switch (taskDetails[0]) {
                case "E":
                    loadEvent(taskDetails[2]);
                    TaskList.list.get(i).isDone = Boolean.parseBoolean(taskDetails[1]);
                    break;
                case "T":
                    loadToDo(taskDetails[2]);
                    TaskList.list.get(i).isDone = Boolean.parseBoolean(taskDetails[1]);
                    break;
                case "D":
                    loadDeadline(taskDetails[2]);
                    TaskList.list.get(i).isDone = Boolean.parseBoolean(taskDetails[1]);
                    break;

                }
            }
        }
    }

    /**
     * Formats the task to the format to save in text file.
     * Returns the formatted string to be saved in text file.
     * The argument t is the task that is being formatted
     * to save in text file.
     * @param t a Task that is being formatted to save in textfile
     * @return the string that describes the task details
     * in the text file.
     */
    public static String toSave(Task t) {
        return(t.getType() + " > " + t.isDone + " > " + t.toStringToSave());
    }

    /**
     * Saves all contents of the list in Duke to the text file.
     */
    public static void saveFileContents() {
        try {
            FileWriter fw = new FileWriter(Messages.FILEPATH);
            // Write inputCount to first line of file
            fw.write(Integer.toString(TaskList.inputCount));
            fw.write(System.lineSeparator());
            for(int i = 0; i < TaskList.inputCount; i++) {
                fw.write(toSave(TaskList.list.get(i)));
                fw.write(System.lineSeparator());
            }
            fw.close();
            System.out.println(Messages.SAVE_SUCCESS_MESSAGE);
        } catch (IOException e) {
            System.out.println(Messages.SAVE_FAILED_MESSAGE);
        }
    }
}
