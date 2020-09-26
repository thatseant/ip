package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

/**
 * Parent class of all commands.
 */
public class Command {
    protected boolean isExit = false;

    /**
     * @return true if command is exitCommand
     */
    public boolean isExit() {
        return this.isExit;
    }
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {}
}
