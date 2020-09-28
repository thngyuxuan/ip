import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Task.*;

public class Storage {
    // Load to-do from text file
    public static void loadToDo(String description) {
        Task toAdd = new ToDo(description);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    // Load event from text file
    public static void loadEvent(String event) {
        String[] splitEvent = event.split("/at");
        Task toAdd = new Event(splitEvent[0],splitEvent[1]);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    // Load deadline from text file
    public static void loadDeadline(String desc) {
        String[] splitDesc = desc.split("/by");
        Task toAdd = new Deadline(splitDesc[0],splitDesc[1]);
        TaskList.list.add(toAdd);
        TaskList.inputCount++;
    }

    // Load text file contents into program
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

    // Format task details to save in text file
    public static String toSave(Task t) {
        return(t.getType() + " > " + t.isDone + " > " + t.toStringToSave());
    }
    // Save contents in program into text file
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
