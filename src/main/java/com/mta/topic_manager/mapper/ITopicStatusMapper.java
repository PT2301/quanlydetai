package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.TopicStatusDto;
import com.mta.topic_manager.entity.TopicStatus;
import org.mapstruct.Mapper;

import javax.persistence.ManyToOne;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ITopicStatusMapper {
    TopicStatusDto E2D (TopicStatus t);
    TopicStatus D2E(TopicStatusDto t);
    List<TopicStatusDto> listE2D(List<TopicStatus> t);
    List<TopicStatus> listD2E(List<TopicStatusDto> t);
}
