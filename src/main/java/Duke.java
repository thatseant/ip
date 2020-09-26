import Command.Command;
import Storage.Storage;
import Parser.Parser;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
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
            Command c = Parser.parse(userInput, storage);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
    }

    /**
     * Runs instance of Duke.
     * @Param args command line arguments
     */
    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }
}
