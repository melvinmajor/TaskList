package commands;

/**
 * Command which lists a description of all available commands.
 * 
 * @author Melvin Campos Casares
 *
 */
public class HelpCommand implements Command {

	public String description() {
		return "help";
	}

	@Override
	public void execute() {
		System.out.println("Here is a small reminder of all commands and what they do ;-) \n");
		System.out.println("> add: " + AddCommand.usage());
		System.out.println("> list: " + ListCommand.usage());
		System.out.println("> delete: " + DeleteCommand.usage());
		System.out.println("> exit: Close the app");
		System.out.println("> help: " + HelpCommand.usage() + "\n");
	}

	public static String usage() {
		return "Print this help message with available commands and a small explanation";
	}

}
