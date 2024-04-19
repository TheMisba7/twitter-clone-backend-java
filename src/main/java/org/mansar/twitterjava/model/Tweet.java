package org.mansar.twitterjava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweetID")
    private Long id;
    private String tweetText;
    @CreatedDate
    private LocalDateTime tweetedAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User tweetedBy;

    public Tweet(String tweetText, User tweetedBy) {
        this.tweetText = tweetText;
        this.tweetedBy = tweetedBy;
    }
}
