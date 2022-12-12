package http.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class HttpServer {
    private final ServerSocket server;
    private final ExecutorService pool;

    public HttpServer(int port, ExecutorService pool) {
        try {
            this.pool= pool;
            server = new ServerSocket(port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        pool.submit(() -> {
            try {
                responseMaker();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void responseMaker() throws RuntimeException, InterruptedException {
        File file = new File("C:\\Users\\Kam\\Desktop\\Github\\HTTP\\resources\\example.html");
        Thread.sleep(10000);

        try (Socket socket = server.accept();
             DataInputStream request = new DataInputStream(socket.getInputStream());
             DataOutputStream response = new DataOutputStream(socket.getOutputStream());
             FileInputStream fileInputStream = new FileInputStream(file)
        ) {
            byte[] body = fileInputStream.readAllBytes();
            byte[] headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();

            response.write(headers);
            response.write(System.lineSeparator().getBytes());
            response.write(body);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
