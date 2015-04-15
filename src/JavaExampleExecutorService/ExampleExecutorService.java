package JavaExampleExecutorService;

//http://crunchify.com/how-to-run-multiple-threads-concurrently-in-java-executorservice-approach/

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleExecutorService {
	public static final int MYTHREADS = 30;

	public static void main(String args[]) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		String[] hostList = { "http://google.com", "http://google.co.in",
				"http://flipkart.com", "http://snapdeal.com", "http://ndtv.com" };
		for (int i = 0; i < hostList.length; i++) {
			String url = hostList[i];
			Runnable worker = new MyRunnable(url);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {

		}
		System.out.println("\n Finished all threads \n");
	}

	public static class MyRunnable implements Runnable {
		private final String url;

		MyRunnable(String url) {
			this.url = url;
		}

		public void run() {
			String result = "";
			int code = 200;
			try {
				URL siteURL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) siteURL
						.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				code = connection.getResponseCode();
				if (code == 200) {
					result = "Green\n";
				}
			} catch (Exception Ex) {
				result = "red";
			}
			System.out.println("Result is " + result);
		}
	}
}
