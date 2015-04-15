//http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
package HttpURLConnectionExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String agrs[]) throws Exception {
		HttpURLConnectionExample http = new HttpURLConnectionExample();
		System.out.println("Send Get Request");
		http.sendGet();
	}

	private void sendGet() throws Exception {
		String url = "http://www.google.com/search?q=siva";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("Get Request" + url);
		System.out.println("Response code" + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
	}

}
