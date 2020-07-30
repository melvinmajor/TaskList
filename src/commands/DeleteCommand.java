package commands;

import java.util.Scanner;

import task.Main;
import task.Task;

/**
 * Command which deletes a task
 * 
 * @author Melvin Campos Casares
 *
 */
public class DeleteCommand implements Command {

	public String description() {
		return "delete";
	}

	public void execute() {
		for (Task task : Main.tasks) {
			System.out.println("ID: " + task.getId() + " - Description: " + task.getDescription());
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID to delete> ");
		if (scanner.hasNextInt()) {
			int id = scanner.nextInt();
			Task taskDelete = null;

			for (Task task : Main.tasks) {
				if (task.getId() == id) {
					taskDelete = task;
				}
			}
			if (Main.tasks.remove(taskDelete)) {
				Main.memory.save(Main.tasks);
				System.out.println("Done!");
			}
		}

	}

	public static String usage() {
		return "Delete a a task by showing you all tasks with specific ID and by asking you which ID you want to delete";
	}

}
