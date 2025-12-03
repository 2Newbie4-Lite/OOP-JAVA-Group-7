package ransanmoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LosePanel extends JPanel {

    private MainFrame frame;

    private JLabel retry;
    private JLabel menu;

    public LosePanel(MainFrame frame) {
        this.frame = frame;

        setLayout(null); // cho phép đặt ảnh theo tọa độ
        setFocusable(true);

        // ====== TẢI ẢNH ======
        Image retryImg = ImageAssets.restart;   
        Image menuImg  = ImageAssets.menu;   

        // ====== TẠO ẢNH ======
        retry = new JLabel(new ImageIcon(retryImg));
        menu  = new JLabel(new ImageIcon(menuImg));

        // ====== ĐẶT VỊ TRÍ ======
        retry.setBounds(
                400,
                450,
                retryImg.getWidth(null),
                retryImg.getHeight(null));

        menu.setBounds(
                400,
                600,
                menuImg.getWidth(null),
                menuImg.getHeight(null));

        // ====== CLICK ======
        retry.addMouseListener(new MouseAdapter() {
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

        
        add(retry);
        add(menu);
    }

    // ====== VẼ BACKGROUND ======
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageAssets.Lose, 0, 0, getWidth(), getHeight(), null);
    }
}
