package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.OrganDto;
import com.mta.topic_manager.entity.Organ;
import com.mta.topic_manager.mapper.IOrganMapper;
import com.mta.topic_manager.repository.IOrganRepository;
import com.mta.topic_manager.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganService implements IOrganService {
@Autowired
private IOrganRepository organRepository;
@Autowired
private IOrganMapper organMapper;
    @Override
    public OrganDto createOrgan(OrganDto organ) {
        return organMapper.organEntityToDto(organRepository.save(organMapper.organDtoToEntity(organ))) ;
    }

    @Override
    public Organ getOrgan(Integer id) {
        return organRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found Organ in Database"));
    }

    @Override
    public OrganDto getOrganDto(Integer id) {
        return organMapper.organEntityToDto(getOrgan(id));
    }

    @Override
    public void deleteOrgan(Integer id) {
        Organ organ=getOrgan(id);
        organRepository.delete(organ);
    }

    @Override
    public OrganDto updateOrgan(Integer id,OrganDto organDto) {
        Organ organ=getOrgan(id);
        organ.setName(organDto.getName());
        organ.setEmail(organDto.getEmail());
        organ.setAddress(organDto.getAddress());
        organ.setDecription(organDto.getDecription());
        return organMapper.organEntityToDto(organRepository.save(organ));
    }

    @Override
    public List<OrganDto> getAll() {
        List<Organ>organList=organRepository.findAll();
        return organMapper.listOrganE2D(organList);
    }

}
