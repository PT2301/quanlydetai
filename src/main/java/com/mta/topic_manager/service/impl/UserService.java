package com.mta.topic_manager.service.impl;


import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.entity.Role;
import com.mta.topic_manager.entity.User;
import com.mta.topic_manager.mapper.IDegreeMapper;
import com.mta.topic_manager.mapper.IOrganMapper;
import com.mta.topic_manager.mapper.IUserMapper;
import com.mta.topic_manager.model.RoleEnum;
import com.mta.topic_manager.repository.IRoleRepository;
import com.mta.topic_manager.repository.IUserRepository;
import com.mta.topic_manager.security.userscurity.UserDetailsimpl;
import com.mta.topic_manager.service.IRoleService;
import com.mta.topic_manager.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IOrganMapper organMapper;
    @Autowired
    private IDegreeMapper degreeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public UserDto findByEmail(String email) {
        return userMapper.userEntityToDto(userRepository.findByEmail(email).get());
    }
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public UserDto saveOrUpdate(UserDto userDto) {
        User user=userMapper.userDtoToEntity(userDto);
        user=userRepository.save(user);
        userDto=userMapper.userEntityToDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> findByName(String name) {
        return userMapper.listUserE2D(userRepository.findByName(name));
    }

    @Override
    public UserDto findById(int id) {
        return userMapper.userEntityToDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not exists")));
    }

    @Override
    public String changePass(String oldPass, String newPass) throws Exception {
        String message= null;
        User  user=getCurrentUser();
        if(!passwordEncoder.matches(oldPass,user.getPass())){
            message="Old password is not correct";
        }else{
            if(passwordEncoder.matches(newPass,user.getPass())){
                message="New password cannot be the same old password";
            }else{
                user.setPass(passwordEncoder.encode(newPass));
                userRepository.save(user);
                message="Change password successfully!";
            }
        }
        return message;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsimpl curentUser= (UserDetailsimpl)authentication.getPrincipal();
        return userRepository.findByEmail(curentUser.getEmail()).orElseThrow();
    }

    @Override
    public UserDto getCurrentUserDto() {
        return userMapper.userEntityToDto(getCurrentUser());
    }

    @Override
    public UserDto updateInfor(Integer id, UserDto userRequest) throws ChangeSetPersister.NotFoundException {
        User userEntity= userRepository.findById(id).orElseThrow(()-> new ChangeSetPersister.NotFoundException());
        userEntity.setName(userEntity.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setGender(userRequest.getGender());
        userEntity.setBirth(userRequest.getBirth());
        userEntity.setOrgan(organMapper.organDtoToEntity(userRequest.getOrgan()));
        userEntity.setDegrees(degreeMapper.degreeSetD2E(userRequest.getDegrees()));
        return userMapper.userEntityToDto(userRepository.save(userEntity));
    }

    @Override
    public void disable() {
        User  user=getCurrentUser();
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void enable() {
        User  user=getCurrentUser();
        user.setStatus(true);
        userRepository.save(user);
    }

    @Override
    public void disables(Integer id) {
        User user= userRepository.findById(id).orElseThrow();
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void setAdmin(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not exists"));
        Set<Role> abc =user.getRoles();
        abc.add(roleRepository.findByName(RoleEnum.ADMIN).orElseThrow());
        user.setRoles(abc);
        userRepository.save(user);
    }

    @Override
    public void removeAdmin(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not exists"));
        Set<Role> abc =user.getRoles();
        abc.remove(roleRepository.findByName(RoleEnum.ADMIN).orElseThrow());
        user.setRoles(abc);
        userRepository.save(user);
    }

    @Override
    public Page<UserDto> getUserByOrgan(int page, int size, String organ, String role) {
        Pageable paging = PageRequest.of(page,size, Sort.by("create_date").descending());
        Page<User> listUser =userRepository.getUserByOrgan(organ,role,paging);
        return listUser.map(userMapper::userEntityToDto);
    }
}
