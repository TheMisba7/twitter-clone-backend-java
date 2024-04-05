package org.mansar.twitterjava.dao;

import org.mansar.twitterjava.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetDao extends JpaRepository<Tweet, Long> {
}
