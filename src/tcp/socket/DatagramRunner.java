package tcp.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] bytes = "Hello mr Peter".getBytes();
            InetAddress address = Inet4Address.getByName("localhost");
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,address,9999 );
            datagramSocket.send(datagramPacket);
        }
    }
}
