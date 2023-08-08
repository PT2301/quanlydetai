package com.mta.topic_manager.mapper;

import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.entity.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface IRoleMapper {
    Role roleDtoToEntity(RoleDto roleDto);
    RoleDto roleEntityToDto(Role role);
}
