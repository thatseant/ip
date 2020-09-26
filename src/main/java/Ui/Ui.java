package Ui;

import java.util.Scanner;

public class Ui {

    private static Scanner in = new Scanner(System.in);

    /**
     * Prints welcome start message
     */
    public void showWelcome() {
        String logo = "____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        //Prints welcome message on start
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * @return String with user input
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Prints exit message when user says bye
     */
    public void exitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
