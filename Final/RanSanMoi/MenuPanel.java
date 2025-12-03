package ransanmoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {

    private MainFrame frame;

    private JLabel start;
    private JLabel exit;

    public MenuPanel(MainFrame frame) {
        this.frame = frame;

        setLayout(null); // để tự đặt vị trí hình ảnh theo toạ độ
        setFocusable(true);

        // ======= TẢI ẢNH =========
        Image startImg = ImageAssets.start;   // bạn cần tạo biến này trong ImageAssets
        Image exitImg  = ImageAssets.exit;    // tương tự

        // ======= TẠO ẢNH =========
        start = new JLabel(new ImageIcon(startImg));
        exit  = new JLabel(new ImageIcon(exitImg));

        // ======= ĐẶT VỊ TRÍ NÚT TRÊN MÀN HÌNH =========
        start.setBounds(375, 400, startImg.getWidth(null), startImg.getHeight(null));
        exit.setBounds(375, 600, exitImg.getWidth(null), exitImg.getHeight(null));

        // ======= THÊM SỰ KIỆN CLICK =========
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                frame.showDifficulty();
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound.play("/ransanmoi/assets/musics/clicks.wav");
                System.exit(0);
            }
        });

        
        add(start);
        add(exit);
    }

    // ======= VẼ BACKGROUND =========
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageAssets.Menu, 0, 0, getWidth(), getHeight(), null);
    }
}
