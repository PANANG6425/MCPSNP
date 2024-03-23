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
	public Boy boy = new Boy();
	//private BufferedImage img;
	
	
	
	
	private int bgX = 0;
	public int getBgX() {
		return bgX;
	}
	public void setBgX(int bgX) {
		this.bgX = bgX;
	}
	public int getBgY() {
		return bgY;
	}
	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	private int bgY = 0;
	private BufferedImage background;
	public BufferedImage dead;
	private BufferedImage background2;
	private BufferedImage background3;
	public int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void stateadd() {
		this.state = this.state + 1;
	}
	public void stateneg() {
		this.state = this.state - 1;
	}
	
	public GamePanel() {
		
		mouse = new Mouse(this);
		setPanalSize();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		
		
	}
	
	public void loadBackground() {
		
		System.out.println("state" + state);
	    String backgroundImageName = "background" + state + ".gif"; // สร้างชื่อไฟล์ภาพพื้นหลังโดยใช้ state
	    InputStream is = getClass().getResourceAsStream(backgroundImageName);
	    try {
	        background = ImageIO.read(is);
	    } catch (IOException e) {
	    	
	        e.printStackTrace();

	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }
	}//////////*
public void loadBackground_dead() {
		
		System.out.println("state" + state);
	    String backgroundImageName = "background6.gif"; // สร้างชื่อไฟล์ภาพพื้นหลังโดยใช้ state
	    InputStream is = getClass().getResourceAsStream(backgroundImageName);
	    try {
	        dead = ImageIO.read(is);
	    } catch (IOException e) {
	    	
	        e.printStackTrace();

	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }
	}


	private void setPanalSize() {
		Dimension size = new Dimension(1366,768);//1366,768
		setPreferredSize(size);
		//setMinimumSize(size);
	
}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		boy.updateAnimationTick();
		boy.setAnimation();
		boy.updatePos();
		repaint();
		if (background != null) {
			
			loadBackground();
			
			 g.drawImage(background, bgX, bgY, 2100, getHeight(), null);
        }
		try {
			if (state == 1) {
				
				boy.checkmove(g,boy.getPlayerDir());
			}
			else if(state == 2) {
				
				boy.checkmove(g,boy.getPlayerDir());
			}
			else if (state == 3 ) {
				
				System.out.println("cover");
				boy.checkmove_with_candle(g,boy.getPlayerDir());
				
								
			}
			else {
				System.out.println("no state");
			}
			
			/*
	        if (playerDir == 0) {
	            g.drawImage(animations[2][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	            System.out.println(aniIndex);
	           
	            moving = false;
	        } else if (playerDir == 2) {
	            g.drawImage(animations[1][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	            
	            moving = false;
	            
	            
	        } else if (playerDir == 3 || playerDir == 1) {
	            g.drawImage(animations[0][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	           
	            moving = false;
	            
	        }else if (playerDir == 200) {
	            g.drawImage(animations[0][0], (int) xDelta, (int) yDelta, 100, 100, null);
	            System.out.println("stop animation by released");
	            moving = false;
	            
	        } else {
	        	moving = false;
	            System.out.println("error move");
	        }*/
	    } catch (ArrayIndexOutOfBoundsException e) {
	        // พบข้อผิดพลาด ArrayIndexOutOfBoundsException
	        System.err.println("Array index out of bounds. Resetting aniIndex to 0.");
	        boy.aniIndex = 1;
	    }
	    
			
	
	
	}


	
	

	
	
	
	
	
}

