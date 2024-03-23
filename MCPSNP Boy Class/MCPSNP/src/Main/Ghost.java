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

public class Ghost extends Boy{
    public int ghostX;
    public int ghostY;
    public int ghost_speed;
    public Ghost(){
        super();
    }
    public int getGhost_speed(){
        return ghost_speed;
    }
    public void setGhost_speed(int ghost_speed) {
		this.ghost_speed = ghost_speed;
	}
	public int gh;
	
	public void draw_ghost(Graphics g) {
		if(ghost_speed > -380) {
			ghost_speed -= 2;
		}
		else {
			
		}
		g.drawImage(animations[0][aniIndex], (int) (super.getxDelta()) - (400+ghost_speed), (int) super.getyDelta(), 100, 100, null);
		gh = (super.getxDelta())-(400+ghost_speed);
		
	}
}
