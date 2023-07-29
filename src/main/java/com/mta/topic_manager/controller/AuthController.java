package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.dto.request.SignUpRequest;
import com.mta.topic_manager.dto.response.MessageResponse;
import com.mta.topic_manager.entity.User;
import com.mta.topic_manager.model.RoleEnum;
import com.mta.topic_manager.service.IRoleService;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
@Autowired
private IUserService userService;
@Autowired
private PasswordEncoder encoder;
@Autowired
private  IRoleService roleService;
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userService.existsByEmail(signUpRequest.getEmail())){
            return  ResponseEntity.badRequest().body(new MessageResponse("User already exists"));
        }
        UserDto userDto= new UserDto();
        userDto.setEmail(signUpRequest.getEmail());
        userDto.setPass(encoder.encode(signUpRequest.getPassword()));
        userDto.setName(signUpRequest.getName());
        userDto.setBirth(signUpRequest.getBirth());
        userDto.setGender(signUpRequest.getGender());
        userDto.setDegree(signUpRequest.getDegree());
        Set<String> roles= signUpRequest.getRoles();
        Set<RoleDto> userRole= roles.stream().map(role->roleService.findByName(RoleEnum.valueOf(role))
                .orElseThrow(()-> new RuntimeException("Role null"))).collect(Collectors.toSet());
        userDto.setRole(userRole);
        userService.saveOrUpdate(userDto);

        return null;
    }
}