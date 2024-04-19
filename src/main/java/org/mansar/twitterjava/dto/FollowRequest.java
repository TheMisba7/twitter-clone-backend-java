package org.mansar.twitterjava.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class FollowRequest {
    private Long followee;
    private Long follower;
}
