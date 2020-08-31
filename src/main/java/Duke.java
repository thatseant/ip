import java.util.Scanner;
public class Duke {

    static Scanner in = new Scanner(System.in);
    static Task[] tasks = new Task[100];

    //Prints tasks with completion status
    public static void displayList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i< Task.getNumberOfTasks(); i++) {
            System.out.print(i+1 + ".");
            System.out.println(tasks[i].toString());
        }
    }

    public static void markAsDone(int taskNumber) {
        tasks[taskNumber].setDone();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("[✓] " + tasks[taskNumber].getName());
    }

    //Adds task at end of other tasks
    public static void addTask(String userInput) {
        tasks[Task.getNumberOfTasks()] = new Task(userInput);
        System.out.format("added: %s%n", userInput);
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

        //Processes user commands
        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) {
                displayList();
            } else if (userInput.contains("done")) {
                int taskNumber = Integer.parseInt(userInput.replaceAll("\\D+","")) - 1;
                markAsDone(taskNumber);
            } else {
                addTask(userInput);
            }
                userInput = in.nextLine();
        }

        //Prints exit message when user says bye
        System.out.println("Bye. Hope to see you again soon!");
    }
}
