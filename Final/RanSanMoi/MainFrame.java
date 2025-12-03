package ransanmoi;

import javax.swing.*;

public class MainFrame extends JFrame {
    
    private GameConfig lastConfig;  // map hiện tại


    public MainFrame() {

        setTitle("Snake Game");
        setSize(1217, 940);  // kích thước cố định 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
       
    }public void showMenu() {
        
        setContentPane(new MenuPanel(this));
        revalidate();
        repaint();
        
    }

    public void showDifficulty() {
        setContentPane(new DifficultyPanel(this));
        revalidate();
        repaint();
    }

    public void startGame(GameConfig config) {
        MusicPlayer.stop();
        this.lastConfig=config;
        switch (config.id) {
            case 1 ->
                MusicPlayer.playLoop("/ransanmoi/assets/musics/map1.wav");
            case 2 ->
                MusicPlayer.playLoop("/ransanmoi/assets/musics/map02.WAV");
            case 3 ->
                MusicPlayer.playLoop("/ransanmoi/assets/musics/map03.WAV");
            
        }
        Game g = new Game(config, this);
        setContentPane(g);
        revalidate();
        repaint();

        g.requestFocusInWindow();    //sửa lỗi Game bị phải click lại màn hình mới chạy
    }

    public void showWin() {
        MusicPlayer.stop();
        Sound.play("/ransanmoi/assets/musics/win.wav");
        setContentPane(new WinPanel(this));
        revalidate();
        repaint();
    }

    public void showLose() {
        MusicPlayer.stop();
        Sound.play("/ransanmoi/assets/musics/loses.wav");
        setContentPane(new LosePanel(this));
        revalidate();
        repaint();
    }
    
    public GameConfig getLastConfig() {
        return lastConfig;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
        });
    }
}
