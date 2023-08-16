package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.UserDto;
import com.mta.topic_manager.dto.request.StringRequest;
import com.mta.topic_manager.dto.response.MessageResponse;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,userService.findByName(username),true);
    }
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,userService.findById(id),true);
    }
    @PatchMapping(value = "/changepassword")
    public ResponseEntity<?> changePassword(@RequestParam(name="oldPass") String oldPass,@RequestParam(name="newPass") String newPass) throws Exception {
        String message=userService.changePass(oldPass,newPass);
        return ResponseModel.responseBuilder(message, HttpStatus.OK,null,true);
    }
    @PatchMapping(value = "update/{id}")
    public ResponseEntity<?> updateInfor(@PathVariable Integer id,@RequestBody UserDto userRequest) throws ChangeSetPersister.NotFoundException {
        UserDto user= userService.updateInfor(id,userRequest);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(),HttpStatus.OK,user,true );
    }
    @PatchMapping(value = "/disable")
    public ResponseEntity<?> disable(){
        userService.disable();
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(),HttpStatus.OK,null,true );
    }
    @PatchMapping(value = "/enable")
    public ResponseEntity<?> enable() {
        userService.enable();
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK, null, true);
    }
    @PutMapping (value = "/admin/disable")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> disableUser(@RequestBody(required =false) StringRequest ids){
        ids.getStrings().forEach(id->userService.disables(id));
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(),HttpStatus.OK,null,true );
    }
    @PatchMapping("/setAdmin/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public  ResponseEntity<?> setAdmin(@PathVariable Integer id){
        userService.setAdmin(id);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(),HttpStatus.OK,null,true );
    }
    @PatchMapping("/removeAdmin/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public  ResponseEntity<?> removeAdmin(@PathVariable Integer id){
        userService.removeAdmin(id);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(),HttpStatus.OK,null,true );
    }
    @GetMapping(value = "/getByOrgan")
    public ResponseEntity<?> getUserByOrgan(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size
                                        ,@RequestParam(name="organ",defaultValue = "%") String organ
                                        ,@RequestParam(name="role",defaultValue = "%")String role){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK, userService.getUserByOrgan(page, size, organ, role),true);
    }

}
