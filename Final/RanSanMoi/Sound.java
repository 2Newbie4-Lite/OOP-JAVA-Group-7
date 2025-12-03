package ransanmoi;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {

    public static void play(String resourcePath) {
        try {
            URL url = Sound.class.getResource(resourcePath);

            if (url == null) {
                System.out.println("Không tìm thấy âm thanh: " + resourcePath);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();     
            clip.open(audio);
            clip.start();                           // phát một lần
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
