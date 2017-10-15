
public class MyGame {
	
	private Game game;
	
	public MyGame() {
		game = new Game(800, 827, "My Game");
		game.getScreenFactory().showScreen(new MyScreen(game.getScreenFactory()));
	}
	
	public static void main (String [] args) {
		new MyGame();
		
	}

}
