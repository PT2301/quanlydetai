package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.DegreeDto;
import com.mta.topic_manager.dto.OrganDto;
import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.entity.Degree;
import com.mta.topic_manager.entity.Organ;
import com.mta.topic_manager.entity.Role;
import com.mta.topic_manager.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IUserMapper {
    UserDto userEntityToDto(User user);
    User userDtoToEntity(UserDto userDto);
    RoleDto roleEntitytoDto(Role role);
    Role roleDtoToEntity( RoleDto roleDto);
    OrganDto organEntityToDto(Organ organ);
    Organ organDtoToEntity(OrganDto organ);
    Degree degreeDtoToEntity(DegreeDto degreeDto);
    DegreeDto degreeEntityToEntity(User user);
}
