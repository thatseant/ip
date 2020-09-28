package Storage;

import Task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Task.Deadline;
import Task.Event;
import Task.Todo;

public class Storage {
    private String filePath;
    static ArrayList<Task> tasks = new ArrayList<>();
    public static final String TODO = "T";
    public static final String DEADLINE = "D";
    public static final String EVENT = "E";
    public static final String PARAM_DIVIDER_REGEX = " \\| ";
    public static final int TASK_TYPE_INDEX = 0;
    public static final int TASK_STATUS_INDEX = 1;
    public static final int TASK_NAME_INDEX = 2;
    public static final int TASK_DATE_INDEX = 3;


    /**
     * Storage constructor.
     * @param filePath path of file to save and load tasks from.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    /**
     * Saves all tasks to data file.
     */
    public void saveToFile() {
        String fullTextToAdd = "";
        try {
            for (Task task : tasks) {
                if (task != null) {
                    fullTextToAdd += task.toRawData();
                    fullTextToAdd += System.lineSeparator();
                }
            }
            writeToFile(filePath, fullTextToAdd);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private ArrayList<Task> loadFromFile() throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] taskParameters = s.nextLine().split(PARAM_DIVIDER_REGEX);
            String taskType = taskParameters[TASK_TYPE_INDEX];
            Boolean isDone = Boolean.parseBoolean(taskParameters[TASK_STATUS_INDEX].trim());
            String taskName = taskParameters[TASK_NAME_INDEX];

            switch (taskType) {
            case TODO:
                tasks.add(new Todo(taskName));
                break;
            case DEADLINE:
                String date = taskParameters[TASK_DATE_INDEX];
                tasks.add(new Deadline(taskName, date));
                break;
            case EVENT:
                date = taskParameters[TASK_DATE_INDEX];
                tasks.add(new Event(taskName, date));
                break;
            default:
                break;
            }
            if (isDone) {
                tasks.get(Task.getNumberOfTasks() - 1).setDone();
            }
        }
        return tasks;
    }

    /**
     * Processes tasks stored as raw data from data file into Task objects and returns arraylist of these Task objects.
     * @return ArrayList of Task objects from data file.
     */
    public ArrayList<Task> readFile() {
        try {
            return loadFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. No previous tasks loaded.");
            return tasks;
        }
    }
}
