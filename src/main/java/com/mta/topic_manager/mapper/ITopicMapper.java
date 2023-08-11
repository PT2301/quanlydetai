package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.entity.Topic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITopicMapper  {
    Topic D2E(TopicDto t);
    TopicDto E2D(Topic t);
    List<Topic> listD2E(List<TopicDto> t);
    List<TopicDto> listE2D(List<Topic> t);

}
