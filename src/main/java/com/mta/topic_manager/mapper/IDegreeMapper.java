package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.DegreeDto;
import com.mta.topic_manager.entity.Degree;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;
@Mapper(componentModel = "spring")
public interface IDegreeMapper {
    Degree degreeDtoToEntity(DegreeDto d);
    DegreeDto degreeEntityToDto(Degree d);
    Set<Degree> degreeSetD2E(Set<DegreeDto> d);
    Set<DegreeDto> degreeSetE2D(Set<Degree> d);
}
