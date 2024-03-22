package Main;

//import static utilz.Constants.Directions.Right;
import static utilz.Constants.Directions.*;
public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
		gamePanel.setState(1);
		gamePanel.loadBackground();
		

		for (int i = 0; i < 1; i--) { 
			gamePanel.requestFocus();
			
			while(gamePanel.moving) {
				gamePanel.updatePos();
				gamePanel.repaint();
				System.out.println(gamePanel.getxDelta() +  "," + gamePanel.getyDelta());
				//1366,768
				//20,430
				
				if(gamePanel.getxDelta() > 1366) {
					gamePanel.stateadd();
					gamePanel.loadBackground2();
					System.out.println("stop");
					gamePanel.setDirection(Stop);
					gamePanel.setxDelta(20);
					gamePanel.setyDelta(440);
				}
				else if(gamePanel.getxDelta() < 0) {
					gamePanel.stateneg();
					gamePanel.loadBackground();
					System.out.println("stop");
					gamePanel.setDirection(Stop);
					gamePanel.setxDelta(1300);
					gamePanel.setyDelta(440);
				}
				
				else {
					try {
						Thread.sleep(1); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	
	}
	
}
