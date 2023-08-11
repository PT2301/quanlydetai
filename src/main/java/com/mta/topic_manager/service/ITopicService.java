package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITopicService {
    List<TopicDto> getAll();
    TopicDto createTopic(TopicDto topic,Integer fieldID,Integer organId,Integer statusId,Integer resultId);
}
