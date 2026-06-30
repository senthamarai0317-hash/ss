import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Application {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

        server.createContext("/", new MyHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:5000");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) {

            try {

                String response =
                        "<!DOCTYPE html>" +
                        "<html>" +
                        "<head><title>Java Server</title></head>" +
                        "<body style='font-family:Arial;text-align:center;margin-top:100px;'>" +
                        "<h1>🚀 Java Application Running</h1>" +
                        "<p>This is served by Application.java</p>" +
                        "</body>" +
                        "</html>";

                exchange.sendResponseHeaders(200, response.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
