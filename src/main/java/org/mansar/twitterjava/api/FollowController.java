package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.FollowApp;
import org.mansar.twitterjava.dto.FollowRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    private final FollowApp followApp;

    public FollowController(FollowApp followApp) {
        this.followApp = followApp;
    }
    @PostMapping
    public void newFollow(@RequestBody FollowRequest followRequest) {
        followApp.create(followRequest);
    }
}
