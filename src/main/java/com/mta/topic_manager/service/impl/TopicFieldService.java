package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.TopicFieldDto;
import com.mta.topic_manager.entity.TopicField;
import com.mta.topic_manager.mapper.ITopicFieldMapper;
import com.mta.topic_manager.repository.ITopicFieldRepository;
import com.mta.topic_manager.service.ITopicFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicFieldService implements ITopicFieldService {
    @Autowired
    private ITopicFieldRepository fieldRepository;
    @Autowired
    private ITopicFieldMapper fieldMapper;
    @Override
    public TopicFieldDto createField(TopicFieldDto req) {
        if(existsByName(req.getName())){
            throw new RuntimeException(" Field adrealy exists");
        }
        return fieldMapper.E2D(fieldRepository.save(fieldMapper.D2E(req)));
    }

    @Override
    public TopicFieldDto updateField(Integer id, TopicFieldDto req) {
        if(!existsById(id)){
            throw new RuntimeException(" Field not exists");
        }
        TopicField field= fieldRepository.findById(id).orElseThrow();
        field.setName(req.getName());
        field.setDecription(req.getDecription());
        return fieldMapper.E2D(fieldRepository.save(field));
    }

    @Override
    public void deleteField(Integer id) {
        fieldRepository.deleteById(id);
    }

    @Override
    public TopicFieldDto getFieldById(Integer id) {
        return fieldMapper.E2D(fieldRepository.findById(id).orElseThrow(()->new RuntimeException("Not found field in data")));
    }

    @Override
    public TopicFieldDto getFieldByName(String name) {
        return fieldMapper.E2D(fieldRepository.findByName(name).orElseThrow(()->new RuntimeException("Not found field in data")));
    }

    @Override
    public List<TopicFieldDto> getAll() {
        return fieldMapper.listE2D(fieldRepository.findAll());
    }

    @Override
    public boolean existsByName(String name) {
        return fieldRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Integer id) {
        return fieldRepository.existsById(id);
    }
}
