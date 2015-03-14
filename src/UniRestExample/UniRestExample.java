//http://unirest.io/java.html
package UniRestExample;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class UniRestExample
{
	public static void main(String args[])
	{
		GetRequest request = Unirest.get("http://jsonplaceholder.typicode.com/posts/1");
		try {
			HttpResponse<JsonNode> request2 = Unirest.post("http://httpbin.org/post").queryString("name","mark").field("last", "polo").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}