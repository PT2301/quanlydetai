package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITopicService {
    List<TopicDto> getAll();

    TopicDto createTopic(TopicDto topic, Integer fieldID, Integer organId, Integer statusId, Integer resultId);

    TopicDto updateTopic(String id, TopicDto topic);

    void deleteTopic(String id);

    TopicDto getTopicById(String id);

    TopicDto approveTopic(String id);

    TopicDto userApproveTopic(String id);

    List<TopicDto> getTopicByResult(Integer id);

    List<TopicDto> getTopicByStatus(Integer id);

    List<TopicDto> getTopicByField(Integer id);

    List<TopicDto> getTopicByUser(Integer id);

    Page<TopicDto> getTopicByApproveWithOrgan(int page, int size, Integer organId);

    Page<TopicDto> findTopicWithFilter(int page, int size, String topicName,String userName,String organName);




}
