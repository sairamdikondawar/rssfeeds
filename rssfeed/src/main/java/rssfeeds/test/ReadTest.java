package rssfeeds.test;

import rssfeeds.bean.Feed;
import rssfeeds.bean.FeedMessage;
import rssfeeds.reader.RSSFeedParser;

public class ReadTest {

	  public static void main(String[] args) {
		    RSSFeedParser parser = new RSSFeedParser("http://news.yahoo.com/rss/topstories");
		    Feed feed = parser.readFeed();
		    System.out.println(feed);
		    for (FeedMessage message : feed.getMessages()) {
		      System.out.println(message);

		    }

		  }
}
