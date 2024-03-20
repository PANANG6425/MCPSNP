package Main;

import javax.swing.JFrame;

public class Gamemoniter {
	private JFrame jframe;
	public Gamemoniter(GamePanel gamePanel) {
		jframe = new JFrame();
		
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(true);
		jframe.pack();
		jframe.setVisible(true);
	}
}
