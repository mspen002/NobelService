package com.NobelService;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class NobelLaureatesController {

	@GetMapping("/laureate-count")
	public List<NobelCountryCount> getLaureateCount() throws JsonProcessingException {
		
		Map<String, Integer> infoMap = null;
		try {
			infoMap = NobelParsingAPI.recieveNobelInfo(new URL(NobelServiceConfig.laureateURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//This sorts the unsorted map that we receive from the nobelParsingAPI
		long start = System.currentTimeMillis();
		final List<NobelCountryCount> returnList = infoMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map((value) -> (new NobelCountryCount(value.getKey(), value.getValue())))
                .toList();
		long end = System.currentTimeMillis();
		System.out.println("Sorting Finished: " + (end-start) + "ms.");
		
		return returnList;
	}
	
	//get all 900+ laureates in one full endpoint, can account for 10k.
	@GetMapping("/laureate-count-full")
	public List<NobelCountryCount> getLaureateCountFull() throws JsonProcessingException {
		
		Map<String, Integer> infoMap = null;
		try {
			infoMap = NobelParsingAPI.recieveNobelInfo(new URL(NobelServiceConfig.laureateURLFull));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//This sorts the unsorted map that we receive from the nobelParsingAPI
		long start = System.currentTimeMillis();
		final List<NobelCountryCount> returnList = infoMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map((value) -> (new NobelCountryCount(value.getKey(), value.getValue())))
                .toList();
		long end = System.currentTimeMillis();
		System.out.println("Sorting Finished: " + (end-start) + "ms.");
		
		return returnList;
	}

}