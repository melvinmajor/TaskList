package commands;

/**
 * Command which lists a description of all available commands
 * 
 * @author Melvin Campos Casares
 *
 */
public class HelpCommand implements Command {

	@Override
	public String description() {
		return "help";
	}

	@Override
	public void execute() {
		System.out.println("Here is a small reminder of all commands and what they do ;-) \n");
		System.out.println("> add: Creates a new task by asking you for a description");
		System.out.println("> list: Lists all tasks");
		System.out.println(
				"> delete: Deleta a task by showing you all tasks with specific ID and by asking you which ID you want to delete");
		System.out.println("> exit: Close the app");
		System.out.println("> help: Print this message");
	}

}
