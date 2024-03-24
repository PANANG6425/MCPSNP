	package Main; 
	
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.io.InputStream;
	import javax.imageio.ImageIO;
	import javax.swing.JPanel;
	import static utilz.Constants.PlayerConstants.*;
	import static utilz.Constants.Directions.*;
	
	public class Boy extends JPanel {
	    
	    private BufferedImage img;
	    public static BufferedImage[][] animations;
	    private int aniTick, aniSpeed = 14;
	    public static int aniIndex = 4;
	    private int playerAction = IDLE;
	   
	   
	
	    public Boy() {
	        importImg();
	        loadAnimations();
	    }
	    public boolean get_moving() {
	    	return this.moving;
	    }
	    public void set_moving(boolean moving) {
	    	this.moving = moving;
	    }
	    private void loadAnimations() {
	        animations = new BufferedImage[14][7];
	        for (int j = 0; j < 7; j++)
	            for (int i = 0; i < 14; i++)
	                animations[i][j] = img.getSubimage(j * 292, i * 292, 292, 292);
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
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	    
	
	    
	    public void updateAnimationTick() {
	        aniTick++;
	        if (aniTick >= aniSpeed) {
	            aniTick = 0;
	            aniIndex++;
	            if (aniIndex >= GetSpriteAmount(playerAction))
	                aniIndex = 0;
	        }
	    }
	    private static int xDelta = 20;
		protected static int yDelta = 505;
		public static boolean moving = false;
		public static int playerDir = -1;
		public static void setDirection(int direction) {
		        playerDir = direction;
		       // System.out.println("This is player direction");
		        //System.out.println(direction);
		        moving = true;
		    }
		 public void setMoving(boolean moving) {
		        this.moving = moving;
		    }
	
		    public int getPlayerDir ()
		    {
		        return this.playerDir;
		    }
	
		    public boolean getMoving()
		    {
		        return this.moving;
		    }
	
		public void updatePos() {
	       if (moving) {
	           switch (playerDir) {
	               case Left:
	                   xDelta -= 5;
	                   if(GamePanel.getBgX() < -100) {
	                	   GamePanel.setBgX(GamePanel.getBgX() + 5);
	                   }
	                   break;
	               case Up:
	                   yDelta -= 5;
	                   break;
	               case Right:
	                   xDelta += 5;
	                   if(GamePanel.getBgX() > -650) {
	                	   GamePanel.setBgX(GamePanel.getBgX() - 5);
	                   }
	                   break;
	               case Down:
	                   yDelta += 5;
	                   break;
	               case Stop:
	                   yDelta += 0;
	                   xDelta += 0;
	                   break;
	               }
	           }
	   }
		    
	
	    public void setAnimation() {
	        if (moving)
	            playerAction = walking;
	        else
	            playerAction = IDLE;
	    }
	
	    
	   
	    public void checkmove(Graphics g,int playerDir) {
	    
			try {
			 if (playerDir == 0) {
			
		            g.drawImage(animations[2][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            
		          
		            
		           
		            moving = false;
		        } else if (playerDir == 2) {
		        	moving = true;
		            g.drawImage(animations[1][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            moving = false;
		        } else if (playerDir == 3 || playerDir == 1) {
		            g.drawImage(animations[0][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            moving = false;
		        }else if (playerDir == 200) {
		            g.drawImage(animations[0][0], (int) xDelta, (int) yDelta, 100, 100, null);
		            //System.out.println("stop animation by released");
		            moving = false;
		        } else {
		        	moving = false;
		            System.out.println("error move");
		        }
		    } catch (ArrayIndexOutOfBoundsException e) {
		        // พบข้อผิดพลาด ArrayIndexOutOfBoundsException
		       // System.err.println("Array index out of bounds. Resetting aniIndex to 0.");
		        aniIndex = 1;
		    }
		}
	    
		public void checkmove_with_candle(Graphics g,int playerDir) {
			
			try {
			 if (playerDir == 0) {
		            g.drawImage(animations[9][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            
		            Ghost.setGhost_speed(100);
		            moving = false;
		        } else if (playerDir == 2) {
		        	 // เรียกใช้เมธอด draw_ghost() ของ Ghost
		            g.drawImage(animations[5][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		             // สร้างอ็อบเจกต์ของ Ghost
		            //Ghost ghost = new Ghost();
		            Ghost.draw_ghost(g);
		       
		            moving = false;
		        } else if (playerDir == 3 || playerDir == 1) {
		            g.drawImage(animations[3][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            
		            moving = false;
		        }else if (playerDir == 200) {
		            g.drawImage(animations[0][aniIndex], (int) xDelta, (int) yDelta, 100, 100, null);
		            //System.out.println("stop animation by released");
		            Ghost ghost = new Ghost();
		            ghost.draw_ghost(g);
		            moving = false;
		        } else {
		        	moving = false;
		            System.out.println("error move");
		        }
		    } catch (ArrayIndexOutOfBoundsException e) {
		        // พบข้อผิดพลาด ArrayIndexOutOfBoundsException
		       // System.err.println("Array index out of bounds. Resetting aniIndex to 0.");
		        aniIndex = 1;
		    }
		}
		public  int getAniIndex() {
	        return aniIndex;
	    }
	
	    public static BufferedImage[][] getAnimations() {
	        return animations;
	    }
	    public static int getxDelta() {
	        return xDelta;
	    }
	
	    public void setxDelta(int xDelta) {
	        this.xDelta = xDelta;
	    }
	
	    public static int getyDelta() {
	        return yDelta;
	    }
	
	    public void setyDelta(int yDelta) {
	        this.yDelta = yDelta;
	    }
	    
	
	} 