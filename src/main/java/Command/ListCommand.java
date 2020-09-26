package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Displays lists of all tasks.
 */
public class ListCommand extends Command {

    /**
     * Prints list of tasks with index and completion status.
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < Task.getNumberOfTasks(); i++) {
            System.out.print(i + 1 + ".");
            System.out.println(tasks.get(i).toString());
        }
    }
}
