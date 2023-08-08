package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.RoleDto;
import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.dto.request.SignInRequest;
import com.mta.topic_manager.dto.request.SignUpRequest;
import com.mta.topic_manager.dto.response.JwtResponse;
import com.mta.topic_manager.dto.response.MessageResponse;
import com.mta.topic_manager.entity.User;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.model.RoleEnum;
import com.mta.topic_manager.security.jwt.JwtTokenProvider;
import com.mta.topic_manager.security.userscurity.UserDetailsimpl;
import com.mta.topic_manager.service.IRoleService;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private JwtTokenProvider jwtTokenProvider;

    @PostMapping (value = "/signup")
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
        userDto.setDegrees(signUpRequest.getDegree());
        userDto.setOrgan(signUpRequest.getOrgan());
        userDto.setStatus(true);
        Set<String> roles= signUpRequest.getRoles();
        Set<RoleDto> userRole= roles.stream().map(role->roleService.findByName(RoleEnum.valueOf(role))
                .orElseThrow(()-> new RuntimeException("Role null"))).collect(Collectors.toSet());
        userDto.setRoles(userRole);
        userDto=userService.saveOrUpdate(userDto);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,userDto ,true);
    }
    @PostMapping (value = "/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody SignInRequest signInRequest) throws ParseException {
        try{
            Authentication authentication= authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String[] jwt= jwtTokenProvider.generateToken(authentication);
            UserDetailsimpl userDetailsimpl =(UserDetailsimpl) authentication.getPrincipal();
            List<String> roles = userDetailsimpl.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateExpried = sdf.parse(jwt[1]);
            JwtResponse jwtResponse= new JwtResponse();
            jwtResponse.setToken(jwt[0]);
            jwtResponse.setId(userDetailsimpl.getId());
            jwtResponse.setEmail(userDetailsimpl.getEmail());
            jwtResponse.setName(userDetailsimpl.getName());
            jwtResponse.setStatus(userDetailsimpl.isStatus());
            jwtResponse.setListRoles(roles);
            jwtResponse.setDateExpried(dateExpried);
//        JwtResponse jwtResponse=JwtResponse.builder()
//                .token(jwt[0])
//                .id(userDetailsimpl.getId())
//                .name(userDetailsimpl.getUsername())
//                .email(userDetailsimpl.getEmail())
//                .status(userDetailsimpl.isStatus())
//                .listRoles(roles)
//                .dateExpried(new Date(Long.parseLong(jwt[1])))
//                .build();
            return  ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,jwtResponse ,true);
        }catch (BadCredentialsException e){
            return ResponseModel.responseBuilder("Thông tin đăng nhập không hợp lệ", HttpStatus.PRECONDITION_FAILED,null,false);
        }
    }
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return  ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null ,true);
//    }
}