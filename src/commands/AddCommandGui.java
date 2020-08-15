package commands;

import javax.swing.JOptionPane;

import task.Main;
import task.Task;

/**
 * Command which adds a new task (GUI interface)
 * 
 * @author Melvin Campos Casares
 *
 */
public class AddCommandGui extends AddCommand {

	private String description;

	public void execute(String description) {
		System.out.println(Main.tasks.toString());
		System.out.print("Insert a description>");
		this.description = description;
		System.out.println(description);

		if (description == null || description.isEmpty()) {
			System.out.println("Sorry... Please try again ;-)\n");
			JOptionPane.showMessageDialog(null, "Sorry... Please try again ;-)");
		} else {
			Task task = new Task(this.description);
			Main.tasks.add(task);

			Main.memory.save(Main.tasks);
		}

		System.out.println("Done!");
	}

}
