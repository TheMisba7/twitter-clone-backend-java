package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.TweetApp;
import org.mansar.twitterjava.dto.TweetDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetApp tweetApp;

    public TweetController(TweetApp tweetApp) {
        this.tweetApp = tweetApp;
    }

    @PostMapping
    public void create(TweetDTO tweetDTO) {
        tweetApp.create(tweetDTO);
    }
}
