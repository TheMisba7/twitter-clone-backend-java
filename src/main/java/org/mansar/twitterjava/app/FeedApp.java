package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.FeedDao;
import org.mansar.twitterjava.dao.TweetDao;
import org.mansar.twitterjava.dto.FollowRequest;
import org.mansar.twitterjava.dto.TweetDTO;
import org.mansar.twitterjava.dto.mapper.TweetMapper;
import org.mansar.twitterjava.model.Follower;
import org.mansar.twitterjava.model.Tweet;
import org.mansar.twitterjava.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FeedApp extends AbstractApp<Follower, FeedDao>{
    private final UserApp userApp;
    private final TweetDao tweetDao;
    private final TweetMapper tweetMapper;
    public FeedApp(FeedDao dao, UserApp userApp,
                   TweetDao tweetDao, TweetMapper tweetMapper) {
        super(dao);
        this.userApp = userApp;
        this.tweetDao = tweetDao;
        this.tweetMapper = tweetMapper;
    }

    public void create(final FollowRequest followRequest) {
        User follower = userApp.getById(followRequest.getFollower());
        User followee = userApp.getById(followRequest.getFollowee());
        Follower follower1 = new Follower(follower, followee);
        super.save(follower1);
    }

    public List<TweetDTO> getUserFeed() {
        User currentUser = getCurrentUser();
        Set<Long> ids = new HashSet<>();
        //todo no need for this loop, get list of ids directly from dao
        for (Follower follower: dao.findByFollowerId(currentUser.getId())) {
            ids.add(follower.getFollowee().getId());
        }
        List<Tweet> in = tweetDao.findByTweetedByIdIn(ids);
        return tweetMapper.toDTO(in);

    }
}
