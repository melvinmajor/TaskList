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

	@Override
	public String description() {
		return "list";
	}

	@Override
	public void execute() {
		for (Task task : Main.tasks) {
			System.out.println(task);
		}
	}

}
