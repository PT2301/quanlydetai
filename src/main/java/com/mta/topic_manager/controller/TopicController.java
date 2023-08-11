package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.ITopicService;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/api/topic"})
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    private ITopicService topicService;

    @Autowired
    private IUserService userService;

    @PostMapping("/create/field/{fieldId}/organ/{organId}")
    public  ResponseEntity<?> createTopic(@PathVariable Integer fieldId,@PathVariable Integer organId ,@RequestBody TopicDto topic){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @PatchMapping(value = "/update")
    public  ResponseEntity<?> updateTopic(){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTopic(){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTopic(){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @PatchMapping(value = "/approve")
    public ResponseEntity<?> approveTopic(){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getTopicNoPaging(){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getAll(),true);
    }


}
