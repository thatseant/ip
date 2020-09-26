package Command;

import Storage.Storage;
import Task.Task;
import Task.Event;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Adds new Event to list.
 * Child class of AddCommand.
 */
public class EventCommand extends AddCommand {
    private static String eventTime;

    /**
     * Constructor
     * @param taskName
     * @param time event time
     */
    public EventCommand(String taskName, String time) {
        super(taskName);
        eventTime = time;
    }

    /**
     * Adds new Event to tasks list.
     * @param tasks list of tasks
     * @param ui program Ui instance
     * @param storage program Storage instance
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Event(taskName, eventTime));
        super.execute(tasks, ui, storage);
    }
}
