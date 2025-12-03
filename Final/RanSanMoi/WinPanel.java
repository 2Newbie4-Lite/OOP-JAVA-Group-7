package ransanmoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinPanel extends JPanel {

    private MainFrame frame;

    private JLabel restart;
    private JLabel menu;

    public WinPanel(MainFrame frame) {
        this.frame = frame;

        setLayout(null); 

        // ====== LOAD ẢNH ======
        Image restartImg = ImageAssets.restart; 
        Image menuImg    = ImageAssets.menu;     

        // ====== TẠO Ảnh ======
        restart = new JLabel(new ImageIcon(restartImg));
        menu    = new JLabel(new ImageIcon(menuImg));

        // ====== ĐẶT VỊ TRÍ ======
        restart.setBounds(
                400,
                450,
                restartImg.getWidth(null),
                restartImg.getHeight(null));

        menu.setBounds(
                400,
                600,
                menuImg.getWidth(null),
                menuImg.getHeight(null));

        // ====== clicks ======
        restart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.startGame(frame.getLastConfig());  
            }
        });

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                
                frame.showMenu();
                MusicPlayer.playLoop("/ransanmoi/assets/musics/menu.wav");
            }
        });

        // ====== THÊM COMPONENT ======
        add(restart);
        add(menu);
    }

    // ====== BACKGROUND ======
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageAssets.Win, 0, 0, getWidth(), getHeight(), null);
    }
}
