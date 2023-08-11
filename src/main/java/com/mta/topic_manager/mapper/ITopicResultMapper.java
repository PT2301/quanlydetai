package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.TopicResultDto;
import com.mta.topic_manager.entity.TopicResult;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ITopicResultMapper {
    TopicResultDto E2D (TopicResult t);
    TopicResult D2E(TopicResultDto t);
    List<TopicResultDto> listE2D(List<TopicResult> t);
    List<TopicResult> listD2E(List<TopicResultDto> t);
}
