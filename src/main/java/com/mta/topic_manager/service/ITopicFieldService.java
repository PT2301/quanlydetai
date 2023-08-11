package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicFieldDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface ITopicFieldService {
    TopicFieldDto createField(TopicFieldDto t);
    TopicFieldDto updateField(Integer id, TopicFieldDto req);
    void deleteField(Integer id);
    TopicFieldDto getFieldById(Integer Id);
    TopicFieldDto getFieldByName(String name);
    List<TopicFieldDto> getAll();
    boolean existsByName(String name);
    boolean existsById(Integer id);
}
