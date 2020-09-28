package Task;

public class Todo extends Task {

    public static final String TODO_TYPE_PRINT_INDICATOR = "[T]";
    public static final String TODO_TYPE_STORAGE_INDICATOR = "T | ";

    /**
     * Constructor for Todo object.
     * @param name name of Todo.
     */
    public Todo(String name) {
        super(name);
    }

    /**
     * @return single raw string with all data of Todo object
     */
    public String toRawData() {
        return TODO_TYPE_STORAGE_INDICATOR + super.toRawData();
    }

    /**
     * @return formatted string with task type indicator, done status and name for printing.
     * */
    @Override
    public String toString() {
        //Adds task type indicator to super.toString which returns completion status and task name
        return TODO_TYPE_PRINT_INDICATOR + super.toString();
    }
}
