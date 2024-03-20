package Main;

public class Game {
	private Gamemoniter GameMoniter;
	private GamePanel GamePanel;

	public Game() {
		GamePanel = new GamePanel();
		GameMoniter = new Gamemoniter(GamePanel);
		GamePanel.requestFocus();
	}

}
