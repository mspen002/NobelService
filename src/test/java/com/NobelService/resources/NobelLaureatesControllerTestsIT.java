package com.NobelService.resources;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.NobelService.NobelParsingAPI;

@SpringBootTest
@AutoConfigureMockMvc
public class NobelLaureatesControllerTestsIT {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	HttpURLConnection connection;

	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	private NobelParsingAPI parsingAPI = new NobelParsingAPI();

	@Test
	public void TestMappingSort() throws Exception {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("exampleData");
		Mockito.when(connection.getInputStream()).thenReturn(inputStream);
		Mockito.when(connection.getResponseCode()).thenReturn(200);
		mvc.perform(MockMvcRequestBuilders.get("/laureate-count").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[ {\r\n  \"country\" : \"USA\",\r\n  \"count\" : 4\r\n}, {\r\n  \"country\" : \"Japan\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Prussia\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"India\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Germany\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Argentina\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Egypt\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"British Mandate of Palestine\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"United Kingdom\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"British Protectorate of Palestine\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"New Zealand\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Belgium\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"French Algeria\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Denmark\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Lithuania\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"France\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Ethiopia\",\r\n  \"count\" : 1\r\n} ]")));
	}
	
	@Test
	public void TestMappingSortFull() throws Exception {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("exampleDataFull");
		Mockito.when(connection.getInputStream()).thenReturn(inputStream);
		Mockito.when(connection.getResponseCode()).thenReturn(200);
		mvc.perform(MockMvcRequestBuilders.get("/laureate-count-full").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[ {\r\n  \"country\" : \"USA\",\r\n  \"count\" : 286\r\n}, {\r\n  \"country\" : \"United Kingdom\",\r\n  \"count\" : 89\r\n}, {\r\n  \"country\" : \"Germany\",\r\n  \"count\" : 80\r\n}, {\r\n  \"country\" : \"France\",\r\n  \"count\" : 56\r\n}, {\r\n  \"country\" : \"Sweden\",\r\n  \"count\" : 30\r\n}, {\r\n  \"country\" : \"Japan\",\r\n  \"count\" : 28\r\n}, {\r\n  \"country\" : \"Canada\",\r\n  \"count\" : 21\r\n}, {\r\n  \"country\" : \"the Netherlands\",\r\n  \"count\" : 19\r\n}, {\r\n  \"country\" : \"Switzerland\",\r\n  \"count\" : 19\r\n}, {\r\n  \"country\" : \"Italy\",\r\n  \"count\" : 18\r\n}, {\r\n  \"country\" : \"Russia\",\r\n  \"count\" : 18\r\n}, {\r\n  \"country\" : \"Austria\",\r\n  \"count\" : 16\r\n}, {\r\n  \"country\" : \"Russian Empire\",\r\n  \"count\" : 16\r\n}, {\r\n  \"country\" : \"Prussia\",\r\n  \"count\" : 13\r\n}, {\r\n  \"country\" : \"Austria-Hungary\",\r\n  \"count\" : 13\r\n}, {\r\n  \"country\" : \"Norway\",\r\n  \"count\" : 12\r\n}, {\r\n  \"country\" : \"Denmark\",\r\n  \"count\" : 12\r\n}, {\r\n  \"country\" : \"Scotland\",\r\n  \"count\" : 11\r\n}, {\r\n  \"country\" : \"China\",\r\n  \"count\" : 11\r\n}, {\r\n  \"country\" : \"India\",\r\n  \"count\" : 10\r\n}, {\r\n  \"country\" : \"Australia\",\r\n  \"count\" : 10\r\n}, {\r\n  \"country\" : \"Belgium\",\r\n  \"count\" : 9\r\n}, {\r\n  \"country\" : \"South Africa\",\r\n  \"count\" : 9\r\n}, {\r\n  \"country\" : \"Poland\",\r\n  \"count\" : 9\r\n}, {\r\n  \"country\" : \"Spain\",\r\n  \"count\" : 7\r\n}, {\r\n  \"country\" : \"Hungary\",\r\n  \"count\" : 7\r\n}, {\r\n  \"country\" : \"USSR\",\r\n  \"count\" : 6\r\n}, {\r\n  \"country\" : \"Egypt\",\r\n  \"count\" : 6\r\n}, {\r\n  \"country\" : \"Northern Ireland\",\r\n  \"count\" : 5\r\n}, {\r\n  \"country\" : \"West Germany\",\r\n  \"count\" : 5\r\n}, {\r\n  \"country\" : \"British Mandate of Palestine\",\r\n  \"count\" : 5\r\n}, {\r\n  \"country\" : \"Ireland\",\r\n  \"count\" : 5\r\n}, {\r\n  \"country\" : \"Austrian Empire\",\r\n  \"count\" : 4\r\n}, {\r\n  \"country\" : \"Argentina\",\r\n  \"count\" : 4\r\n}, {\r\n  \"country\" : \"Romania\",\r\n  \"count\" : 4\r\n}, {\r\n  \"country\" : \"New Zealand\",\r\n  \"count\" : 3\r\n}, {\r\n  \"country\" : \"Mexico\",\r\n  \"count\" : 3\r\n}, {\r\n  \"country\" : \"East Timor\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Portugal\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Guatemala\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Chile\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"British India\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Turkey\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Finland\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Ottoman Empire\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Liberia\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Luxembourg\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Colombia\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Schleswig\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"French Algeria\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Korea\",\r\n  \"count\" : 2\r\n}, {\r\n  \"country\" : \"Tibet\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"WÃ¼rttemberg\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Bavaria\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Guadeloupe Island\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Morocco\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Iran\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Czechoslovakia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Iraq\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Faroe Islands (Denmark)\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Ukraine\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Tuscany\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Mecklenburg\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Taiwan\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Trinidad and Tobago\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Peru\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Yemen\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Crete\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Madagascar\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"British West Indies\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Costa Rica\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"German-occupied Poland\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Bosnia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Vietnam\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Southern Rhodesia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Bulgaria\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Nigeria\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Kenya\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Lebanon\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Venezuela\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Saint Lucia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Cyprus\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Iceland\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Belgian Congo\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Java, Dutch East Indies\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Brazil\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Gold Coast\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"British Protectorate of Palestine\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Ethiopia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"East Friesland\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Pakistan\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Lithuania\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Persia\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Hesse-Kassel\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Philippines\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Burma\",\r\n  \"count\" : 1\r\n}, {\r\n  \"country\" : \"Free City of Danzig\",\r\n  \"count\" : 1\r\n} ]")));
		}

}