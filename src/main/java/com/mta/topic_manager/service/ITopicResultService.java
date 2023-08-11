package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicResultDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface ITopicResultService {
    TopicResultDto createResult(TopicResultDto req);
    TopicResultDto updateResult(Integer id,TopicResultDto req);
    void deleteResult(Integer id);
    TopicResultDto getResultById(Integer Id);
    TopicResultDto getResultByName(String name);
    List<TopicResultDto> getAll();
    boolean existsByName(String name);
    boolean existsById(Integer id);
}
