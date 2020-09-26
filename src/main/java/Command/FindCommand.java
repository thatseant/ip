package Command;

import Storage.Storage;
import Task.Task;
import Ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ArrayList<Task> matchingList = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().contains(keyword)) {
                matchingList.add(task);
            }
        }

        if (matchingList.size() != 0) {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingList.size(); i++) {
                int taskNumber = i+1;
                System.out.format("%d. %s%n", taskNumber, matchingList.get(i).toString());
            }
        } else {
            System.out.println("No task with specified keyword.");
        }
    }
}
