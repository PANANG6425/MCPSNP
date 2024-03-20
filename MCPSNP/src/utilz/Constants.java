package utilz;

public class Constants {
	public static class PlayerConmstants{
		public static final int walkking = 0;
		public static final int IDLE = 1;
		public static final int Holdcandle = 2;
		public static final int Covercandle = 3;
	public static int GetSpriteAmount(int player_action) {
		
		switch(player_action) {
		case walkking:
			return 6;
		default:
			return 1;
		}
	}
	
	}
	
}


