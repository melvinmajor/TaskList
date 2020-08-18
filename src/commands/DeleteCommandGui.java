package commands;

import task.Main;
import task.Task;

/**
 * Command which deletes a task (GUI interface).
 * 
 * @author Melvin Campos Casares
 *
 */
public class DeleteCommandGui extends DeleteCommand {

	private int id;
	private Task taskDelete = null;

	public void execute(int id) {
		System.out.print("ID to delete> ");
		this.id = id;
		System.out.println(id);

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
