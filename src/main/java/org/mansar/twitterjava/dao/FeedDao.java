package org.mansar.twitterjava.dao;

import org.mansar.twitterjava.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedDao extends JpaRepository<Follower, Long> {
    List<Follower> findByFollowerId(Long id);
}
