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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tweets")
@Getter @Setter
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweetID")
    private Long id;
    @Column(name = "tweettext")
    private String tweetText;
    @CreationTimestamp
    @Column(name = "tweetedat")
    private LocalDateTime tweetedAt;
    @Column(name = "updatedat")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "tweetedby")
    private User tweetedBy;

    public Tweet(String tweetText, User tweetedBy) {
        this.tweetText = tweetText;
        this.tweetedBy = tweetedBy;
    }
}
