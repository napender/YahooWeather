package com.napendra;

import com.napendra.rss.RSSParser;
import com.napendra.rss.WeatherDescriptionObject;

/**
 * 
 * @author napendra
 * 
 */
public class WeatherHelper {

	private static String yahooPoint = "http://weather.yahooapis.com";
	private static String uriParameter = "/forecastrss?w=";
	private static String uriTemperture = "&u=c";
	private WeatherDescriptionObject weatherDescriptionObject;

	public WeatherDescriptionObject getWeatherResponse(String cityCode) {

		try {

			RSSParser rssParser = new RSSParser(new WeatherDescriptionObject());
			weatherDescriptionObject = rssParser.rssParserUtility(yahooPoint
					+ uriParameter + cityCode + uriTemperture);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return weatherDescriptionObject;
	}

	public void displayResponse(WeatherDescriptionObject response)
			throws Exception {

		System.out.println(" ------- @author Napendra --------- ");
		System.out
				.println(" *************************************************");
		System.out
				.println(" *************************************************");

		System.out
				.println(" ******** Printing Location JAVA object ************");

		if (response != null) {
			System.out.println(response.getLocationInformation());
			System.out
					.println(" *************************************************");
			System.out
					.println(" *************************************************");
			System.out
					.println(" *************************************************");
			System.out
					.println(" ********** Printing Main Description Object ******** ");

			System.out.println(response.getWeatherDescription());
		}
		System.out
				.println(" *************************************************");
		System.out
				.println(" *************************************************");
		System.out.println(" Ending Response ");

	}

}
