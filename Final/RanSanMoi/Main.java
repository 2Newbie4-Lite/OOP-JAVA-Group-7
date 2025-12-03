package ransanmoi;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            mf.showMenu();
            MusicPlayer.playLoop("/ransanmoi/assets/musics/menu.wav");
            mf.setVisible(true);
        });
    }

}
