package Main;

//import static utilz.Constants.Directions.Right;
import static utilz.Constants.Directions.*;
public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	private Boy boy;
	
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
		gamePanel.setState(1);
		gamePanel.loadBackground();
		
		for (int i = 0; i < 1; i--) { 
			gamePanel.requestFocus();
			System.out.println(boy.getMoving());
			while(boy.getMoving()) {
				boy.updatePos();
				gamePanel.repaint();
				gamePanel.drawImage(boy.animations[2][1], (int)  100, (int) 100, 100, 100, null);
				System.out.println(boy.getxDelta() +  "," + boy.getyDelta());
				//1366,768
				//20,430
				System.out.println("x" + gamePanel.getBgX());
				System.out.println("y" + gamePanel.getBgY());
				
				if(boy.getxDelta() > 1366) {
					gamePanel.setBgX(0);
					gamePanel.setBgY(0);
					gamePanel.stateadd();
					gamePanel.loadBackground();
					System.out.println("stop");
					boy.setDirection(Stop);
					boy.setxDelta(20);
					boy.setyDelta(498);
				}
				else if(boy.getxDelta() < 0) {
					gamePanel.setBgX(0);
					gamePanel.setBgY(0);
					gamePanel.stateneg();
					gamePanel.loadBackground();
					System.out.println("stop");
					boy.setDirection(Stop);
					boy.setxDelta(1300);
					boy.setyDelta(498);
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
