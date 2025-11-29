package ransanmoi;

import java.awt.*;//Chứa các lớp vẽ đồ họa
import javax.swing.*;//Dùng cho các thành phần GUI: JPanel, Timer, JFrame
import java.awt.event.*;//Xử lý các sự kiện bàn phím
import ransanmoi.Snake.Direction;



//Kế thừa JPanel để hiển thị đồ họa và cài đặt ActionListener, KeyListener để xử lý các sự kiện
public class Game extends JPanel implements ActionListener, KeyListener {

    private final int TILE_SIZE = 20;//Kích thước 1 ô
    private final int DELAY = 25; // tốc độ game
    private final GameBoard board;//Lưu kích thước bản đồ
    private Snake snake;//Quan lý rắn, hướng, thân
    private Food food;//Quản lý vị trí food
    private boolean running = true;//Trạng thái game, đang chơi hay gameover
    private Timer timer;//Cập nhật game định kỳ

    
    public Game() {
        board = new GameBoard(50, 50);
        snake = new Snake(new Point(10, 10));//Địa điểm bắt đầu
        food = new Food(board.getWidth(), board.getHeight());//Sinh thức ăn trong board
        timer = new Timer(DELAY, this);
        timer.start();

        setPreferredSize(new Dimension(board.getWidth() * TILE_SIZE, board.getHeight() * TILE_SIZE));
        setBackground(Color.WHITE);

        //Giúp nhận sự kiện nhấn bàn phím
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    //Mỗi Delay, Timer sẽ gọi hàm này, nếu đang chạy thì update để xử lý logic, sau đó vẽ lại giao diện
    public void actionPerformed(ActionEvent e) {
        if (running) {
            update();
        }
        repaint();
    }


    //Logic chiính của game
    private void update() {
        // Xác định trước vị trí đầu (chưa di chuyển)
        Point nextHead = new Point(snake.getHead());
        switch (snake.getDirection()) {
            case UP -> nextHead.y--;
            case DOWN -> nextHead.y++;
            case LEFT -> nextHead.x--;
            case RIGHT -> nextHead.x++;
        }

        // Kiểm tra va chạm trước khi di chuyển
        if (snake.contains(nextHead)) {
            running = false;
            return;
        }

        // Di chuyển
        snake.move(board.getWidth(), board.getHeight());


        // Ăn food
        if (snake.getHead().equals(food.getPosition())) {
            snake.grow();
            food.respawn(board.getWidth(), board.getHeight());
        }
    }
    //Restart
    private void resetGame() {
        snake = new Snake(new Point(10, 10));
        food.respawn(board.getWidth(), board.getHeight());
        running = true;
        timer.restart();
    }



    //Vẽ các thành phần của game
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ mồi
        g.setColor(Color.RED);
        Point f = food.getPosition();
        g.fillRect(f.x * TILE_SIZE, f.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Vẽ rắn
        g.setColor(Color.magenta);
        for (Point p : snake.getBody()) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Game over
        if (!running) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Ga Vaii!", getWidth() / 2 - 40, getHeight() / 2 - 10);
            g.setColor(Color.RED);
            g.drawString("Press SPACE to Restart", getWidth() / 2 - 70, getHeight() / 2 + 20);
        }
    }
    


    //Các phím điểu khiển
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
            case KeyEvent.VK_SPACE -> {
                if (!running) resetGame();  // Chỉ cho restart nếu đang Game Over
            }
        }
    }

    
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
