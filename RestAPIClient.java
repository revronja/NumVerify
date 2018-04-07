
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
//import java.util.Scanner;

public class RestAPIClient {
	 public String number;
	 public String carrier;
		
	
	//public String setConfig() {

	//Config newconf = new Config();
	//apikey = newconf.api_key;
	//return apikey;
	
	//}
	
	public HttpURLConnection sendGet(String phonenum) throws Exception{
		
		Config conf = new Config();
		String ak = conf.getVirusTotalAPIKey();
		
	    String url1 = "http://apilayer.net/api/validate?access_key=";
	    String url2 = "&number=" + phonenum;
		//String url2 = "&number=14158586273";
		String url = url1 + ak + url2;
		
		//Scanner reader = new Scanner(System.in);
		//System.out.println("Enter a phone number: ");
		//int num = reader.nextInt();
		//reader.close();
		
		//url = url + num;
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

		//print result
		//System.out.println(response.toString());
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
		
		//String valid = (String) jsonObject.get("valid");
		number = (String) jsonObject.get("number");
		//String number = (String) jsonObject.get("number");
		String countrycode = (String) jsonObject.get("country_code");
	    carrier  = (String) jsonObject.get("carrier");
		//System.out.println("valid : " + valid);
		System.out.println("number : " + number);
		System.out.println("countrycode : " + countrycode);
		System.out.println("carrier : " + carrier);
		 // get an array from the JSON object
		//JSONArray lang= (JSONArray) jsonObject.get("languages");


		return conn;
		// may want to return response object instead?
	}
	
	
	//public String setrespCarrier() {
		//String carrier;
		//return carrier;
	//}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpURLConnection conn = null;
		
		try {
			RestAPIClient client = new RestAPIClient();
			conn = client.sendGet("14158586273");
		} catch(Exception e) {
			System.out.println("Exception thrown: " + e);
		}
		finally {
			conn.disconnect();
		}
		
	}

}
