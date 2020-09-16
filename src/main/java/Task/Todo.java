package Task;

import Task.Task;

public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    public String toRawData() {
        return "T | " + super.toRawData();
    }

    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns completion status and task name
        return "[T]" + super.toString();
    }
}
