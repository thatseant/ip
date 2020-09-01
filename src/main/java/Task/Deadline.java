package Task;

public class Deadline extends Task {

    private String deadline;

    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    //Adds task type indicator to super.toString which returns completion status and task name, followed by deadline.
    @Override
    public String toString() {
        return String.format("[D]%s(by: %s)", super.toString(), deadline);
    }
}
