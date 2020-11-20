import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class connect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BAY_SHIPNODES.csv"));
        String stringUrl = "https://api.agify.io?name=bella";
        
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            System.out.println("Problem building the URL");
        }

        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);         //Use Buffered Reader to parse the input stream
        } catch (IOException e) {
            System.out.println("Unable to connect");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        System.out.println(jsonResponse);
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}