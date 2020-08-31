public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns completion status and task name
        return "[T]" + super.toString();
    }
}
