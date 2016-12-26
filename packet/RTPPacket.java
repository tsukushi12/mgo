package packet;

import java.io.*;
import java.net.*;

public class RTPPacket{
//@@
    static short sequenceNum;
    static int timeStamp;
    static int syncSourceId;
    static byte marker;
//@
    byte rtpHeader[] = new byte[12];
    byte version     = -128;
    byte padding     = 0;
    byte extention   = 0;
    byte contribute  = 0;
    byte payload     = 0;
    ByteArrayOutputStream out;

    public RTPPacket(byte audioPacket[]){
        rtpHeader[0] = (byte)(version | padding | extention | contribute);
        rtpHeader[1]  = (byte)(marker | payload);
        rtpHeader[2]  = (byte)(sequenceNum >> 8);
        rtpHeader[3]  = (byte)(sequenceNum >> 0);
        rtpHeader[4]  = (byte)(timeStamp >> 24);
        rtpHeader[5]  = (byte)(timeStamp >> 16);
        rtpHeader[6]  = (byte)(timeStamp >>  8);
        rtpHeader[7]  = (byte)(timeStamp >>  0);
        rtpHeader[8]  = (byte)(syncSourceId >> 24);
        rtpHeader[9]  = (byte)(syncSourceId >> 16);
        rtpHeader[10] = (byte)(syncSourceId >>  8);
        rtpHeader[11] = (byte)(syncSourceId >>  0);

        sequenceNum ++;
        timeStamp += 160;
        if(marker == -128)
            marker = 0;

        out = new ByteArrayOutputStream(12 + audioPacket.length);
        out.write(rtpHeader, 0, 12);
        out.write(audioPacket, 0, audioPacket.length);
    }
    public byte[] getRTP(){
        return out.toByteArray();
    }
    public DatagramPacket getRTP(InetSocketAddress destAddr){
        byte rtp[] = getRTP();
        return new DatagramPacket(rtp, rtp.length, destAddr);
    }
}