package Task;

/**
 * Parent class of all Task objects i.e. Deadline, Event, Todo.
 */
public class Task {
    private boolean isDone;
    private String name;
    private static int numberOfTasks;

    /**
     * Constructor
     * Increments total number of tasks in static variable.
     * @param name
     */
    public Task(String name) {
        isDone = false;
        this.name = name;
        numberOfTasks++;
    }

    /**
     * @return name of task
     */
    public String getName() {
        return name;
    }

    /**
     * Marks task as completed.
     */
    public void setDone() {
        isDone = true;
    }

    /**
     * Decrements total number of tasks.
     * @return number of tasks after decrement.
     */
    public static int decrementNumberOfTasks() {
       return --numberOfTasks;
    }

    /**
     * @return total number of tasks
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * @return raw string with task completion status and name.
     */
    public String toRawData() {
        return String.format("%s | %s", isDone, name);
    }

    /**
     * @return formatted string with task completion status and name for printing.
     */
    @Override
    public String toString() {
        String tickOrCrossChar;
        if (isDone) {
            tickOrCrossChar = "\u2713";
        } else {
            tickOrCrossChar = "\u2718";
        }

        return String.format("[%s] %s", tickOrCrossChar, name);
    }

}
