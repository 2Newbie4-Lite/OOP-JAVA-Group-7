package ransanmoi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import ransanmoi.Snake.Direction;

public class Game extends JPanel implements ActionListener, KeyListener {
    private Score score;

    private MainFrame frame;

    private final int tile = 20;
    
    private final GameBoard board;
    private Snake snake;
    
    private Food food;
    private Food food2;
    private Food food3;
    private Image foodImg;

    



    private boolean running = true;
    private Timer timer;

    private GameConfig config;
    
    

    public Game(GameConfig config, MainFrame frame) {
        
        this.frame = frame;
        this.config = config;

        board = new GameBoard(60, 45);

        // SỬA LỖI: spawn rắn phải nằm trong bản đồ
        snake = new Snake(new Point(20, 44));
        
        //score
        score = new Score();
        score.setRequiredScore(config.scoreToWin);
        
        food = new Food(board.getWidth(), board.getHeight());
        food2 = new Food(board.getWidth(), board.getHeight());
        food3 = new Food(board.getWidth(), board.getHeight());
        
        

        switch (config.foodImage) {
            case 1 ->
                this.foodImg = ImageAssets.food1;
            case 2 ->
                this.foodImg = ImageAssets.food2;
            case 3 ->
                this.foodImg = ImageAssets.food3;
            
        }                        
                
        // Tạo list tile của obstacle
        food.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
        food2.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
        food3.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
        // Respawn lần đầu để đảm bảo KHÔNG null và không dính obstacle
        food.respawn(
                board.getWidth(),
                board.getHeight(),
                config.obstaclesList,
                snake
        );
        food2.respawn(
                board.getWidth(),
                board.getHeight(),
                config.obstaclesList,
                snake
        );
        food3.respawn(
                board.getWidth(),
                board.getHeight(),
                config.obstaclesList,
                snake
        );

        
        

        timer = new Timer(config.speed, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);

        SwingUtilities.invokeLater(() -> requestFocusInWindow());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) update();
        repaint();
    }

    private void update() {
        
        // Tính vị trí đầu mới
        Point nextHead = new Point(snake.getHead());
        switch (snake.getDirection()) {
            case UP -> nextHead.y--;
            case DOWN -> nextHead.y++;
            case LEFT -> nextHead.x--;
            case RIGHT -> nextHead.x++;
        }
        Rectangle headRect = new Rectangle(
                nextHead.x * tile,
                nextHead.y * tile,
                tile,
                tile
        );
        // Va vào thân
        if (snake.contains(nextHead)) {
            running = false;
            frame.showLose();
            return;
        }
        // Va vào obstacle
        if (config.obstaclesList != null) {
            for (Obstacle ob : config.obstaclesList) {
                if (headRect.intersects(ob.getBounds())) {
                    running = false;
                    frame.showLose();
                    return;
                }
            }
        }
        // Di chuyển
        snake.move(board.getWidth(), board.getHeight());
        // Ăn food
        
        if (snake.getHead().equals(food.getPosition())) {
            snake.grow();
            score.add(100);
            Sound.play(config.eatSound);

            if (score.hasReachedGoal()) {
                running = false;
                frame.showWin();
                return;
            }
                        // Chuyển obstacle -> tile position
            food.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
            food.respawn(
                    board.getWidth(),
                    board.getHeight(),
                    config.obstaclesList,
                    snake
            );

        }
        if (snake.getHead().equals(food2.getPosition())) {
            snake.grow();
            score.add(100);
            Sound.play(config.eatSound);

            if (score.hasReachedGoal()) {
                running = false;
                frame.showWin();
                return;
            }
            // Chuyển obstacle -> tile position
            food2.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
            food2.respawn(
                    board.getWidth(),
                    board.getHeight(),
                    config.obstaclesList,
                    snake
            );

        }
        if (snake.getHead().equals(food3.getPosition())) {
            snake.grow();
            score.add(100);
            Sound.play(config.eatSound);

            if (score.hasReachedGoal()) {
                running = false;
                frame.showWin();
                return;
            }
            // Chuyển obstacle -> tile position
            food3.respawn(board.getWidth(), board.getHeight(), config.obstaclesList, snake);
            food3.respawn(
                    board.getWidth(),
                    board.getHeight(),
                    config.obstaclesList,
                    snake
            );

        }
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ background
        g.drawImage(config.background, 0, 0, getWidth(), getHeight(), null);
        
        // Vẽ obstacle
        if (config.obstaclesList != null) {
            for (Obstacle ob : config.obstaclesList) {
                ob.draw(g);
            }
        }
        // Vẽ food
        Point f1 = food.getPosition();
        g.drawImage(foodImg, f1.x * tile, f1.y * tile, tile, tile, null);

        Point f2 = food2.getPosition();
        g.drawImage(foodImg, f2.x * tile, f2.y * tile, tile, tile, null);

        Point f3 = food3.getPosition();
        g.drawImage(foodImg, f3.x * tile, f3.y * tile, tile, tile, null);

        // Vẽ rắn
        Point head = snake.getHead();
        Image headImg = config.Headd;  ;

        switch (snake.getDirection()) {
            case UP ->
                headImg = config.Headw;
            case DOWN ->
                headImg = config.Heads;
            case LEFT ->
                headImg = config.Heada;
            case RIGHT ->
                headImg = config.Headd;
        }

        g.drawImage(headImg, head.x * tile, head.y * tile, tile, tile, null);

        java.util.List<Point> body = snake.getBody();
        for (int i = 1; i < body.size(); i++) {
            Point p = body.get(i);

            g.drawImage(config.Body,
                    p.x * tile, p.y * tile,
                    tile, tile,
                    null);
        }//Score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + score.getCurrentScore(), 20, 19);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W,KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_S,KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_A,KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

}
