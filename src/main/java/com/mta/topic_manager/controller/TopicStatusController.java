package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicStatusDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.ITopicStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/api/status"})
@CrossOrigin(origins = "*")
public class TopicStatusController {
    @Autowired
    private ITopicStatusService topicStatusService;
    @PostMapping()
    public ResponseEntity<?> createStatus(@RequestBody @Valid TopicStatusDto req){
        return ResponseModel.responseBuilder(MessageEnum.CREATE_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.createStatus(req),true);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer id,@RequestBody TopicStatusDto req){
        return ResponseModel.responseBuilder(MessageEnum.UPDATE_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.updateStatus(id,req),true);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deteleStatus(@PathVariable Integer id){
        topicStatusService.deleteStatus(id);
        return ResponseModel.responseBuilder(MessageEnum.DELETE_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping()
    public ResponseEntity<?> getAll(){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.getAll(),true);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable Integer id){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.getStatusById(id),true);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStatusByName(@PathVariable String name){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.getStatusByName(name),true);
    }
    @GetMapping("/existsByName")
    public ResponseEntity<?> existsByName(@RequestParam(name = "name") String name){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicStatusService.existsByName(name),true);
    }
}
