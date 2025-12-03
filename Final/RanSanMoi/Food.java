package ransanmoi;

import java.awt.Point;//Biểu diễn tạo độ thức ăn (x,y)
import java.util.List;
import java.util.Random;//Sinh vị trí ngẫu nhiên

public class Food {
    //Vị trí của food
    private Point position;
    //Tạo số ngẫu nhiên
    private Random rand = new Random();

    //Hàm khởi tạo constructor
    public Food(int maxX, int maxY) {
        
    }
    //Cho Game và GameBoard truy cập
    public Point getPosition() {
        return position;
    }
    //Sinh tại vị trí ngẫu nhiên
    public void respawn(int maxX, int maxY, List<Obstacle> obstacles, Snake snake) {
        Point p;

        while (true) {
            p = new Point(rand.nextInt(maxX), rand.nextInt(maxY));

            // tránh trùng thân rắn
            if (snake.contains(p)) {
                continue;
            }

            // chuyển tile => pixel để kiểm tra food có trùng với vật thể không
            int px = p.x * 20;
            int py = p.y * 20;

            boolean insideObstacle = false;
            for (Obstacle ob : obstacles) {
                // nếu food  nằm trong obstacle => không hợp lệ
                if (ob.getBounds().contains(px, py)) {
                    insideObstacle = true;
                    break;
                }
            }

            if (!insideObstacle) {
                break; // vị trí hợp lệ
            }
        }

        position = p;
    }
    

}
