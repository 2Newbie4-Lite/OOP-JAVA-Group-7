package ransanmoi;

import java.awt.Point;

public class GameBoard {
    private int width;
    private int height;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //Kiểm tra xem một điểm tạo độ có nằm trong board hay không
    public boolean isInside(Point p) {
        return p.x >= 0 && p.x < width && p.y >= 0 && p.y < height;
    }


    //Phương thức phục vụ cho các class khác truy cập
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
