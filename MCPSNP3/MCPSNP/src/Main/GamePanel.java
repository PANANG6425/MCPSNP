package Main;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInput;
import Inputs.Mouse;
public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mouse mouse;
	private int xDelta = 100 , yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick,aniIndex,aniSpeed = 15;
	private int playerAction =  IDLE;
	private int playerDir = -1;
	private boolean moving = false;
	public GamePanel() {
		
		mouse = new Mouse(this);
		setPanalSize();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		importImg();
		loadAnimations();
		
		
	}
	private void loadAnimations() {
	animations = new BufferedImage[9][10];
	for(int j = 0;j <animations.length;j++)
		for(int i = 0; i < animations[j].length; i++)
			animations[j][i] = img.getSubimage(i*473,j*480,473,480);
		
	}
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("boy.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			}catch (IOException e) {
				e.printStackTrace();			}
		}
	}
	private void setPanalSize() {
		Dimension size = new Dimension(1366,768);
		setPreferredSize(size);
	
}
	public void setDirection(int direction) {
		this.playerDir = direction;
		moving = true;
		System.out.println(direction);
		
	}	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public void updateAnimationTick() {
	aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
				
		}
	}
	public void setAnimation() {
		if(moving)
			playerAction = walking;
		else
			playerAction = IDLE;
		
	}
	public void updatePos() {
		System.out.println(moving);
		if(moving) {
			System.out.println(playerDir);
			switch(playerDir) {
			
			case 1:
		        yDelta -=1;
		        //moving = false;
		        break;
		    case 0:
		        xDelta -=1;
		        //moving = false;
		        break;
		    case 2:
		        xDelta +=1;
		        //moving = false;
		        break;
		    case 3:
		        yDelta +=1;  
		       // moving = false;
		        break;
			}
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateAnimationTick();
		setAnimation();
		updatePos();
		
		g.drawImage(animations[playerAction][aniIndex],(int) xDelta,(int)yDelta,100,100,null);
	
	}
	
	
}
