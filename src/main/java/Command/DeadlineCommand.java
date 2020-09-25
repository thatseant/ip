package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;
import Task.Deadline;

import java.util.ArrayList;

public class DeadlineCommand extends AddCommand {
    private static String deadline;

    public DeadlineCommand(String taskName, String date) {
        super(taskName);
        deadline = date;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Deadline(taskName, deadline));
        super.execute(tasks, ui, storage);
    }
}
