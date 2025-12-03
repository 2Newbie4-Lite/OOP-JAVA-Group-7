package ransanmoi;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

public class GameConfig {

    // ====== Thông số cơ bản của map ======
    public int foodImage;
    public int id;
    public int mapWidth;         // số ô ngang
    public int mapHeight;        // số ô dọc
    public int speed;            // tốc độ game (ms của Timer)
    public int scoreToWin;       // điểm cần đạt
    public String eatSound;   // đường dẫn âm thanh khi ăn food
    //==== Rắn ===
    public Image Headw, Heads, Heada, Headd;
    public Image Body;


    // ====== Điểm để qua màn ======
    public Point goalPoint;      

    // ====== Danh sách vật cản (toạ độ tile) ======
    public List<Obstacle> obstaclesList;
    // ====== Hình nền map ======
    public Image background;
   
    
    

    // ====== Constructor rỗng ======
    public GameConfig() {
        
    }

    // ====== Static config cho từng map  ======
    public static GameConfig easy() {
        GameConfig cfg = new GameConfig();
        cfg.id=1;
        cfg.foodImage=1;
        cfg.eatSound = "/ransanmoi/assets/musics/food01.wav";

        cfg.mapWidth = 60;
        cfg.mapHeight = 45;
        cfg.speed = 100;
        cfg.background=ImageAssets.Easy;
        
        cfg.Headw = ImageAssets.Head1w;
        cfg.Heads = ImageAssets.Head1s;
        cfg.Heada = ImageAssets.Head1a;
        cfg.Headd = ImageAssets.Head1d;
        cfg.Body = ImageAssets.Body1;
        
        cfg.scoreToWin = 1000;
        
        cfg.obstaclesList = List.of(
                new Obstacle(ImageAssets.obstacle1, new Point(7, 7), 20),
                new Obstacle(ImageAssets.obstacle1, new Point(43, 7), 20),
                new Obstacle(ImageAssets.obstacle1, new Point(7, 28), 20),
                new Obstacle(ImageAssets.obstacle1, new Point(43, 28), 20)
        );

        return cfg;
    }



    public static GameConfig normal() {
        GameConfig cfg = new GameConfig();
        cfg.id=2;
        cfg.foodImage=2;
        cfg.eatSound = "/ransanmoi/assets/musics/food2.wav";
        cfg.mapWidth =60;
        cfg.mapHeight = 45;
        cfg.speed = 150;
        cfg.background=ImageAssets.Normal;
        
        cfg.Headw = ImageAssets.Head2w;
        cfg.Heads = ImageAssets.Head2s;
        cfg.Heada = ImageAssets.Head2a;
        cfg.Headd = ImageAssets.Head2d;
        cfg.Body = ImageAssets.Body2;


        cfg.scoreToWin = 1500;

        

        cfg.obstaclesList = List.of(
                new Obstacle(ImageAssets.Wall1, new Point(0, 0), 20),
                new Obstacle(ImageAssets.Wall2, new Point(0, 0), 20),
                new Obstacle(ImageAssets.Wall2, new Point(59, 0), 20),
                new Obstacle(ImageAssets.Wall3, new Point(1, 20), 20),
                new Obstacle(ImageAssets.Wall3, new Point(1, 43), 20),
                new Obstacle(ImageAssets.Wall3, new Point(37, 20), 20),
                new Obstacle(ImageAssets.Wall3, new Point(37, 43), 20),
                new Obstacle(ImageAssets.Wall4, new Point(22, 1), 20),
                new Obstacle(ImageAssets.Wall4, new Point(37, 1), 20),
                new Obstacle(ImageAssets.Wall5, new Point(22, 15), 20),
                new Obstacle(ImageAssets.Wall5, new Point(22, 20), 20),
                new Obstacle(ImageAssets.Wall5, new Point(37, 15), 20),
                new Obstacle(ImageAssets.Wall5, new Point(37, 20), 20),
                new Obstacle(ImageAssets.Wall4, new Point(22, 35), 20),
                new Obstacle(ImageAssets.Wall4, new Point(37, 35), 20),
                
                new Obstacle(ImageAssets.Sofa1, new Point(4, 34), 20),
                new Obstacle(ImageAssets.Sofa3, new Point(16, 34), 20),
                new Obstacle(ImageAssets.Sofa2, new Point(4, 38), 20),
                new Obstacle(ImageAssets.TV, new Point(6, 22), 20),
                
                new Obstacle(ImageAssets.Table, new Point(44, 34), 20),
                new Obstacle(ImageAssets.Table2, new Point(46, 21), 20),
                new Obstacle(ImageAssets.Table3, new Point(56, 21), 20),
                new Obstacle(ImageAssets.Bed1, new Point(44, 12), 20),
                new Obstacle(ImageAssets.Bed1, new Point(44, 4), 20),
                new Obstacle(ImageAssets.Bed2, new Point(56, 9), 20),
                new Obstacle(ImageAssets.Box, new Point(4, 5), 20),
                new Obstacle(ImageAssets.Box, new Point(12, 5), 20)
                
                
                
        );

        return cfg;
    }

    public static GameConfig hard() {
        
        GameConfig cfg = new GameConfig();
        cfg.id=3;
        cfg.foodImage=3;
        cfg.eatSound = "/ransanmoi/assets/musics/food03.wav";
        cfg.mapWidth = 60;
        cfg.mapHeight = 45;
        cfg.speed = 75;
        
        cfg.background=ImageAssets.Hard;
        
        cfg.Headw = ImageAssets.Head3w;
        cfg.Heads = ImageAssets.Head3s;
        cfg.Heada = ImageAssets.Head3a;
        cfg.Headd = ImageAssets.Head3d;
        cfg.Body = ImageAssets.Body3;
        
        cfg.scoreToWin = 2000;

       

        cfg.obstaclesList = List.of(
                new Obstacle(ImageAssets.A1, new Point(16, 34), 20),
                new Obstacle(ImageAssets.A2, new Point(41, 19), 20),
                new Obstacle(ImageAssets.A3, new Point(38, 9), 20),
                new Obstacle(ImageAssets.HT1, new Point(9, 20), 20),
                new Obstacle(ImageAssets.HT2, new Point(23, 19), 20),
                new Obstacle(ImageAssets.VP1C, new Point(47, 35), 20),
                new Obstacle(ImageAssets.Xe, new Point(6, 27), 20),
                new Obstacle(ImageAssets.Ball, new Point(4, 20), 20),
                new Obstacle(ImageAssets.Ktx1, new Point(4, 4), 20),
                new Obstacle(ImageAssets.Ktx2, new Point(4, 11), 20),
                new Obstacle(ImageAssets.Can, new Point(23, 4), 20),
                new Obstacle(ImageAssets.Book, new Point(51, 9), 20)
                
        );

        return cfg;
    }
}
