package command;

public abstract class Command {
	private String[] commands;
	
	public String[] getRecognizedCommands() {
		return commands;
	}
	
	public boolean execute(CommandEntity command) {
		return false;
	}
}
