package Main;

public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
	
		gamePanel.requestFocus();
		for (int i = 0; i < 1; i--) { 
			gamePanel.updatePos();
			gamePanel.repaint(); 
			try {
				Thread.sleep(10); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
