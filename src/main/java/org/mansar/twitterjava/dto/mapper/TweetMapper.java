package org.mansar.twitterjava.dto.mapper;

import org.mansar.twitterjava.dto.TweetDTO;
import org.mansar.twitterjava.model.Tweet;
import org.mapstruct.Mapper;

@Mapper
public interface TweetMapper {
    Tweet fromDTO(TweetDTO tweetDTO);
    TweetDTO toDTO(Tweet tweet);
}
