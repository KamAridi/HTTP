package http.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerRunner {
    public static void main(String[] args)  {
        try (ExecutorService pool = Executors.newFixedThreadPool(100)) {
            HttpServer httpServer = new HttpServer(7777, pool);
            httpServer.run();
        }
    }
}
