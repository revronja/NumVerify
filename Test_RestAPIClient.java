
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;


public class Test_RestAPIClient {
	 public static String number;
	 public static String valid;
	 public static String localformat;
	 public static String intformat;
	 public static String carrier;
	 public static String countrycode;
	 public static String location;
	 public static String linetype;
	
	
	public void sendGet(String phonenum) throws Exception{
		Config conf = new Config();
		String ak = conf.getVirusTotalAPIKey();
	    String url1 = "http://apilayer.net/api/validate?access_key=";
	    String url2 = "&number=" + phonenum;
		String url = url1 + ak + url2;
		
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();
		System.out.println("Sending GET req to URL: " + url);
		System.out.println("Response Code: " + responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());

		 number = (String) jsonObject.get("number");
		 valid = (String) jsonObject.get("valid");
		 localformat = (String) jsonObject.get("local_format");
		 intformat = (String) jsonObject.get("international_format");
		 carrier  = (String) jsonObject.get("carrier");
		 countrycode = (String) jsonObject.get("country_code");
		 location = (String) jsonObject.get("location");
		 linetype = (String) jsonObject.get("line_type");
	
	    conn.disconnect();
	   
	}
	
	public static void main(String[] args) {
			Test_RestAPIClient client = new Test_RestAPIClient();
			try{
			     client.sendGet("14158586273");
			     System.out.println(client.valid);
			     System.out.println(client.number);
			     System.out.println(client.localformat);
			     System.out.println(client.intformat);
			     System.out.println(client.carrier);
			     System.out.println(client.countrycode);
			     System.out.println(client.location);
			     System.out.println(client.linetype);
			
		} catch (Exception e) {
			System.out.println(e + " was thrown.");
		}
			
	}
}


