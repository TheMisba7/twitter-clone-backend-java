package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.TweetApp;
import org.mansar.twitterjava.dto.NewTweet;
import org.mansar.twitterjava.dto.TweetDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TweetController {
    private final TweetApp tweetApp;

    public TweetController(TweetApp tweetApp) {
        this.tweetApp = tweetApp;
    }

    @PostMapping("/tweets")
    public TweetDTO create(@RequestBody NewTweet tweetDTO) {
        return tweetApp.create(tweetDTO);
    }
    @GetMapping("/{userId}/tweets")
    public List<TweetDTO> get(@PathVariable(name = "userId") Long userId) {
        return tweetApp.getTweets(userId);
    }
}
