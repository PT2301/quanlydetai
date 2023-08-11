package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.OrganDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/organ")
@CrossOrigin(origins = "*")
public class OrganController {
@Autowired
private IOrganService organService;
    @PostMapping(value = "/create")
    private ResponseEntity<?> createOrgan(@RequestBody OrganDto organRequest){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,organService.createOrgan(organRequest),true);
    }
    @DeleteMapping(value = "/delete/{id}")
    private ResponseEntity<?> deleteOrgan(@PathVariable Integer id){
        organService.deleteOrgan(id);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @PatchMapping(value = "/update/{id}")
    private ResponseEntity<?> updateOrgan(@PathVariable(value = "id") Integer id,@RequestBody OrganDto organDto){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,organService.updateOrgan(id,organDto),true);
    }
    @GetMapping(value = "/getAll")
    private ResponseEntity<?> getAll(){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,organService.getAll(),true);
    }
    @GetMapping(value = "/{id}")
    private ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,organService.getOrganDto(id),true);
    }

}
