package org.mansar.twitterjava.dao;

import org.mansar.twitterjava.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowDao extends JpaRepository<Follower, Long> {
}
