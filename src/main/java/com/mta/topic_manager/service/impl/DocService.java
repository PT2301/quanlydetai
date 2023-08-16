package com.mta.topic_manager.service.impl;


import com.mta.topic_manager.dto.TopicDocDto;
import com.mta.topic_manager.mapper.IDocMapper;
import com.mta.topic_manager.repository.IDocRepository;
import com.mta.topic_manager.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocService implements IDocService {
    @Autowired
    private IDocRepository docRepository;
    @Autowired
    private IDocMapper docMapper;
    @Override
    public TopicDocDto createDoc(TopicDocDto docDto) {
        return docMapper.E2D(docRepository.save(docMapper.D2E(docDto))) ;
    }
}
