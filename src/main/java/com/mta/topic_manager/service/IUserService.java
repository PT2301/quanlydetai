package com.mta.topic_manager.service;
import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.entity.User;
import com.mta.topic_manager.security.userscurity.UserDetailsimpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface IUserService {
    UserDto findByEmail(String email);
    boolean existsByEmail(String email);
    UserDto saveOrUpdate(UserDto user);
    List<UserDto> findByName(String name);
    UserDto findById(int id);
    String changePass(String oldPass,String newPass) throws Exception;
    User getCurrentUser();
    UserDto getCurrentUserDto();
    UserDto updateInfor(Integer id, UserDto userRequest) throws ChangeSetPersister.NotFoundException;
    void disable();
    void enable();
    void disables(Integer id);
    Page<UserDto> getUserByOrgan(int page, int size, String organ, String role);
}
