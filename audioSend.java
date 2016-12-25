import packet.RTPPacket;
import packet.DGSocket;

public class audioSend{
    public static void main(String args){
        File audioFile = new File("musicbox.wav");
        AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = stream.getFormat();
    }
     private byte[] audioSplit(byte audioPacket){


     }
}