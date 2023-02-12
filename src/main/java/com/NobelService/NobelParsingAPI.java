package com.NobelService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser; 

public class NobelParsingAPI {
	
	public static Map<String, Integer> recieveNobelInfo(URL lauriateURL) throws IOException {
		try {
			//Create the return variable
			Map<String, Integer> nobelParsed = new HashMap<String, Integer>();
			
			//Find the API, the longest part of the process
			long start = System.currentTimeMillis();
			HttpURLConnection conn = (HttpURLConnection) lauriateURL.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			if (conn.getResponseCode() != 200) {
			    throw new RuntimeException("HttpResponseCode: " + conn.getResponseCode());
			} 
			else {
				System.out.println("Connected, and found document!");
				String jsonBuilder = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(lauriateURL.openStream()));
				long end = System.currentTimeMillis();
				System.out.println("API Connected and Opened: " + (end-start) + "ms.");
				String input;

				//Parsing the JSON we get from the API
				start = System.currentTimeMillis();
				while((input = reader.readLine()) != null) {
					jsonBuilder += input;
				}
				reader.close();
				end = System.currentTimeMillis();
				System.out.println("Json Scan Finished: " + (end-start) + "ms.");
				
				//We parse the JSON, and dump the metadata that is unnecessary for our purposes, as well as making it a lot easier to iterate through
				start = System.currentTimeMillis();
				JsonObject jsonObject = JsonParser.parseString(jsonBuilder).getAsJsonObject();
				JsonArray groupObject = jsonObject.getAsJsonArray("laureates");
				
				//Working through the newly created JSON, filtering out the metadata and extras at the bottom
				for(int i = 0; i < groupObject.size(); i++) {
					JsonObject current = (JsonObject) groupObject.get(i);
					
					//ensure that our data actually has the place of birth to check country for
					if(current.has("birth") && current.getAsJsonObject("birth").has("place")) {
						String currentLaureateCountry = current.getAsJsonObject("birth")
								.getAsJsonObject("place")
								.getAsJsonObject("country")
								.getAsJsonPrimitive("en")
								.getAsString();
						
						//Map countries (place of birth) to the map, and add + 1 if we find a duplicate country name
						if(currentLaureateCountry != null) {
							if(nobelParsed.containsKey(currentLaureateCountry)) {
								nobelParsed.put(currentLaureateCountry, nobelParsed.get(currentLaureateCountry)+1);
							}
							else {
								nobelParsed.put(currentLaureateCountry, 1);
							}
						}
					}
				}
				end = System.currentTimeMillis();
				System.out.println("Mapping Finished: " + (end-start) + "ms.");
			}
			return nobelParsed;
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}
