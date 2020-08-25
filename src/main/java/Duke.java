import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        //Welcome Message
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        //Echoes commands
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            System.out.println(userInput);
            userInput = in.nextLine();
        }

        //Exits message when user says bye
        System.out.println("Bye. Hope to see you again soon!");
    }
}
