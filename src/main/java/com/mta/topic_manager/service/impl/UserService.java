package com.mta.topic_manager.service.impl;


import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.mapper.IUserMapper;
import com.mta.topic_manager.repository.IUserRepository;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserMapper userMapper;
    @Override
    public UserDto findByEmail(String email) {
        return userMapper.userEntityToDto(userRepository.findByEmail(email));
    }
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDto saveOrUpdate(UserDto user) {
        return userMapper.userEntityToDto(userRepository.save(userMapper.userDtoToEntity(user)));
    }
}
