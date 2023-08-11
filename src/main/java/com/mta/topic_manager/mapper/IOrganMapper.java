package com.mta.topic_manager.mapper;


import com.mta.topic_manager.dto.OrganDto;
import com.mta.topic_manager.entity.Organ;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrganMapper {
    OrganDto organEntityToDto(Organ organ);
    Organ organDtoToEntity(OrganDto organ);
    List<OrganDto> listOrganE2D(List<Organ> o);
    List<Organ> ListOrganD2E(List<OrganDto> o);
}
