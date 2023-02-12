package com.NobelService;

public class NobelServiceConfig {
	static String laureateURL = "https://api.nobelprize.org/2.1/laureates";
	//called a larger number of laureates to account for future prize winners
	static String laureateURLFull = "https://masterdataapi.nobelprize.org/2.1/laureates?offset=0&limit=10000";
}
