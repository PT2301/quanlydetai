package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.TopicFieldDto;
import com.mta.topic_manager.entity.TopicField;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ITopicFieldMapper {
    TopicFieldDto E2D (TopicField t);
    TopicField D2E(TopicFieldDto t);
    List<TopicFieldDto> listE2D(List<TopicField> t);
    List<TopicField> listD2E(List<TopicFieldDto> t);
}
