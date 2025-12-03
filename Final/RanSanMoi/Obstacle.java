package ransanmoi;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Obstacle {
    private Point tilePos;          // vị trí tính theo ô (tile)
    private int xPixel, yPixel;     // = tilePos.x * TILE_SIZE
    private int width;             
    private int height;             
    private BufferedImage image;    // ảnh đã load

    // constructor dùng ảnh đã load và vị trí tile
    public Obstacle(BufferedImage image, Point tilePos, int tileSize) {
        this.image = image;
        this.tilePos = tilePos;
        this.xPixel = tilePos.x * tileSize;
        this.yPixel = tilePos.y * tileSize;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public Rectangle getBounds() {
        return new Rectangle(xPixel, yPixel, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(image, xPixel, yPixel, null); // vẽ theo kích thước ảnh gốc
    }

    public Point getTilePos() { return tilePos; }
    public BufferedImage getImage() { return image; }
}
