package utilz;

public class Constants {
	
	public static class Directions{
		public static final int Left = 0;
		public static final int  Up = 1;
		public static final int  Right= 2;
		public static final int  Down = 3;
		
	}
	
	public static class PlayerConstants{
		public static final int IDLE = 7;
		public static final int walking = 6;
		public static final int Holdcandle = 100;//ค่าเดิม 0 ขอเปลี่ยน
		public static final int Covercandle = 200;//ค่าเดิม 2 ขอเปลั้ยน
		public static final int faint = 8;
	public static int GetSpriteAmount(int player_action) {
		
		switch(player_action) {
		case walking:
			return 10;
		case IDLE:
			return 1;
		case Holdcandle:
		case Covercandle:
			return 60;
		case faint:
			return 8;
		default:
			return 1;
		}
	}
	
	}
	
}


