package utilz;

public class Constants {
	
	public static class Directions{
		public static final int Left = 0;
		public static final int  Up = 1;
		public static final int  Right= 2;
		public static final int  Down = 3;
	}
	
	
	public static class PlayerConstants{
		public static final int IDLE = 1;//เพราะว่า1จะเป็นรูปตอนรอ
		public static final int walking = 2;//2
		public static final int Holdcandle = 4;//ค่าเดิม 0 ขอเปลี่ยน
		public static final int Covercandle = 6;//ค่าเดิม 2 ขอเปลั้ยน
		public static final int getup = 12;
		public static final int faint = 13;//8
	public static int GetSpriteAmount(int player_action) {
		
		switch(player_action) {
		case walking:
			return 14;
		case IDLE:
			return 7;
		case Holdcandle:
		case Covercandle:
			return 63;
		case getup:
			return 7;
		case faint:
			return 8;
		default:
			return 1;
		}
	}
	
	}
	
}


