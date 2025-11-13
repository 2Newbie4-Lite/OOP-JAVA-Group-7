package ransanmoi;

import java.awt.Point;      //Biểu diễn tạo độ thức ăn (x,y)
import java.util.Random;        //Sinh vị trí ngẫu nhiên

public class Food {
    //Vị trí của food
    private Point position;
    //Tạo số ngẫu nhiên
    private Random rand = new Random();

    //Hàm khởi tạo constructor
    public Food(int maxX, int maxY) {
        respawn(maxX, maxY);
    }
    //Cho phép lớp Game và GameBoard truy cập
    public Point getPosition() {
        return position;
    }
    //Sinh tại vị trí ngẫu nhiên
    public void respawn(int maxX, int maxY) {
        position = new Point(rand.nextInt(maxX), rand.nextInt(maxY));
    }
}
