package command;

import model.being.Player;

public class PlayerCommand extends Command {
	private Player player;
	private String[] recognizedCommands = {"say"};
	
	public PlayerCommand(Player player) {
		this.player = player;
	}
	
	public String[] getRecognizedCommands() {
		return recognizedCommands;
	}
	
	public boolean execute(CommandEntity command) {
		String arg = command.getArg(0);
		if(arg != null) {
			if(arg.equalsIgnoreCase("name")) {
				System.out.println("\"My name is " + player.getName() + ",\" you yell like a maniac.");
			}
		}
		
		return true;
	}
	
}
