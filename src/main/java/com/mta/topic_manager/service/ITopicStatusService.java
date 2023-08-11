package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicStatusDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface ITopicStatusService {
    TopicStatusDto createStatus(TopicStatusDto req);
    TopicStatusDto updateStatus(Integer id,TopicStatusDto req);
    void deleteStatus(Integer id);
    TopicStatusDto getStatusById(Integer Id);
    TopicStatusDto getStatusByName(String name);
    List<TopicStatusDto> getAll();
    boolean existsByName(String name);

}
