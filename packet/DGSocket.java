package packet;
import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
import packet.RTPPacket;
public class DGSocket {
    String destIP;
    int destPort;
    DatagramSocket sock;
    InetSocketAddress destAddr;
    DatagramPacket packet;
     public DGSocket(String ip, int port){
         try{
            destIP = ip;
            destPort = port;
            sock = new DatagramSocket();
            destAddr = new InetSocketAddress(destIP, destPort);
         }catch(Exception e){
            e.printStackTrace();
        }
     }
     public void send(String msg){
         
     }
     public void sendRTP(byte audioPacket[]){
         try{
            RTPPacket rtp = new RTPPacket(audioPacket);
            packet = rtp.getRTP(destAddr);
            sock.send(packet);
         }catch(Exception e){
            e.printStackTrace();
        }
     }


     public void close(){
         sock.close();
     }
}