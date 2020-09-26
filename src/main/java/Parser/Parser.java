package Parser;

import Command.Command;
import Command.ListCommand;
import Command.DoneCommand;
import Command.DeleteCommand;
import Command.ByeCommand;
import Command.TodoCommand;
import Command.EventCommand;
import Command.DeadlineCommand;
import Exception.InvalidCommandException;

import Storage.Storage;

public class Parser {

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
                case "bye":
                    return new ByeCommand();
                case "list":
                    command = new ListCommand();
                    break;
                case "done":
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
                case "delete":
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
                case "todo":
                case "deadline": //fallthrough
                case "event": //fallthrough
                    String taskType = "", taskName = "";
                    try {
                        taskType = userInput.split(" ")[0];
                        taskName = userInput.split(" ", 2)[1].split(" /")[0];
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("OOPS!!! The description of " + taskType + " cannot be empty.");
                    }

                    switch (taskType) {
                    case "todo":
                        command = new TodoCommand(taskName);
                    case "deadline":
                        try {
                            String deadline = userInput.split("/by ")[1];
                            command = new DeadlineCommand(taskName, deadline);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Missing deadline or deadline not specified in correct format.");
                        }
                        break;
                    case "event":
                        try {
                            String time = userInput.split("/at ")[1];
                            command = new EventCommand(taskName, time);
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Missing event time or time not specified in correct format.");
                        }
                    }
                    break;
                default:
                    throw new InvalidCommandException();
                }
                storage.saveToFile();
                return command;
            } catch (InvalidCommandException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                return new Command();
            }
    }

}
