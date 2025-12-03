package ransanmoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DifficultyPanel extends JPanel {

    private MainFrame frame;

    private JLabel choose1;
    private JLabel choose2;
    private JLabel choose3;
    private JLabel back;

    public DifficultyPanel(MainFrame frame) {
        this.frame = frame;

        setLayout(null); // cho phép đặt ảnh tùy toạ độ

        // ======= LOAD ẢNH =======
        Image img1 = ImageAssets.choose1;
        Image img2 = ImageAssets.choose2;
        Image img3 = ImageAssets.choose3;
        Image imgBack = ImageAssets.back;

        // ======= TẠO Ô CHỌN TỪ ẢNH =======
        choose1 = new JLabel(new ImageIcon(img1));
        choose2 = new JLabel(new ImageIcon(img2));
        choose3 = new JLabel(new ImageIcon(img3));
        back    = new JLabel(new ImageIcon(imgBack));

        // ====== ĐẶT VỊ TRÍ ======
        
        choose1.setBounds(200, 350, img1.getWidth(null), img1.getHeight(null));
        choose2.setBounds(500, 350, img2.getWidth(null), img2.getHeight(null));
        choose3.setBounds(800, 350, img3.getWidth(null), img3.getHeight(null));

        back.setBounds(20, 20, imgBack.getWidth(null), imgBack.getHeight(null));

        // ====== Click ======
        choose1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.startGame(GameConfig.easy());
            }
        });

        choose2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.startGame(GameConfig.normal());
            }
        });

        choose3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.startGame(GameConfig.hard());
            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.showMenu();
            }
        });

        
        add(choose1);
        add(choose2);
        add(choose3);
        add(back);
    }

    // ====== VẼ BACKGROUND ======
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageAssets.Difficulty, 0, 0, getWidth(), getHeight(), null);
    }
}
