package Parser;

import Command.Command;
import Command.ListCommand;
import Command.DoneCommand;
import Command.DeleteCommand;
import Command.ByeCommand;
import Command.TodoCommand;
import Command.EventCommand;
import Command.DeadlineCommand;
import Command.FindCommand;

import Exception.InvalidCommandException;

import Storage.Storage;

public class Parser {
    public static final String BYE_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String FIND_COMMAND = "find";
    public static final String DONE_COMMAND = "done";
    public static final String DELETE_COMMAND = "delete";
    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";


    /**
     * Parses user inputs for commands to execute and extracts additional arguments from input to send to commands.
     * @param userInput raw input by user from command line
     * @param storage same Storage instance used throughout entire program that stores the existing Tasks arraylist.
     * @return Command to be executed
     */
    public static Command parse(String userInput, Storage storage) {
            try {
                Command command = new Command();
                String commandType = userInput.split(" ")[0];

                switch (commandType) {
                case BYE_COMMAND:
                    return new ByeCommand();
                case LIST_COMMAND:
                    command = new ListCommand();
                    break;
                case FIND_COMMAND:
                    try {
                        String keyword = userInput.split(" ", 2)[1];
                        command = new FindCommand(keyword);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please enter a valid search keyword.");
                    }
                    break;
                case DONE_COMMAND:
                    try {
                        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                        command = new DoneCommand(taskNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Please specify the task you would like to mark as done in integer format.");
                    } catch (NullPointerException e) {
                        System.out.println("Task not found. Please reenter command with valid task number.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Task not found. Please reenter command with valid task number.");
                    }
                    break;
                case DELETE_COMMAND:
                    try {
                        int taskNumber = Integer.parseInt(userInput.split(" ")[1]);
                        command = new DeleteCommand(taskNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Please specify the task you would like to mark as done in integer format.");
                    } catch (NullPointerException e) {
                        System.out.println("Task not found. Please reenter command with valid task number.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Task not found. Please reenter command with valid task number.");
                    }
                    break;
                case TODO_COMMAND:
                case DEADLINE_COMMAND: //fallthrough
                case EVENT_COMMAND: //fallthrough
                    String taskType = "", taskName = "";
                    try {
                        taskType = userInput.split(" ")[0];
                        taskName = userInput.split(" ", 2)[1].split(" /")[0];
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("OOPS!!! The description of " + taskType + " cannot be empty.");
                    }

                    switch (taskType) {
                    case TODO_COMMAND:
                        command = new TodoCommand(taskName);
                        break;
                    case DEADLINE_COMMAND:
                        try {
                            String deadline = userInput.split("/by ")[1];
                            command = new DeadlineCommand(taskName, deadline);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Missing deadline or deadline not specified in correct format.");
                        }
                        break;
                    case EVENT_COMMAND:
                        try {
                            String time = userInput.split("/at ")[1];
                            command = new EventCommand(taskName, time);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Missing event time or time not specified in correct format.");
                        }
                    }
                    break;
                default:
                    throw new InvalidCommandException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                storage.saveToFile();
                return command;
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
                return new Command();
            }
    }

}
