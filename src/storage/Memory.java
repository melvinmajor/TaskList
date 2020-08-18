package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import task.Main;
import task.Task;

/**
 * Class that ensure all tasks are saved in a .TXT file which is automatically
 * loaded on each startup of the program.
 * 
 * @author Melvin Campos Casares
 *
 */
public class Memory {
	private final File file = new File("TaskList-data.txt");

	public void load() {
		if (!file.exists()) {
			return;
		}
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (reader == null)
			return;

		try {
			List<String> lines = Files.readAllLines(file.toPath());

			for (String description : lines) {
				Main.tasks.add(new Task(description));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void save(List<Task> tasks) {
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (writer == null) {
			System.err.println("can't read file");
			return;
		}

		try {
			for (Task task : tasks) {
				writer.write(task.getDescription() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
