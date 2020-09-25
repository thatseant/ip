package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private LocalDate deadline;
    private String deadlineString;

    public Deadline(String name, String deadline) {
        super(name);
        this.deadline = LocalDate.parse(deadline);
        deadlineString = deadline;
    }

    public String toRawData() {
        return "D | " + super.toRawData() + " | " + deadlineString;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    //Adds task type indicator to super.toString which returns completion status and task name, followed by deadline.
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
    }
}
