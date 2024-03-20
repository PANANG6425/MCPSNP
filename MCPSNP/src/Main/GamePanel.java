package Main;

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
	private Mouse mouse;
	private int xDelta = 100 , yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick,aniIndex,aniSpeed = 3;
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
		InputStream is = getClass().getResourceAsStream("/boy.png");
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
	public void changeXDelta(int value) {
		this.xDelta +=value;
		repaint();
	}
	public void changeYDelta(int value) {
		this.yDelta +=value;
		repaint();
	}
	public void setRectPos(int x , int y) {
		this.xDelta  = x;
		this.yDelta = y; 
	
	}
	public void updateAnimationTick() {
	aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= 10)
				aniIndex = 0;
				
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateAnimationTick();
		g.drawImage(animations[7][aniIndex],(int) xDelta,(int)yDelta,100,100,null);
	
	}
	
}
