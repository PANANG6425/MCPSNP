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
	private int xDelta = 20 , yDelta = 498;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick,aniSpeed = 14;
	private int aniIndex = 4;
	private int playerAction =  IDLE;
	
	
	
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

	
	
	
	public int getPlayerAction() {
		return playerAction;
	}
	public void setPlayerAction(int playerAction) {
		this.playerAction = playerAction;
	}

	private int playerDir = -1;
	public boolean moving = false;
	
	private BufferedImage background;
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
		importImg();
		loadAnimations();
		
		
	}/*
	public void loadBackground() {
        InputStream is = getClass().getResourceAsStream("background.jpg");
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
    }*/
	////////////*
	
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
	
/*
	public void loadBackground2() {
        InputStream is = getClass().getResourceAsStream("background2.jpg");
        try {
            background2 = ImageIO.read(is);
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
	public void loadBackground3() {
        InputStream is = getClass().getResourceAsStream("background3.jpg");
        try {
            background3 = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
	public int getxDelta() {
		return xDelta;
	}
	public void setxDelta(int xDelta) {
		this.xDelta = xDelta;
	}
	public int getyDelta() {
		return yDelta;
	}
	public void setyDelta(int yDelta) {
		this.yDelta = yDelta;
	}
	private void loadAnimations() {
	animations = new BufferedImage[14][7];
	for(int j = 0;j <7;j++)
		for(int i = 0; i <14; i++)
			animations[i][j] = img.getSubimage(j*292,i*292,292,292);
		
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
		Dimension size = new Dimension(1366,768);//1366,768
		setPreferredSize(size);
		//setMinimumSize(size);
	
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
		        yDelta -=2;
		        
		       
		       bgY += 2;
		        
		        break;
		    case 0:
		        xDelta -=2;
		        if(bgX < -100) {
		        	bgX += 2;
		        }
		        else {
		        
		        }
		        
		        
		        
		        break;
		    case 2:
		        xDelta +=2;

		        if(bgX > -650) {
		        	bgX -= 2;
		        }
		        else {
		        	
		        }
		       
		        
		        
		        break;
		    case 3:
		        yDelta +=2;  
		        bgY -= 2;
		    case 300:
		    	yDelta += 0;
		    	xDelta += 0;
		        break;
			}
			
		}
		
	}
	public void checkmove(Graphics g,int playerDir) {
		try {
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
	        }
	    } catch (ArrayIndexOutOfBoundsException e) {
	        // พบข้อผิดพลาด ArrayIndexOutOfBoundsException
	        System.err.println("Array index out of bounds. Resetting aniIndex to 0.");
	        aniIndex = 1;
	    }
	}
	public void checkmove_with_candle(Graphics g,int playerDir) {
		try {
		 if (playerDir == 0) {
	            g.drawImage(animations[9][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	            System.out.println(aniIndex);
	           
	            moving = false;
	        } else if (playerDir == 2) {
	            g.drawImage(animations[5][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	            
	            moving = false;
	            
	            
	        } else if (playerDir == 3 || playerDir == 1) {
	            g.drawImage(animations[3][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
	           
	            moving = false;
	            
	        }else if (playerDir == 200) {
	            g.drawImage(animations[0][0], (int) xDelta, (int) yDelta, 100, 100, null);
	            System.out.println("stop animation by released");
	            moving = false;
	            
	        } else {
	        	moving = false;
	            System.out.println("error move");
	        }
	    } catch (ArrayIndexOutOfBoundsException e) {
	        // พบข้อผิดพลาด ArrayIndexOutOfBoundsException
	        System.err.println("Array index out of bounds. Resetting aniIndex to 0.");
	        aniIndex = 1;
	    }
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateAnimationTick();
		setAnimation();
		updatePos();
		
		if (background != null) {
			
			loadBackground();
			
			 g.drawImage(background, bgX, bgY, 2100, getHeight(), null);
        }
		try {
			if (state == 1) {
				
				checkmove(g,playerDir);
			}
			else if(state == 2) {
				
				checkmove(g,playerDir);
			}
			else if (state == 3 ) {
				
				System.out.println("cover");
				checkmove_with_candle(g,playerDir);
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
	        aniIndex = 1;
	    }
	    
			
	
	
	}
}