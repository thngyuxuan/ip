import java.io.FileNotFoundException;

public class Duke {
    public static void main(String[] args) {
        // Load file
        try {
            Storage.loadFileContents();
        } catch (FileNotFoundException e) {
            Ui.printMissingFile();
        }
        Ui.printGreeting();
        Parser.parseAndExecute();
    }
}