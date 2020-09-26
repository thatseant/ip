package Command;

import Storage.Storage;
import Task.Task;
import Task.Todo;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Adds new Todo to list.
 */
public class TodoCommand extends AddCommand{

    /**
     * Constructor
     * @param taskName
     */
    public TodoCommand(String taskName) {
        super(taskName);
    }

    /**
     * Adds new Todo to tasks list.
     * @param tasks list of tasks
     * @param ui program Ui instance
     * @param storage program Storage instance
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Todo(taskName));
        super.execute(tasks, ui, storage); //prints status after adding tasks
    }
}
