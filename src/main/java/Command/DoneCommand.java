package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Command to mark task as done.
 */
public class DoneCommand extends Command {
    int taskNumber;

    /**
     * Constructor.
     * @param taskNumber index of task on list
     */
    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Sets task's status to done. Prints status of task and saves updated list to file.
     * @param tasks
     * @param ui
     * @param storage
     */
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
