package Main;

//import static utilz.Constants.Directions.Right;
import static utilz.Constants.Directions.*;

import java.awt.datatransfer.SystemFlavorMap;
public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
		gamePanel.setState(1);
		gamePanel.loadBackground();
		
		int o = 0;
		for (int i = o; i < 1; i--) { 
			gamePanel.requestFocus();
			
			while(gamePanel.moving) {
				gamePanel.updatePos();
				gamePanel.repaint();
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println(gamePanel.getxDelta());
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println(gamePanel.ghostX);
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
				
				//System.out.println(Math.abs(gamePanel.getxDelta() + gamePanel.ghostX) <1);
				if(Math.abs(gamePanel.getxDelta() - Math.abs(gamePanel.ghostX)) <50){
					gamePanel.setxDelta(100);
				}
				//1366,768
				//20,430
				System.out.println("x" + gamePanel.getBgX());
				System.out.println("y" + gamePanel.getBgY());
				
				if(gamePanel.getxDelta() > 1366) {
					gamePanel.setBgX(0);
					gamePanel.setBgY(0);
					gamePanel.stateadd();
					gamePanel.loadBackground();
					System.out.println("stop");
					gamePanel.setDirection(Stop);
					gamePanel.setxDelta(20);
					gamePanel.setyDelta(498);
				}
				else if(gamePanel.getxDelta() < 0) {
					gamePanel.setBgX(0);
					gamePanel.setBgY(0);
					gamePanel.stateneg();
					gamePanel.loadBackground();
					System.out.println("stop");
					gamePanel.setDirection(Stop);
					gamePanel.setxDelta(1300);
					gamePanel.setyDelta(498);
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
		System.out.println("breakkkkkkk");
	}
	
}