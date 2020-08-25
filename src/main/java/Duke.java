import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        //Prints welcome message on start
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        //Adds user inputs to storedUserInputs Array
        Scanner in = new Scanner(System.in);
        String[] storedUserInputs = new String[100];
        int listLength = 0;
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) { //Displays previous user inputs
                for (int i = 0; i< listLength; i++) {
                    System.out.format("%d: %s%n", i, storedUserInputs[i]);
                }
            } else {
                System.out.format("added: %s%n", userInput);
                storedUserInputs[listLength] = userInput;
                listLength++;
            }
                userInput = in.nextLine();
        }

        //Exits message when user says bye
        System.out.println("Bye. Hope to see you again soon!");
    }
}
