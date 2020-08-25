import java.util.Scanner;
public class Duke {
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

        //Implement commands
        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int listLength = 0;
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) { //Displays previous user inputs
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i< listLength; i++) {
                    System.out.print(i+1 + ". " + "[");
                    if (tasks[i].getDone()) { //Displays status of individual tasks
                        System.out.print("✓");
                    } else {
                        System.out.print("✗");
                    }
                    System.out.print("] " + tasks[i].getName());
                    System.out.println();
                }
            } else if (userInput.contains("done")) {//Marks task as done
                int taskNumber = Integer.parseInt(userInput.replaceAll("\\D+","")) - 1;
                tasks[taskNumber].setDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("[✓] " + tasks[taskNumber].getName());
            } else {//Adds user inputs to storedUserInputs Array
                System.out.format("added: %s%n", userInput);
                tasks[listLength] = new Task(userInput);
                listLength++;
            }
                userInput = in.nextLine();
        }

        //Prints exit message when user says bye
        System.out.println("Bye. Hope to see you again soon!");
    }
}
