package com.mta.topic_manager.service.impl;
import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.mapper.IRoleMapper;
import com.mta.topic_manager.model.RoleEnum;
import com.mta.topic_manager.repository.IRoleRepository;
import com.mta.topic_manager.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IRoleMapper roleMapper;
    @Override
    public Optional<RoleDto> findByName(RoleEnum name) {
        return roleRepository.findByName(name).map(roleMapper::roleEntityToDto);
    }
}
