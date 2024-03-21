package Main;

public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
		
		
		for (int i = 0; i < 1; i--) { 
			gamePanel.requestFocus();
			while(gamePanel.moving) {
				gamePanel.updatePos();
				gamePanel.repaint();
				try {
					Thread.sleep(1); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	}
	
}

