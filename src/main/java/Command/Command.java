package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class Command {
    protected boolean isExit = false;

    public boolean isExit() {
        return this.isExit;
    }
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {}
}
