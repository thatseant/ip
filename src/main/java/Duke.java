import java.util.ArrayList;

import Command.Command;
import Storage.Storage;
import Parser.Parser;
import Task.Task;
import Ui.Ui;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    public static final String STORAGE_FILE_LOCATION = "tasks.txt";

    static Storage storage;
    static ArrayList<Task> tasks = new ArrayList<>();
    static Ui ui;
    static boolean isExit = false;

    /**
     * Main constructor of Duke. Initializes storage, Ui and tasks list instances.
     * @Param filePath path of file where program data is saved and loaded from.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.readFile();
    }

    /** Runs the program until termination.*/
    public void run() {
        ui.showWelcome();
        while (!isExit) {
            //Processes user commands
            String userInput = ui.readCommand();
            ui.printHorizontalLine();
            Command c = Parser.parse(userInput, storage);
            c.execute(tasks, ui, storage);
            ui.printHorizontalLine();
            isExit = c.isExit();
        }
    }

    /**
     * Runs instance of Duke.
     * @Param args command line arguments
     */
    public static void main(String[] args) {
        new Duke(STORAGE_FILE_LOCATION).run();
    }
}
