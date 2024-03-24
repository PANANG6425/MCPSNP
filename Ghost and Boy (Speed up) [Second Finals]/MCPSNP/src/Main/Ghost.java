package Main;

import java.awt.Graphics;

public class Ghost extends Boy {

    public int ghostX;
    public int ghostY;
    public static int ghost_speed = 1;
    public static int  gh;

    public Ghost() {
        super(); // เรียก constructor ของคลาส Boy
    }
    
   	public int getgh() {
   		return Ghost.gh;
   	}
    public int getGhost_speed() {
		return ghost_speed;
	}

	public static void setGhost_speed(int ghost_speed) {
		Ghost.ghost_speed = ghost_speed;
	}
	
	public static void draw_ghost(Graphics g) {
		
        if (ghost_speed > -380) {
            ghost_speed -= 5;
        }
        
        g.drawImage(animations[0][0], (int) (getxDelta()) - (400 + ghost_speed), (int) getyDelta(), 100, 100, null);
       
        gh = (getxDelta()) - (400 + ghost_speed);
        
        
       
    }
}