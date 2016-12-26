import packet.RTPPacket;
import packet.DGSocket;
import java.io.*;
import javax.sound.sampled.*;
public class audioSend {
    public static void main(String args[]) {
        try {
            File audioFile = new File("musicbox.wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            byte buffer[] = new byte[1600];

            DGSocket sock = new DGSocket("192.168.0.3", 10100);
            while (true) {
                if (stream.read(buffer, 0, buffer.length) == -1)
                    break;
                sock.sendRTP(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void audioSplit(byte audioPacket) {

    }
}