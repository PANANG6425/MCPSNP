package Main;

public class Wind {
    private int x; // ตำแหน่ง x ของลม
    private int y; // ตำแหน่ง y ของลม
    private int speed; // ความเร็วของลม

    public Wind(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // เมธอดเคลื่อนที่ลม
    public void move() {
        // ในที่นี้เราจะเคลื่อนที่ลมไปทางซ้ายตลอดเวลา
        x -= speed;
    }

    // เมธอดตรวจสอบการชนกับตัวละคร
    public boolean checkCollision(int boyX, int boyY) {
        // ในที่นี้เราจะใช้เงื่อนไขง่าย ๆ คือ ตรวจสอบว่าตำแหน่ง x ของลมมีค่าน้อยกว่าตำแหน่ง x ของตัวละคร
        // ถ้าใช่ แสดงว่าลมชนกับตัวละครแล้ว
        return x < boyX;
    }

    // เมธอดเข้าถึงตำแหน่ง x ของลม
    public int getX() {
        return x;
    }

    // เมธอดเข้าถึงตำแหน่ง y ของลม
    public int getY() {
        return y;
    }
}
