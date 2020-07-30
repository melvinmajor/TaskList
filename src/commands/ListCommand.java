package commands;

import task.Main;
import task.Task;

/**
 * Command which lists all tasks
 * 
 * @author Melvin Campos Casares
 *
 */
public class ListCommand implements Command {

	public String description() {
		return "list";
	}

	@Override
	public void execute() {
		for (Task task : Main.tasks) {
			System.out.println(task);
		}
	}

	public static String usage() {
		return "Lists all tasks";
	}

}
