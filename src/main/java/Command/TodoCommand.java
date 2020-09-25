package Command;

import Storage.Storage;
import Task.Task;
import Task.Todo;
import Ui.Ui;

import java.util.ArrayList;

public class TodoCommand extends AddCommand{
    public TodoCommand(String taskName) {
        super(taskName);
    }
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Todo(taskName));
        super.execute(tasks, ui, storage); //prints status after adding tasks
    }
}
