import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
public class audioRecv {
    static final int recvPort = 10100;

    public static void main(String args[]){
        try{
            DatagramSocket socket = new DatagramSocket(recvPort, InetAddress.getLocalHost());
            byte buffer[] = new byte[172];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            AudioFormat format = new AudioFormat(44000, 16, 2, false, false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

            while(true){
                socket.receive(packet);
                System.out.println(packet);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}