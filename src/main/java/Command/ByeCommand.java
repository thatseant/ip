package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class ByeCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        this.isExit = true;
        ui.exitMessage();
    }
 }
