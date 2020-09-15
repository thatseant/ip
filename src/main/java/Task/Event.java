package Task;

public class Event extends Task {

    private String time;

    public Event(String name, String time) {
        super(name);
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public String toRawData() {
        return "E | " + super.toRawData() + " | " + time;
    }

    //Adds task type indicator to super.toString which returns completion status and task name, followed by event time.
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), time);
    }
}
