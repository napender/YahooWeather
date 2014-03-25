package com.napendra;

import com.napendra.rss.WeatherDescriptionObject;

/**
 * 
 * @author napendra
 * 
 */
public class YahooWeatherAPI {

	public static void main(String[] args) throws Exception {

		validateInput(args);
		// Call Weather Helper API
		WeatherHelper weatherHelper = new WeatherHelper();
		WeatherDescriptionObject response = weatherHelper
				.getWeatherResponse(args[0].toString());
		weatherHelper.displayResponse(response);

	}

	private static void validateInput(String[] args) {
		if (args.length < 1) {
			System.out.println(" you did not specify right parameters to API ");
			System.out.println(" Please specify command like from command line --> [java -jar YahooWeatherLibrary.jar 29222459] ");
			System.exit(0);
		}

	}

}