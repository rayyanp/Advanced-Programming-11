package uk.ac.mmu.advproglab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class HygieneServiceClient {
	
	public static void main(String[] args) {
		
		retrieveRatings("SW1A 1");
	}

	public static String retrieveRatings(String postcode) {
		
		String param = URLEncoder.encode(postcode,Charset.defaultCharset());
		
		String request_url = "http://sandbox.kriswelsh.com/hygieneapi/hygiene.php?op=search_postcode&postcode=" + param;
		
		
		try {
			
			URLConnection connection = new URL(request_url).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String data = "", line = "";
			while ((line = reader.readLine()) != null) {
				data = data + line;
			}
			
			JSONArray ja = new JSONArray(data);
			StringBuilder output = new StringBuilder();;
			for(int i=0;i<ja.length();i++) {
				JSONObject business = ja.getJSONObject(i);
				output.append(business.getString("BusinessName") + ": " + business.getString("RatingValue") + ": " + business.getString("RatingDate") + "\n");
			}
			return output.toString();			
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
			return ioe.getMessage();
		}
	}

}