package ransanmoi;

import java.awt.Point;//Tạo điểm có tọa độ x,y
import java.util.LinkedList;//Lưu các điểm tạo thân rắn
import java.util.List;

public class Snake {

    //Sử dụng Linkedlist để tạo thân, không sử dụng Array do ta chỉ thêm ô vào cuối danh sách, nên linked sẽ nhanh hơn, array thêm giữa sẽ nhanh hơn
    private List<Point> body = new LinkedList<>();


    //Hướng mặc định khi bắt đầu
    private Direction direction = Direction.RIGHT;


    //Hàm khởi tạo (constructor)
    public Snake(Point startPos) {
        //Đầu rắn
        body.add(startPos);
        //Rắn bắt đầu với 1 ô thân
        body.add(new Point(startPos.x - 1, startPos.y));
        //
        direction = Direction.RIGHT;
    }

    //Biến để sửa lỗi chuyển hướng quá nhanh
    private boolean canChangeDirection = true;


    // Phương thức di chuyển
    public void move(int boardWidth, int boardHeight) {

        // Sao chép Đầu hiện tại
        Point head = new Point(body.get(0));

        //Tính vị trí đầu mới
        switch (direction) {
            case UP -> head.y--;
            case DOWN -> head.y++;
            case LEFT -> head.x--;
            case RIGHT -> head.x++;
        }

        // Cơ chế xuyên tường
        if (head.x < 0) head.x = boardWidth - 1;
        if (head.x >= boardWidth) head.x = 0;
        if (head.y < 0) head.y = boardHeight - 1;
        if (head.y >= boardHeight) head.y = 0;

        //Thêm đầu mới, xóa đuôi
        body.add(0, head);
        body.remove(body.size() - 1);

        //Cho phép đổi hướng ở khung hình tiếp theo (do bị lỗi đổi hướng quá nhanh)
        
        canChangeDirection = true;
    }

    //Phương thức tăng kích thước
    public void grow() {
        Point tail = body.get(body.size() - 1);
        //Nhân đôi ô ở đuôi => Rắn dài thêm 1
        body.add(new Point(tail));
    }

    //Phương thức kiểm tra va chạm thân
    public boolean hitsSelf() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) return true;
        }
        return false;
    }


    //Lấy thông tin rắn để cung cấp thông tin cho lớp Game và GameBoard
    public Point getHead() { return body.get(0); }

    public List<Point> getBody() { return body; }

    public Direction getDirection() {
        return direction;
    }

    //Đổi hướng rắn
    public void setDirection(Direction d) {

        // ngăn đổi hướng quá nhanh
        if (!canChangeDirection) return;

        boolean opposite =
                (d == Direction.UP && direction == Direction.DOWN) ||
                        (d == Direction.DOWN && direction == Direction.UP) ||
                        (d == Direction.LEFT && direction == Direction.RIGHT) ||
                        (d == Direction.RIGHT && direction == Direction.LEFT);

        if (!opposite) {
            direction = d;
            canChangeDirection = false; // chỉ cho phép 1 lần đổi hướng mỗi bước
        }

        // Ngăn rắn quay ngược đầu
        if ((d == Direction.UP && direction != Direction.DOWN) ||
                (d == Direction.DOWN && direction != Direction.UP) ||
                (d == Direction.LEFT && direction != Direction.RIGHT) ||
                (d == Direction.RIGHT && direction != Direction.LEFT)) {
            direction = d;
        }

        //Kiểm tra rắn chứa một điểm nào đó, để tránh thức ăn spawn trùng với thân
    }public boolean contains(Point p) {
        for (Point part : body) {
            if (part.equals(p)) return true;
        }
        return false;
    }//Hướng di chuyển
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

}




