package Task;

public class Deadline extends Task {

    private String deadline;

    /**
     * Constructor for Deadline object.
     * @param name name of deadline task
     * @param deadline deadline of deadline task
     */
    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    /**
     * @return single raw string with all data of Deadline object
     */
    public String toRawData() {
        return "D | " + super.toRawData() + " | " + deadline;
    }

    /**
     * @return deadline
     * */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @return formatted string with task type indicator, done status, name and deadline for printing.
     * */
    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns done status and task name, followed by deadline.
        return String.format("[D]%s (by: %s)", super.toString(), deadline);
    }
}
