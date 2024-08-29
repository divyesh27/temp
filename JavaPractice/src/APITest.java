/**
 * @author divyesh.shah
 */
import java.net.URI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class APITest {

    public static class HttpClientService {
        public String sendGetRequest(URI uri) throws Exception {
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        }

        public String sendPostRequest(URI uri, String jsonBody) throws Exception {
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        }
    }
    public static class ApiTest {
        private final HttpClientService httpClientService;

        public ApiTest(HttpClientService httpClientService) {
            this.httpClientService = httpClientService;
        }

        public void runTests() throws Exception {
            testGetRequestPositive();
            testGetRequestNegative();
            testPostRequestPositive();
            testPostRequestNegative();
            // Add more tests as needed
        }

        private void testGetRequestPositive() throws Exception {
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts/1");
            String response = httpClientService.sendGetRequest(uri);
            assert response.contains("userId") : "Expected response body to contain 'userId'";
            System.out.println("GET Positive Case Passed");
        }

        private void testGetRequestNegative() throws Exception {
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts/invalid");
            try {
                httpClientService.sendGetRequest(uri);
                assert false : "Expected an exception for invalid URL";
            } catch (Exception e) {
                System.out.println("GET Negative Case Passed");
            }
        }

        private void testPostRequestPositive() throws Exception {
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts");
            String jsonBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";
            String response = httpClientService.sendPostRequest(uri, jsonBody);
            assert response.contains("\"id\":") : "Expected response body to contain 'id'";
            System.out.println("POST Positive Case Passed");
        }

        private void testPostRequestNegative() throws Exception {
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts");
            String jsonBody = "{ \"title\": \"\", \"body\": \"\", \"userId\": -1 }";
            try {
                httpClientService.sendPostRequest(uri, jsonBody);
                assert false : "Expected an exception for invalid POST data";
            } catch (Exception e) {
                System.out.println("POST Negative Case Passed");
            }
        }
    }
    public static void main(String[] args) {
        try {
            HttpClientService httpClientService = new HttpClientService();
            ApiTest apiTest = new ApiTest(httpClientService);
            apiTest.runTests();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


