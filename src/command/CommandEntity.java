package command;

public class CommandEntity {
	private String commandWord;
	private String argsString;
	private String[] args;
	
	public CommandEntity(String command, String args) {
		commandWord = command;
		argsString = args;
		this.args = args.split(" ");
	}
	
	public String getCommandWord() {
		return commandWord;
	}
	
	public String getArg(int index) {
		if(index <= args.length - 1) {
			return args[index];
		} else {
			return null;
		}
	}
	
	public String[] getArgs() {
		return args;
	}
	
	public String getArgsString() {
		return argsString;
	}
}
