package commands;

import java.util.Scanner;

import task.Main;
import task.Task;

/**
 * Command which adds a new task
 * @author Melvin Campos Casares
 *
 */
public class AddCommand implements Command {

	public String description() {
		return "add";
	}

	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert a description>");
		if (scanner.hasNextLine()) {
			String description = scanner.nextLine();
			if (description.isEmpty()) {
				System.out.println("Sorry... Please try again ;-)\n");
			} else {
				Task task = new Task(description);
				Main.tasks.add(task);
				Main.memory.save(Main.tasks);
			}
		}
		System.out.println("Done!");
	}

}
