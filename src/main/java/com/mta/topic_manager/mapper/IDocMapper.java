package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.TopicDocDto;
import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.entity.TopicDoc;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IDocMapper {
    TopicDocDto E2D(TopicDoc t);
    TopicDoc D2E(TopicDocDto t);
    List<TopicDocDto> listE2D(List<TopicDoc> t);
    List<TopicDoc> listD2E(List<TopicDocDto> t);
}
