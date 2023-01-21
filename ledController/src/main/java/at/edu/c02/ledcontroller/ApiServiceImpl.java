package at.edu.c02.ledcontroller;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class should handle all HTTP communication with the server.
 * Each method here should correspond to an API call, accept the correct parameters and return the response.
 * Do not implement any other logic here - the ApiService will be mocked to unit test the logic without needing a server.
 */
public class ApiServiceImpl implements ApiService {
    private static String _secret;
    public ApiServiceImpl() {
        _secret =loadSecretFromFile();
    }

    /**
     * This method calls the `GET /getLights` endpoint and returns the response.
     * TODO: When adding additional API calls, refactor this method. Extract/Create at least one private method that
     * handles the API call + JSON conversion (so that you do not have duplicate code across multiple API calls)
     *
     * @return `getLights` response JSON object
     * @throws IOException Throws if the request could not be completed successfully
     */
    @Override
    public JSONObject getLights() throws IOException
    {
        return getJsonObject();
    }


    @Override
    public JSONObject getLights(int id) throws IOException
    {
        return getJsonObject().getJSONArray("lights").getJSONObject(id);
    }

    private JSONObject getJsonObject() throws IOException {
        // Connect to the server
        URL url = new URL("https://balanced-civet-91.hasura.app/api/rest/getLights");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // and send a GET request
        connection.setRequestMethod("GET");

        connection.setRequestProperty("X-Hasura-Group-ID", "3b0c44298fc1c149afbf4c8996fb9");
        connection.setRequestProperty("X-Hasura-Group-ID", _secret);

        // Read the response code
        int responseCode = connection.getResponseCode();
        if(responseCode != HttpURLConnection.HTTP_OK) {
            // Something went wrong with the request
            throw new IOException("Error: getLights request failed with response code " + responseCode);
        }

        // The request was successful, read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        // Save the response in this StringBuilder
        StringBuilder sb = new StringBuilder();

        int character;
        // Read the response, character by character. The response ends when we read -1.
        while((character = reader.read()) != -1) {
            sb.append((char) character);
        }

        String jsonText = sb.toString();
        // Convert response into a json object
        return new JSONObject(jsonText);
    }

    public JSONObject setLight(int id, String color, boolean state) throws IOException{
        // Connect to the server
        URL url = new URL("https://balanced-civet-91.hasura.app/api/rest/setLight");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // and send a POST request
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("X-Hasura-Group-ID", _secret);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        connection.setDoOutput(true);
        String jsonInputString =
                "{"
                        + "      \"id\": " + id +  " ,"
                        + "      \"color\": \" "+ color +" \","
                        + "      \"state\" : "+ state
                        + "}";

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        return null;
    }

    private String loadSecretFromFile() {
        String secret="";
        try{
            BufferedReader br= new BufferedReader(new FileReader("secret.txt"));
            secret = br.readLine();

        }
        catch (FileNotFoundException e) {
            System.out.println("Error loading secret");
        } catch (IOException e) {
            System.out.println("Error loading secret");
        }
        System.out.println(secret);
        return secret;
    }
}
