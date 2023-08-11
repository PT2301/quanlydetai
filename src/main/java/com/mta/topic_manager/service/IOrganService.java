package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.OrganDto;
import com.mta.topic_manager.entity.Organ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrganService {
    OrganDto createOrgan(OrganDto organ);
    Organ getOrgan(Integer id);
    OrganDto getOrganDto(Integer id);
    void deleteOrgan(Integer id);
    OrganDto updateOrgan(Integer id,OrganDto organDto);
    List<OrganDto> getAll();

}
