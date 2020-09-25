package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    //Prints tasks with completion status
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < Task.getNumberOfTasks(); i++) {
            System.out.print(i + 1 + ".");
            System.out.println(tasks.get(i).toString());
        }
    }
}
