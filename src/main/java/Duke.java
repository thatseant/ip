import Task.Task;
import Task.Todo;
import Task.Deadline;
import Task.Event;
import Exception.InvalidCommandException;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Duke {

    static String filePath = "tasks.txt";
    static Scanner in = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    public static void saveToFile() {
        String fullTextToAdd = "";
        try {
            for (Task task: tasks) {
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

    public static void loadFromFile() throws FileNotFoundException {
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
                    tasks.get(Task.getNumberOfTasks()-1).setDone();
                }
        }
    }

    public static void readFile() {
        try {
            loadFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    //Prints tasks with completion status
    public static void displayList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i< Task.getNumberOfTasks(); i++) {
            System.out.print(i+1 + ".");
            System.out.println(tasks.get(i).toString());
        }
    }

    public static void markAsDone(String userInput) {
        try {
            int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
            tasks.get(taskNumber - 1).setDone();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(tasks.get(taskNumber - 1).toString());
        } catch (NumberFormatException e) {
            System.out.println("Please specify the task you would like to mark as done in integer format.");
        } catch (NullPointerException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        }
    }

    public static void deleteTask(String userInput) {
        try {
            int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
            Task deletedTask = tasks.get(taskNumber - 1);
            tasks.remove(taskNumber - 1);
            System.out.println("Noted. I've removed this task:");
            System.out.println(deletedTask.toString());
            System.out.println("Now you have " + Task.decrementNumberOfTasks() + " tasks in the list.");
        } catch (NumberFormatException e) {
            System.out.println("Please specify the task you would like to mark as done in integer format.");
        } catch (NullPointerException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Task not found. Please reenter command with valid task number.");
        }
    }

    //Adds task at end of other tasks
    public static void addTask(String userInput) {

        String taskType = "", taskName = "";
        try {
            taskType = userInput.split(" ")[0];
            taskName = userInput.split(" ", 2)[1].split(" /")[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The description of " + taskType + " cannot be empty.");
            return;
        }

        switch (taskType) {
        case "todo":
            tasks.add(new Todo(taskName));
            break;
        case "deadline":
            try {
                String deadline = userInput.split("/by ")[1];
                tasks.add(new Deadline(taskName, deadline));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Missing deadline or deadline not specified in correct format.");
                return;
            }
            break;
        case "event":
            try {
                String time = userInput.split("/at ")[1];
                tasks.add(new Event(taskName, time));
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Missing event time or time not specified in correct format.");
                return;
            }
        }
        System.out.format("Got it. I've added this task: %n");
        System.out.format("%s%n", tasks.get(Task.getNumberOfTasks() - 1).toString());
        System.out.format("Now you have %d tasks on the list.%n", Task.getNumberOfTasks());
    }

    public static void main(String[] args) {
        String logo = "____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        //Prints welcome message on start
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        //Load previous data from file
        readFile();

        //Processes user commands
        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {
            try {
                String commandType = userInput.split(" ")[0];
                switch (commandType) {
                case "list":
                    displayList();
                    break;
                case "done":
                    markAsDone(userInput);
                    break;
                case "delete":
                    deleteTask(userInput);
                    break;
                case "todo":
                case "deadline": //fallthrough
                case "event": //fallthrough
                    addTask(userInput);
                    break;
                default:
                    throw new InvalidCommandException();
                }
                saveToFile();
            } catch (InvalidCommandException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            userInput = in.nextLine();
        }

        //Prints exit message when user says bye
        System.out.println("Bye. Hope to see you again soon!");
    }
}
