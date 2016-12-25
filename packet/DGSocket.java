package packet;
import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
import RTPPacket;
import java.io.*;
public class DGSocket {
    String destIP;
    int destPort;
    DatagramSocket scok;
    InetSocketAddress destAddr;
    DatagramPacket packet;
     Sender(String ip, int port){
         destIP = ip;
         destPort = port;
         sock = new DatagramSocket();
         destAddr = new InetSocketAddress(destIP, destPort);
     }
     public boolean send(String msg){
         
     }
     public void sendRTP(byte audioPacket[]){
         RTPPacket rtp = new RTPPacket(audioPacket);
         packet = packet.getRTP();
         socket.send(packet);
     }


     public void close(){
         socket.close();
     }
}