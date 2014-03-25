package com.napendra;

import org.junit.Test;

import com.napendra.rss.WeatherDescriptionObject;

/**
 * 
 * @author napendra
 * 
 */
public class UnitTest {

	public String VALID_CODE = "29222459";
	public String INVALID_CODE = "0000";

	@Test
	public void testValidRequest() {
		WeatherHelper weatherHelper = new WeatherHelper();
		WeatherDescriptionObject weatherDescription = weatherHelper
				.getWeatherResponse(VALID_CODE);
		assert weatherDescription.getLocationInformation() != null;
		assert weatherDescription.getWeatherDescription() != null;

	}

	@Test
	public void testInValidRequest() {
		WeatherHelper weatherHelper = new WeatherHelper();
		WeatherDescriptionObject weatherDescription = weatherHelper
				.getWeatherResponse(INVALID_CODE);
		assert weatherDescription.getLocationInformation().contains(
				"City not found");
		assert weatherDescription.getWeatherDescription().contains(
				"Invalid Input");

	}

}
