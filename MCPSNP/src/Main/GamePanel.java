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
	public GamePanel() {
		
		mouse = new Mouse(this);
		setPanalSize();
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		importImg();
		
	}
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/test.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setPanalSize() {
		Dimension size = new Dimension(1366,768);
		setPreferredSize(size);

	}
	public void changeXDelta(int value) {
		this.xDelta +=value;
		
	}
	public void changeYDelta(int value) {
		this.yDelta +=value;
	
	}
	public void setRectPos(int x , int y) {
		this.xDelta  = x;
		this.yDelta = y; 
	
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			g.fillRect(xDelta, yDelta,200, 50);
			repaint();
		//g.drawImage(img.getSubimage(0, 0, 480, 480),0,0,null);
	}
}
