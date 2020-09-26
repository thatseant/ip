package Task;

public class Event extends Task {

    private String time;

    /**
     * Constructor for Event object.
     * @param name name of deadline task
     * @param time time of event
     */
    public Event(String name, String time) {
        super(name);
        this.time = time;
    }

    /**
     * @return event time
     * */
    public String getTime() {
        return this.time;
    }

    /**
     * @return single raw string with all data of Event object
     */
    public String toRawData() {
        return "E | " + super.toRawData() + " | " + time;
    }

    /**
     * @return formatted string with task type indicator, done status, name and event time for printing.
     * */
    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns completion status and task name, followed by event time.
        return String.format("[E]%s (at: %s)", super.toString(), time);
    }
}
