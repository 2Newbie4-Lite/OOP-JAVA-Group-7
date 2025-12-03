package ransanmoi;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageAssets {

    // ====== Background của các map ======
    public static Image Easy;
    public static Image Normal;
    public static Image Hard;

    // ====== Background của các màn hình ======
    public static Image Menu;
    public static Image Difficulty;
    public static Image Win;
    public static Image Lose;

    // ====== Snake ======
    // Snake 1
    public static Image Head1w, Head1s, Head1a, Head1d;
    public static Image Body1;

    // Snake 2
    public static Image Head2w, Head2s, Head2a, Head2d;
    public static Image Body2;

    // Snake 3
    public static Image Head3w, Head3s, Head3a, Head3d;
    public static Image Body3;


    // ====== Food ======
    public static Image food1;   
    public static Image food2,food3;  

    // ====== OBSTACLE của 3 map ======
    public static BufferedImage obstacle1;
    public static BufferedImage Wall1,Wall2,Wall3,Wall4,Wall5,Sofa1,Sofa2,Sofa3,TV,Table,Table2,Table3,Bed1,Bed2,Box;
    public static BufferedImage A1,A2,VP1C,Xe,HT1,HT2,Ball,Ktx1,Ktx2,Can,A3,Book;
    //====Nút====
    public static Image start;
    public static Image exit;
    public static Image choose2;
    public static Image choose1;
    public static Image choose3;
    public static Image back;
    public static Image restart;
    public static Image menu;
    

    // Static block: load ảnh ngay khi class được sử dụng lần đầu
    static {
        loadAssets();
    }

    // Load từng ảnh
    private static void loadAssets() {
        try {
            // ==== Background các map ====
            Easy = load("/ransanmoi/assets/images/Background1.png");
            Normal = load("/ransanmoi/assets/images/Background2.png");
            Hard = load("/ransanmoi/assets/images/Background3.png");

            // ==== Màn hình ====
            Menu = load("/ransanmoi/assets/images/Background.png");
            Difficulty = load("/ransanmoi/assets/images/Background.png");
            Win = load("/ransanmoi/assets/images/Win.png");
            Lose = load("/ransanmoi/assets/images/Lose.png");

            // ==== Snake ====
            
            Body1 = load("/ransanmoi/assets/images/Body.png");
            Head1w = load("/ransanmoi/assets/images/Head1w.png");
            Head1s = load("/ransanmoi/assets/images/Head1s.png");
            Head1a = load("/ransanmoi/assets/images/Head1a.png");
            Head1d = load("/ransanmoi/assets/images/Head1d.png");
            
            Body2 = load("/ransanmoi/assets/images/Body2.png");
            Head2w = load("/ransanmoi/assets/images/Head2w.png");
            Head2s = load("/ransanmoi/assets/images/Head2s.png");
            Head2a = load("/ransanmoi/assets/images/Head2a.png");
            Head2d = load("/ransanmoi/assets/images/Head2d.png");
            
            Body3 = load("/ransanmoi/assets/images/Body3.png");
            Head3w = load("/ransanmoi/assets/images/Head3w.png");
            Head3s = load("/ransanmoi/assets/images/Head3s.png");
            Head3a = load("/ransanmoi/assets/images/Head3a.png");
            Head3d = load("/ransanmoi/assets/images/Head3d.png");

            // ==== Food ====
            food1 = load("/ransanmoi/assets/images/Food.png");
            food2 = load("/ransanmoi/assets/images/Food2.png");
            food3 = load("/ransanmoi/assets/images/Food3.png");

            // ==== Map1 ====
            obstacle1 = (BufferedImage) loadBuffered("/ransanmoi/assets/images/Obstacle01.png");

            //===Nuts===
            start=load("/ransanmoi/assets/images/Start.png");
            exit=load("/ransanmoi/assets/images/Exit.png");
            choose1=load("/ransanmoi/assets/images/Choose1.png");
            choose2=load("/ransanmoi/assets/images/Choose2.png");
            choose3=load("/ransanmoi/assets/images/Choose3.png");
            back=load("/ransanmoi/assets/images/Back.png");
            restart=load("/ransanmoi/assets/images/Restart.png");
            menu=load("/ransanmoi/assets/images/Menu.png");
            
            //====Map2====
            Wall1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Wall01.png");
            Wall2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Wall02.png");
            Wall3= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Wall03.png");
            Wall4= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Wall04.png");
            Wall5= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Wall05.png");
            Sofa1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Sofa1.png");
            Sofa2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Sofa2.png");
            Sofa3= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Sofa3.png");
            TV= (BufferedImage) loadBuffered("/ransanmoi/assets/images/TV.png");
            Table= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Table.png");
            Table2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Table2.png");
            Table3= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Table3.png");
            Bed1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Bed1.png");
            Bed2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Bed2.png");
            Box= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Box.png");
            
            //==Map3==
            A1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/A1.png");
            A2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/A2.png");
            A3= (BufferedImage) loadBuffered("/ransanmoi/assets/images/A3.png");
            HT1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/HT1.png");
            HT2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/HT2.png");
            VP1C= (BufferedImage) loadBuffered("/ransanmoi/assets/images/VP1C.png");
            Xe= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Xe.png");
            Ball= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Ball.png");
            Ktx1= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Ktx.png");
            Ktx2= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Ktx.png");
            Can= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Can.png");
            Book= (BufferedImage) loadBuffered("/ransanmoi/assets/images/Book.png");
            
            
                                

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi load ảnh: " + e.getMessage());
        }
    }
    //Vẽ obstacle

    private static BufferedImage loadBuffered(String path) throws IOException {
        return ImageIO.read(ImageAssets.class.getResource(path));
    }
    // Hàm load ảnh chung
    private static Image load(String path) throws IOException {
        return ImageIO.read(ImageAssets.class.getResource(path));
    }
}
