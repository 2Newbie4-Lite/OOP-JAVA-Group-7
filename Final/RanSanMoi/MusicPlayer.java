package ransanmoi;

import javax.sound.sampled.*;
import java.net.URL;

public class MusicPlayer {

    private static Clip clip;

    public static void playLoop(String path) {
        stop();

        try {
            URL url = MusicPlayer.class.getResource(path);

            if (url == null) {
                System.out.println("Không tìm thấy file: " + path);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }
}
