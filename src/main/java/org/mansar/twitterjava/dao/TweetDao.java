package org.mansar.twitterjava.dao;

import org.mansar.twitterjava.model.Tweet;
import org.mansar.twitterjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TweetDao extends JpaRepository<Tweet, Long> {
    List<Tweet> getTweetByTweetedBy(User tweetedBy);
    //don't get confuse!! TweetedBy = User, so it should be called findByUserId
    List<Tweet> findByTweetedByIdIn(Collection<Long> tweetedBy_id);
}
