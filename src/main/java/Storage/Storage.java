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
            String[] taskParameters = s.nextLine().split(" \\| ");
            String taskType = taskParameters[0];
            Boolean isDone = Boolean.parseBoolean(taskParameters[1].trim());
            String taskName = taskParameters[2];

            switch (taskType) {
            case "T":
                tasks.add(new Todo(taskName));
                break;
            case "D":
                String date = taskParameters[3];
                tasks.add(new Deadline(taskName, date));
                break;
            case "E":
                date = taskParameters[3];
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
