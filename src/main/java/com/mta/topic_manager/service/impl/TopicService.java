package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.entity.Topic;
import com.mta.topic_manager.mapper.ITopicMapper;
import com.mta.topic_manager.repository.ITopicRepository;
import com.mta.topic_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements ITopicService {
    @Autowired
    private ITopicRepository topicRepository;
    @Autowired
    private ITopicMapper topicMapper;
    @Autowired
    private ITopicFieldService fieldService;
    @Autowired
    private ITopicResultService resultService;
    @Autowired
    private ITopicStatusService statusService;
    @Autowired
    private IOrganService organService;
    @Autowired
    private IUserService userService;

    @Override
    public List<TopicDto> getAll() {
        return topicMapper.listE2D(topicRepository.findAll()) ;
    }

    @Override
    public TopicDto createTopic(TopicDto topic, Integer fieldID, Integer organId,Integer statusId, Integer resultId) {
        topic.setTopicField(fieldService.getFieldById(fieldID));
        topic.setTopicStatus(statusService.getStatusById(statusId));
        topic.setTopicResult(resultService.getResultById(resultId));
        topic.setOrgan(organService.getOrganDto(organId));
        if(topic.getUser()==null){
                topic.setUser(userService.getCurrentUserDto());
        }
        Topic topicEntity= topicMapper.D2E(topic);
        return topicMapper.E2D(topicRepository.save(topicEntity));
    }
}
