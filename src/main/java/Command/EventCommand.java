package Command;

import Storage.Storage;
import Task.Task;
import Task.Event;
import Ui.Ui;

import java.util.ArrayList;

public class EventCommand extends AddCommand {
    private static String eventTime;

    public EventCommand(String taskName, String time) {
        super(taskName);
        eventTime = time;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Event(taskName, eventTime));
        super.execute(tasks, ui, storage);
    }
}
