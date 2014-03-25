package com.napendra.rss;

import java.net.URL;
import java.util.Iterator;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSParser {

	private WeatherDescriptionObject weatherDescription;

	public RSSParser(WeatherDescriptionObject weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public WeatherDescriptionObject rssParserUtility(String endPoint)
			throws Exception {

		URL url = new URL(endPoint);
		XmlReader reader = null;

		reader = new XmlReader(url);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(reader);

		for (Iterator<SyndEntry> i = feed.getEntries().iterator(); i.hasNext();) {
			SyndEntry entry = (SyndEntry) i.next();
			weatherDescription.setLocationInformation(entry.getTitle());
			weatherDescription.setWeatherDescription(entry.getDescription()
					.getValue());

		}
		return weatherDescription;
	}

}
