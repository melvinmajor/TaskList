package task;

/**
 * The Task class which ensure the structure of a task which contains a
 * description and is related to a unique ID.
 * 
 * @author Melvin Campos Casares
 *
 */
public class Task {
	private int id;
	private static int count;
	private String description;

	public Task(String description) {
		this.id = count++;
		this.description = description;
	}

	/**
	 * Get the ID of the task
	 * 
	 * @return the ID (int) of the task
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the description of the task
	 * 
	 * @return the description (String) of the task
	 */
	public String getDescription() {
		return description;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Task: " + description;
	}

}
