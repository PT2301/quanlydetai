package com.mta.topic_manager.service;
import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    UserDto findByEmail(String email);
    boolean existsByEmail(String email);
    UserDto saveOrUpdate(UserDto user);
}
