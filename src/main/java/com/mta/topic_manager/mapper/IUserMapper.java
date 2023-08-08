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
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface IUserMapper {
//    @Mapping(source = "role",target = "roles")
//    @Mapping(source = "role",target = "roles")
    UserDto userEntityToDto(User user);
    User userDtoToEntity(UserDto userDto);

    RoleDto roleEntitytoDto(Role role);
    Role roleDtoToEntity( RoleDto roleDto);

    OrganDto organEntityToDto(Organ organ);
    Organ organDtoToEntity(OrganDto organ);

    Degree degreeDtoToEntity(DegreeDto degreeDto);
    DegreeDto degreeEntityToDto(Degree degree);

    Set<Degree> setDegreesD2E(Set<DegreeDto> d);
    Set<DegreeDto> setDegreeE2D(Set<Degree> d);

    Set<Role> setRoleD2E(Set<RoleDto> r);
    Set<RoleDto> setRoleE2D(Set<Role> r);

    List<User> listUserD2E(List<UserDto> u);
    List<UserDto> listUserE2D(List<User> u);
}
