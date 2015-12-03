package rssfeeds.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import rssfeeds.bean.Feed;
import rssfeeds.bean.FeedMessage;
import rssfeeds.reader.RSSFeedParser;

@ManagedBean(name = "RSSReaderController")
@SessionScoped
public class RSSReaderController implements Serializable {

	private static final long serialVersionUID = -1441101939536538653L;

	private List<FeedMessage> messages;

	public List<FeedMessage> getMessages() {
		if (messages == null) {
			messages = new ArrayList<FeedMessage>();
		}
		return messages;
	}

	public void setMessages(List<FeedMessage> messages) {
		this.messages = messages;
	}

	@PostConstruct
	public void rSSReaderController() {
		RSSFeedParser parser = new RSSFeedParser(
				"http://news.yahoo.com/rss/topstories");
		Feed feed = parser.readFeed();
		System.out.println(feed);
		messages = feed.getMessages();

		for (FeedMessage message : messages) {
			System.out.println(message);

		}
	}
}
