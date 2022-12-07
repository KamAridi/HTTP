package tcp.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket server = new DatagramSocket(9999)) {
            byte[] bytes = new byte[512];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            server.receive(packet);
            System.out.println(new String(bytes));
        }
    }
}
