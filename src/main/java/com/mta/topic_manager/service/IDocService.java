package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.TopicDocDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Primary
public interface IDocService {
  TopicDocDto createDoc(TopicDocDto docDto);
}
