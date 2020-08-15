package commands;

public interface Command {
	String description();

	void execute();
	
	static String usage() {
		return null;
	}
}
