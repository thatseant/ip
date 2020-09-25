import Command.Command;
import Storage.Storage;
import Parser.Parser;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class Duke {
    static Storage storage;
    static ArrayList<Task> tasks = new ArrayList<>();
    static Ui ui;
    static boolean isExit = false;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.readFile();
    }

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


    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }
}
