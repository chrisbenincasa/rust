package ui;
import game.Game;

public class Runner {
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		game.run();
	}
}
