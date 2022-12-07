package tcp.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9999);
             Socket socket = server.accept();
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            String request = dataInputStream.readUTF();
            while (true) {
                System.out.println("Request from client: " + request);
                dataOutputStream.writeUTF("Confirmed");
                request = dataInputStream.readUTF();
            }
        }
    }
}
