package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.TweetDao;
import org.mansar.twitterjava.dto.NewTweet;
import org.mansar.twitterjava.model.Tweet;
import org.mansar.twitterjava.model.User;
import org.springframework.stereotype.Service;

@Service
public class TweetApp extends AbstractApp<Tweet, TweetDao>{
    private final UserApp userApp;
    public TweetApp(TweetDao dao, UserApp userApp) {
        super(dao);
        this.userApp = userApp;
    }

    public void create(NewTweet tweetDTO) {
        User user = userApp.getById(tweetDTO.getTweetedBy());
        Tweet tweet = new Tweet(tweetDTO.getTweetText(), user);
        super.save(tweet);
    }
}
