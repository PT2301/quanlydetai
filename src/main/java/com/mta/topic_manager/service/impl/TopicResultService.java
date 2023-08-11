package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.TopicResultDto;
import com.mta.topic_manager.entity.TopicResult;
import com.mta.topic_manager.mapper.ITopicResultMapper;
import com.mta.topic_manager.repository.ITopicResultRepository;
import com.mta.topic_manager.service.ITopicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicResultService implements ITopicResultService {
    @Autowired
    private ITopicResultRepository resultRepository;
    @Autowired
    private ITopicResultMapper resultMapper;
    @Override
    @Transactional
    public TopicResultDto createResult(TopicResultDto req) {
        return resultMapper.E2D(resultRepository.save(resultMapper.D2E(req)));
    }

    @Override
    @Transactional
    public TopicResultDto updateResult(Integer id, TopicResultDto req) {
        TopicResult result = resultRepository.findById(id).orElseThrow(()->new RuntimeException("Result not exists"));
        result.setName(req.getName());
        result.setDecription(req.getDecription());
        return resultMapper.E2D(resultRepository.save(result));
    }

    @Override
    @Transactional
    public void deleteResult(Integer id) {
        resultRepository.deleteById(id);
    }

    @Override
    public TopicResultDto getResultById(Integer id) {
        return resultMapper.E2D(resultRepository.findById(id).orElseThrow(()->new RuntimeException("Not found result in data")));
    }

    @Override
    public TopicResultDto getResultByName(String name) {
        return resultMapper.E2D(resultRepository.findByName(name).orElseThrow(()->new RuntimeException("Not found result in data")));
    }

    @Override
    public List<TopicResultDto> getAll() {
        return resultMapper.listE2D(resultRepository.findAll());
    }

    @Override
    public boolean existsByName(String name) {
        return resultRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Integer id) {
        return resultRepository.existsById(id);
    }
}
