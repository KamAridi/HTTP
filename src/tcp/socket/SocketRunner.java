package tcp.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        InetAddress address = Inet4Address.getByName("localhost");
        try (Socket socket = new Socket(address, 9999);
             DataOutputStream request = new DataOutputStream(socket.getOutputStream());
             DataInputStream response = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()){
                String scanString = scanner.nextLine();

                request.writeUTF(scanString);

                String responseServer = response.readUTF();
                System.out.println(responseServer);
            }
        }
    }
}
