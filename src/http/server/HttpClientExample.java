package http.server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://localhost:7777"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response1 = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response2 = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response3 = client.send(request, HttpResponse.BodyHandlers.ofString());

        Map<String, List<String>> headers = response3.headers().map();
        System.out.println(headers);

        String body = response3.body();
        System.out.println(body);
    }
}
