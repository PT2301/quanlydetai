package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.TopicStatusDto;
import com.mta.topic_manager.entity.TopicStatus;
import com.mta.topic_manager.mapper.ITopicStatusMapper;
import com.mta.topic_manager.repository.ITopicStatusRepository;
import com.mta.topic_manager.service.ITopicStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicStatusService implements ITopicStatusService {
    @Autowired
    private ITopicStatusRepository topicStatusRepository;
    @Autowired
    private ITopicStatusMapper topicStatusMapper;
    @Override
    public TopicStatusDto createStatus(TopicStatusDto req) {
        if(topicStatusRepository.findByName(req.name)!=null){
            throw new RuntimeException("Status already exists");
        };
        return topicStatusMapper.E2D(topicStatusRepository.save(topicStatusMapper.D2E(req)));
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public TopicStatusDto updateStatus(Integer id, TopicStatusDto req) {
        TopicStatus status= topicStatusRepository.findById(id).orElseThrow();
        status.setName(req.getName());
        status.setDecription(req.getDecription());
        return topicStatusMapper.E2D(topicStatusRepository.save(status));
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void deleteStatus(Integer id) {
        topicStatusRepository.deleteById(id);
    }

    @Override
    public TopicStatusDto getStatusById(Integer id) {
        return topicStatusMapper.E2D(topicStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Not found status in data")));
    }

    @Override
    public TopicStatusDto getStatusByName(String name) {
        TopicStatus status=topicStatusRepository.findByName(name).orElseThrow(()->new RuntimeException("Not found status in data"));
        return topicStatusMapper.E2D(status);
    }

    @Override
    public List<TopicStatusDto> getAll() {
        return topicStatusMapper.listE2D(topicStatusRepository.findAll(Sort.by("id")));
    }

    @Override
    public boolean existsByName(String name) {
        return topicStatusRepository.existsByName(name);
    }

}
