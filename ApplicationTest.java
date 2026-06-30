import java.net.HttpURLConnection;
import java.net.URL;

public class ApplicationTest {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);

            int code = conn.getResponseCode();

            if (code == 200) {
                System.out.println("✅ TEST PASSED: Application is running (HTTP 200)");
            } else {
                System.out.println("❌ TEST FAILED: Response code = " + code);
            }

            conn.disconnect();

        } catch (Exception e) {
            System.out.println("❌ TEST FAILED: Server not reachable");
            e.printStackTrace();
        }
    }
}
