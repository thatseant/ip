package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class AddCommand extends Command {
    protected static String taskName;
    public AddCommand(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        System.out.format("Got it. I've added this task: %n");
        System.out.format("%s%n", tasks.get(Task.getNumberOfTasks() - 1).toString());
        System.out.format("Now you have %d tasks on the list.%n", Task.getNumberOfTasks());
    }
}
