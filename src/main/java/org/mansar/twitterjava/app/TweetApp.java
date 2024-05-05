package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.TweetDao;
import org.mansar.twitterjava.dao.UserDao;
import org.mansar.twitterjava.dto.NewTweet;
import org.mansar.twitterjava.dto.TweetDTO;
import org.mansar.twitterjava.dto.mapper.TweetMapper;
import org.mansar.twitterjava.model.Tweet;
import org.mansar.twitterjava.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @PreAuthorize("#tweetDTO.tweetedBy == authentication.principal.id")
    public TweetDTO create(NewTweet tweetDTO) {
        User user = userApp.getById(tweetDTO.getTweetedBy());
        Tweet tweet = new Tweet(tweetDTO.getTweetText(), user);
        return tweetMapper.toDTO(super.save(tweet));
    }

    @PreAuthorize("#userId == authentication.principal.id")
    public List<TweetDTO> getTweets(Long userId) {
        User user = userApp.getById(userId);
        List<Tweet> tweetByTweetedBy = tweetDao.getTweetByTweetedBy(user);
        return tweetMapper.toDTO(tweetByTweetedBy);
    }
}
