//User inputs represented as Tasks
public class Task {
    private boolean isDone;
    private String name;

    public Task(String name) {
        isDone = false;
        this.name = name;
    }

    public boolean getDone() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    public void setDone() {
        isDone = true;
    }
}
