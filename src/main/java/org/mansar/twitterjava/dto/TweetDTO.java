package org.mansar.twitterjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TweetDTO {
    private Long id;
    private String tweetText;
    private LocalDateTime tweetedAt;
    private LocalDateTime updatedAt;
    private Long tweetedBy;
}
