package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.FeedApp;
import org.mansar.twitterjava.dto.FollowRequest;
import org.mansar.twitterjava.dto.TweetDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedApp feedApp;

    public FeedController(FeedApp feedApp) {
        this.feedApp = feedApp;
    }
    @PostMapping
    public void newFollow(@RequestBody FollowRequest followRequest) {
        feedApp.create(followRequest);
    }
    @GetMapping
    public List<TweetDTO> getFeed() {
        return feedApp.getUserFeed();
    }
}
