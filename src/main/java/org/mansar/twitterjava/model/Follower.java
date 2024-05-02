package org.mansar.twitterjava.model;

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

import java.time.LocalDateTime;

@Entity(name = "user_follower")
@NoArgsConstructor
@Getter @Setter
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "follower_id") private User follower;
    @ManyToOne
    @JoinColumn(name = "followee_id") private User followee;
    @CreationTimestamp private LocalDateTime followedAt;

    public Follower(User follower, User followee) {
        this.follower = follower;
        this.followee = followee;
    }
}
