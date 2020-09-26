package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private LocalDate deadline;
    private String deadlineString;

    /**
     * Constructor for Deadline object.
     * @param name name of deadline task
     * @param deadline deadline of deadline task
     */
    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = LocalDate.parse(deadline);
        deadlineString = deadline;
    }

    /**
     * @return single raw string with all data of Deadline object
     */
    public String toRawData() {
        return "D | " + super.toRawData() + " | " + deadlineString;
    }

    /**
     * @return deadline
     * */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * @return formatted string with task type indicator, done status, name and deadline for printing.
     * */
    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns done status and task name, followed by deadline.
return String.format("[D]%s (by: %s)", super.toString(), deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
    }
}
