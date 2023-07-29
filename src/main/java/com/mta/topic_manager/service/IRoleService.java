package com.mta.topic_manager.service;

import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.entity.Role;
import com.mta.topic_manager.model.RoleEnum;

import java.util.Optional;

public interface IRoleService {
    Optional<RoleDto> findByName(RoleEnum role);
}
