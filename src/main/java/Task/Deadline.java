package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    private Boolean hasProperDeadline;
    private LocalDate deadline;
    private String deadlineString;

    /**
     * Constructor for Deadline object.
     * @param name name of deadline task
     * @param deadline deadline (for date recognition: enter in yyyy-mm-dd)
     */
    public Deadline(String name, String deadline) {
        super(name);
        deadlineString = deadline;
        //Regex adapted from https://stackoverflow.com/a/22061879
        if (deadline.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
            this.deadline = LocalDate.parse(deadline);
            hasProperDeadline = true;
        } else {
            hasProperDeadline = false;
        }
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
        String deadlineToPrint;
        if (hasProperDeadline) {
            deadlineToPrint = deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        } else {
            deadlineToPrint = deadlineString;
        }
        return String.format("[D]%s (by: %s)", super.toString(), deadlineToPrint);
    }
}
