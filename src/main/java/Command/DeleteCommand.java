package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Command to delete task.
 */
public class DeleteCommand extends Command {
    private static int taskNumber;

    /**
     * Constructor.
     * @param taskNumber index of to-be-deleted task in list.
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Removes task from list, prints number of tasks left and saves updated list to file.
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        try {
            Task deletedTask = tasks.get(taskNumber - 1);
            tasks.remove(taskNumber - 1);
            System.out.println("Noted. I've removed this task:");
            System.out.println(deletedTask.toString());
            System.out.println("Now you have " + Task.decrementNumberOfTasks() + " tasks in the list.");
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
