package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import commands.AddCommand;
import commands.Command;
import commands.DeleteCommand;
import commands.HelpCommand;
import commands.ListCommand;
import storage.Memory;

/**
 * @author Melvin Campos Casares
 */
public class Main {
	private static Map<String, Command> commands = new HashMap<>();
	public static List<Task> tasks = new ArrayList<>();
	public static Memory memory = new Memory();

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				memory.load();
			}
		};

		new Thread(runnable).start();
		System.out.println("Hi!\nWelcome to TaskList.");
		System.out.println(">>> Here are the commands: add - list - delete - exit\n");
		System.out.println("If you need any explanation for available commands, type `help`");

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		fillCommands();
		while (!exit) { // !exit -> exit == false
			System.out.print("Enter a command> ");

			if (scanner.hasNextLine()) {
				String inputCommand = scanner.nextLine();

				if (inputCommand.equals("exit")) {
					exit = true;
					System.out.println("Goodbye!");
				} else {
					Command command = getCommand(inputCommand);
					if (command == null) {
						System.out.println("Sorry, wrong command... Please try again ;-)\n");
						continue;
					}
					command.execute();
				}

			}
		}

		scanner.close(); // otherwise, memory leak
	}

	/**
	 * Method used to check which command has been entered by the user. If the
	 * command is valid, the corresponding class is called and used.
	 * 
	 * @param inputCommand command entered by the user
	 * @return if valid, run the corresponding class. If not valid, returns nothing.
	 */
	private static Command getCommand(String inputCommand) {
		return commands.get(inputCommand);
	}

	/**
	 * Method used to list all available commands
	 */
	private static void fillCommands() {
		var addCmd = new AddCommand();
		var lsCmd = new ListCommand();
		var rmCmd = new DeleteCommand();
		var helpCmd = new HelpCommand();
		commands.put(addCmd.description(), addCmd);
		commands.put(lsCmd.description(), lsCmd);
		commands.put(rmCmd.description(), rmCmd);
		commands.put(helpCmd.description(), helpCmd);
	}
}
