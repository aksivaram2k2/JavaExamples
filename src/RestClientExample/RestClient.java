//http://alvinalexander.com/java/java-apache-httpclient-restful-client-examples
package RestClientExample;
import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestClient
{
	public static void main(String args[])
	{
		HttpClient httpClient = new DefaultHttpClient();
		try
		{
			HttpGet httpGetRequest = new HttpGet("http://jsonplaceholder.typicode.com/posts/1");
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			System.out.println("=======================================================");
			System.out.println(httpResponse.getStatusLine());
			System.out.println("=======================================================");
			
			HttpEntity entity = httpResponse.getEntity();
			
			byte[] buffer = new byte[1024];
			
			if(entity!=null)
			{
				InputStream inputStream = entity.getContent();
				try
				{
					int bytesRead = 0;
					BufferedInputStream bis = new BufferedInputStream(inputStream);
					while((bytesRead = bis.read(buffer))!=-1)
					{
						String chunk = new String(buffer, 0, bytesRead);
						System.out.println(chunk);
					}
				}
				catch(Exception Ex)
				{
					
				}
				finally
				{
					try
					{
						inputStream.close();
					}
					catch(Exception Ex)
					{
						
					}
				}
			}
		}
		catch(Exception Ex)
		{
			
		}
	}
}
