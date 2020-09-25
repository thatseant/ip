package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class DoneCommand extends Command {
    private int taskNumber;
    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        try {
            tasks.get(taskNumber - 1).setDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(tasks.get(taskNumber - 1).toString());
            storage.saveToFile();
        } catch (NumberFormatException e) {
            System.out.println("Please specify the task you would like to mark as done in integer format.");
        } catch (NullPointerException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        }
    }
}
