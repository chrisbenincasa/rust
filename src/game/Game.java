package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.being.Player;

import command.*;

public class Game {
	public static Game instance;
	private Parser parser;
	private ArrayList<Command> executors;
	private Player player; 
	
	public void init() {
		instance = this;
		executors = new ArrayList<Command>();
		createPlayer();
		addBaseCommands();
		parser = new Parser(this);
	}
	
	public void run() {
		parser.start();
	}
	
	public void addBaseCommands() {
		executors.add(new ExamineCommand());
		executors.add(new PlayerCommand(player));
	}
	
	public boolean processCommand(CommandEntity command) {
		for(Command executor : executors) {
			if(Arrays.asList(executor.getRecognizedCommands()).contains(command.getCommandWord())){
				return executor.execute(command);
			}
		}
		return false;
	}
	
	public List<Command> getCommandExecutors() {
		return executors;
	}
	
	private void createPlayer() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your player name: ");
		String playerName = in.nextLine();
		this.player = new Player(playerName);
	}
}
