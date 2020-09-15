package Task;

//User inputs represented as Tasks
public class Task {
    private boolean isDone;
    private String name;
    private static int numberOfTasks;

    public Task(String name) {
        isDone = false;
        this.name = name;
        numberOfTasks++;
    }

    public String getName() {
        return name;
    }

    public void setDone() {
        isDone = true;
    }

    public static int decrementNumberOfTasks() {
       return --numberOfTasks;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    //Returns string with task name and completion status
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
