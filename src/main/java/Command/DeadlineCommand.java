package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;
import Task.Deadline;

import java.util.ArrayList;

/**
 * Adds new Deadline to Tasks list.
 */
public class DeadlineCommand extends AddCommand {
    private static String deadline;

    /**
     * Constructor.
     * @param taskName
     * @param date deadline
     */
    public DeadlineCommand(String taskName, String date) {
        super(taskName);
        deadline = date;
    }

    /**
     * Adds new Deadline to Tasks list.
     * @param tasks list of tasks
     * @param ui program Ui instance
     * @param storage program Storage instance
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Deadline(taskName, deadline));
        super.execute(tasks, ui, storage);
    }
}
