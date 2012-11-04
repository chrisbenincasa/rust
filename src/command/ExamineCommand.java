package command;

public class ExamineCommand extends Command {
	private String[] recognizedCommands = {"examine", "look"};
	
	public String[] getRecognizedCommands() {
		return this.recognizedCommands;
	}
	
	public boolean execute(CommandEntity command) {
		System.out.println("EXAMINE!");
		return true;
	}
}
