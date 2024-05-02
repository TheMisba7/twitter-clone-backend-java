package org.mansar.twitterjava.dto.mapper;

import org.mansar.twitterjava.dto.TweetDTO;
import org.mansar.twitterjava.model.Tweet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TweetMapper {
    Tweet fromDTO(TweetDTO tweetDTO);
    TweetDTO toDTO(Tweet tweet);
    List<TweetDTO> toDTO(List<Tweet> tweets);
}
