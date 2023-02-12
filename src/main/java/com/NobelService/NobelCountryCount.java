package com.NobelService;

public class NobelCountryCount {
	//The structure we want things to be returned in, as a POJO
	public NobelCountryCount(String countryName, Integer prizeAmount) {
		country = countryName;
		count = prizeAmount;
	}
	public String country;
	public int count;
}
