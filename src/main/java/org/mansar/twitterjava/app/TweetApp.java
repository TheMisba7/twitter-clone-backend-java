package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.TweetDao;
import org.mansar.twitterjava.dao.UserDao;
import org.mansar.twitterjava.dto.NewTweet;
import org.mansar.twitterjava.dto.TweetDTO;
import org.mansar.twitterjava.dto.mapper.TweetMapper;
import org.mansar.twitterjava.model.Tweet;
import org.mansar.twitterjava.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetApp extends AbstractApp<Tweet, TweetDao>{
    private final UserApp userApp;
    public final TweetDao tweetDao;
    private final UserDao userDao;
    private final TweetMapper tweetMapper;
    public TweetApp(TweetDao dao, UserApp userApp, UserDao userDao, TweetMapper tweetMapper) {
        super(dao);
        this.userApp = userApp;
        this.tweetDao = dao;
        this.userDao = userDao;
        this.tweetMapper = tweetMapper;
    }

    public void create(NewTweet tweetDTO) {
        User user = userApp.getById(tweetDTO.getTweetedBy());
        Tweet tweet = new Tweet(tweetDTO.getTweetText(), user);
        super.save(tweet);
    }

    public List<TweetDTO> getTweets() {
        List<Tweet> tweetByTweetedBy = tweetDao.getTweetByTweetedBy(getCurrentUser());
        return tweetMapper.toDTO(tweetByTweetedBy);
    }
}
