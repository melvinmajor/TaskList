package commands;

/**
 * Command interface setting up methods that all commands should have when
 * implemented.
 * 
 * @author Melvin Campos Casares
 */
public interface Command {
	String description();

	void execute();

	static String usage() {
		return null;
	}
}
