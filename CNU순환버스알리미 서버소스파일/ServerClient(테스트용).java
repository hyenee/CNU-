package cnu_bus;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;

public class ServerClient {
   public static void main(String[] args) throws Exception {
     MulticastSocket ms = null;
	 // ServerSocket ms = null;
      InetAddress ma = null;
      while (true) {
         byte[] b = new byte[255];
         ms = new MulticastSocket(1200);
        // ms = new ServerSocket(1200);
        ms.setTimeToLive(64);;
         ma = InetAddress.getByName("224.0.0.2");
         ms.joinGroup(ma);
         
         DatagramPacket dp = new DatagramPacket(b, b.length);
         ms.receive(dp);
         
         String msg = new String(dp.getData());
         msg = msg.trim();
         System.out.println(msg);

         ms.leaveGroup(ma);
         ms.close();
      }

   }
}