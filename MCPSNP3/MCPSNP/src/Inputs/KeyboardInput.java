package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utilz.Constants.Directions.*;
import Main.GamePanel;


public class KeyboardInput implements KeyListener{
	private GamePanel gamePanel;

	public KeyboardInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	private boolean isKeyPressed = false;

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			//gamePanel.setDirection(Up); // เปลี่ยน Up แทนที่ 0
			break;
		case KeyEvent.VK_S:
			//gamePanel.setDirection(Down);
			break;
		case KeyEvent.VK_A:
			gamePanel.setDirection(Left);
			break;
		case KeyEvent.VK_D:
			gamePanel.setDirection(Right);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			//gamePanel.moving = true;
			//gamePanel.setPlayerAction(Stop);
		case KeyEvent.VK_S:
			//gamePanel.moving = true;
			//gamePanel.setPlayerAction(Stop);
		case KeyEvent.VK_A:
			//gamePanel.moving = true;
			//gamePanel.setPlayerAction(Stop);
		case KeyEvent.VK_D:
			//gamePanel.moving = true;
			//gamePanel.setPlayerAction(Stop);
			//System.out.println("d stop");
			break;
		}
	}
	
}