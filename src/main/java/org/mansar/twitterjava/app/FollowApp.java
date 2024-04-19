package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.FollowDao;
import org.mansar.twitterjava.dto.FollowRequest;
import org.mansar.twitterjava.model.Follower;
import org.mansar.twitterjava.model.User;
import org.springframework.stereotype.Service;

@Service
public class FollowApp extends AbstractApp<Follower, FollowDao>{
    private final UserApp userApp;
    public FollowApp(FollowDao dao, UserApp userApp) {
        super(dao);
        this.userApp = userApp;
    }

    public void create(final FollowRequest followRequest) {
        User follower = userApp.getById(followRequest.getFollower());
        User followee = userApp.getById(followRequest.getFollowee());
        Follower follower1 = new Follower(follower, followee);
        super.save(follower1);
    }
}
