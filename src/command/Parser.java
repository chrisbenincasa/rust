package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import game.Game;
import jline.ArgumentCompletor;
import jline.ConsoleReader;
import jline.SimpleCompletor;

public class Parser extends Thread {
	private Game game;
	private final HashSet<String> ignoredWords = new HashSet<String>(Arrays.asList(new String[]{"at", "the", "a", "an"}));
	
	public Parser(Game game) {
		this.game = game;
	}
	
	public void run() {
		String inputLine = "";
		try {
			ConsoleReader reader = new ConsoleReader();
			reader.setBellEnabled(false);
			List<SimpleCompletor> completors = new LinkedList<SimpleCompletor>();
			String[] allCommands = {};
			for(Command executor : game.getCommandExecutors()) {
				allCommands = join(allCommands, executor.getRecognizedCommands());
			}
			completors.add(new SimpleCompletor(allCommands));
			reader.addCompletor(new ArgumentCompletor(completors));
			
			// start main parsing loop
			while((inputLine = reader.readLine("\n> ", (char) 0)) != null) {
				if(inputLine.equalsIgnoreCase("quit") || inputLine.equalsIgnoreCase("exit")) {
					System.out.println("Bye!");
					break;
				} else {
					if(!handleInputLine(inputLine)) {
						System.out.println("I don't understand what you said.");
					}
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			System.exit(1);
		}
	}
	
	private boolean handleInputLine(String input) {
		String[] tokens = input.split(" ");
		String currentToken;
		for(int i = 0; i < tokens.length; i++) {
			currentToken = tokens[i];
			for(Command executor : game.getCommandExecutors()) {
				if(Arrays.asList(executor.getRecognizedCommands()).contains(currentToken)) {
					currentToken = cleanseLine(currentToken);
					game.processCommand(new CommandEntity(currentToken,
							(i < (tokens.length - 1)) ? input.substring(currentToken.length() + 1) : "" ));
					return true;
				}
			}
		}
		return false;
	}
	
	private String cleanseLine(String input) {
		StringBuilder builder = new StringBuilder();
		String[] tokens = input.split(" ");
		for(String token : tokens) {
			if(!ignoredWords.contains(token)) {
				builder.append(token).append(" ");
			}
		}
		String result = builder.toString();
		if(result.endsWith(" ")) {
			result = result.substring(0, result.length() - 1);
		}
		
		return result;
	}
	
	private String[] join(String[]...arrays) {
		final List<String> output = new ArrayList<String>();
		for(String[] array : arrays) {
			output.addAll(Arrays.asList(array));
		}
		return output.toArray(new String[output.size()]);
	}
}
