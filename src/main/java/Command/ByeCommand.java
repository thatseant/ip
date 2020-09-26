package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Command to terminate program.
 */
public class ByeCommand extends Command {

    /**
     * Sets program exit flag and print exit message.
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        this.isExit = true;
        ui.exitMessage();
    }
 }
