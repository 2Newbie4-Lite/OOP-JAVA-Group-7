package ransanmoi;

import java.awt.Point;  //Tạo điểm có tọa độ x,y
import java.util.LinkedList;  //Lưu các điểm tạo thân rắn
import java.util.List;

public class Snake {

    private List<Point> body = new LinkedList<>();


    private Direction direction = Direction.RIGHT;
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    
    public Snake(Point startPos) {
        body.add(startPos);
        direction = Direction.RIGHT;
    }

    
    // Phương thức di chuyển
    public void move(int boardWidth, int boardHeight) {

    }

    //Phương thức tăng kích thước
    public void grow() {
        
    }

    //Phương thức kiểm tra va chạm thân
    public boolean hitsSelf() {
        
    }


    //Lấy thông tin rắn để cung cấp thông tin cho lớp Game và GameBoard
    public Point getHead() { return body.get(0); }

    public List<Point> getBody() { return body; }

    public Direction getDirection() {
        return direction;
    }
    //Đổi hướng rắn
    public void setDirection(Direction d) {
    }
}
