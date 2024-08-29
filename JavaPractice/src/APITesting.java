/**
 * @author divyesh.shah
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class APITesting {

    public static void main(String[] args) {
        try {
            // Example of a GET request
            //URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts/1");
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println("GET Response Content :: " + content.toString());

            // Custom assertion to check the response
            assert responseCode == 200 : "Failed: GET request not successful!";
            assert content.toString().contains("\"id\": 1") : "Failed: Response content is incorrect!";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
