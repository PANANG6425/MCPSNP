package Main;

//import static utilz.Constants.Directions.Right;
import static utilz.Constants.Directions.*;

import java.awt.datatransfer.SystemFlavorMap;
public class Game {
	private Gamemoniter gameMonitor;
	private GamePanel gamePanel;
	
	int hittime = 0;
	public Game() {
		gamePanel = new GamePanel();
		gameMonitor = new Gamemoniter(gamePanel);
		gamePanel.setState(1);
		gamePanel.loadBackground();
		gamePanel.boy.updatePos();
		gamePanel.repaint();
		System.out.println(gamePanel.boy.get_moving());
		int o = 0;
		for (int i = o; i < 1; i--) { 
			gamePanel.requestFocus();

			if(hittime >  100) {
				System.out.println("ENDDDDDDDDDDDDDDDDDDDD");
				gamePanel.state = 6;
				break;
				
			}
			else {
				while(gamePanel.boy.getMoving()) {
					System.out.println("moving");
					gamePanel.boy.updatePos();
					gamePanel.repaint();/*
					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					System.out.println(gamePanel.boy.getxDelta());
					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					//System.out.println(gamePanel.boy.get_gh());
					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");*/
					System.out.println("HIT TIME" + hittime);
					//System.out.println(Math.abs(gamePanel.getxDelta() + gamePanel.ghostX) <1);
					if(Math.abs(gamePanel.boy.getxDelta() - (gamePanel.boy.get_gh())) <=50){
						gamePanel.boy.setxDelta(100);
						//System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
						gamePanel.boy.setGhost_speed(400);
						hittime +=1;
					}
					//1366,768
					//20,430
					System.out.println("x" + gamePanel.getBgX());
					System.out.println("y" + gamePanel.getBgY());
					
					if(gamePanel.boy.getxDelta() > 1366) {
						gamePanel.setBgX(0);
						gamePanel.setBgY(0);
						gamePanel.stateadd();
						gamePanel.loadBackground();
						System.out.println("stop");
						gamePanel.boy.setDirection(Stop);
						gamePanel.boy.setxDelta(20);
						gamePanel.boy.setyDelta(498);
					}
					else if(gamePanel.boy.getxDelta() < 0) {
						gamePanel.setBgX(0);
						gamePanel.setBgY(0);
						gamePanel.stateneg();
						gamePanel.loadBackground();
						System.out.println("stop");
						gamePanel.boy.setDirection(Stop);
						gamePanel.boy.setxDelta(1300);
						gamePanel.boy.setyDelta(498);
					}
					
					else {
						try {
							Thread.sleep(5); 
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			//System.out.println("breakkkkkkk");
		}
		
	}
}