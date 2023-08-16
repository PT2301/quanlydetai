package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.ITopicService;
import com.mta.topic_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/topic"})
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    private ITopicService topicService;

    @Autowired
    private IUserService userService;

    @PostMapping("/create/field/{fieldId}/organ/{organId}")
    public  ResponseEntity<?> createTopic(@PathVariable(required = false) Integer fieldId,@PathVariable(required = false) Integer organId ,@RequestBody TopicDto topic){
        return ResponseModel.responseBuilder(MessageEnum.CREATE_SUCCESS.getValue(), HttpStatus.OK,
                topicService.createTopic(topic,fieldId,organId,1,5),true);
    }
    @PatchMapping(value = "/{id}")
    public  ResponseEntity<?> updateTopic(@PathVariable String id,@RequestBody TopicDto req){
        return ResponseModel.responseBuilder(MessageEnum.UPDATE_SUCCESS.getValue(), HttpStatus.OK,topicService.updateTopic(id,req),true);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTopic(){
        return ResponseModel.responseBuilder(MessageEnum.DELETE_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTopic(@PathVariable String id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicById(id),true);
    }
    @PatchMapping(value = "/approve/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> approveTopic(@PathVariable String id){
        TopicDto topicDto= topicService.approveTopic(id);
        if(topicDto==null)
            return ResponseModel.responseBuilder("Topic unfinshed.", HttpStatus.OK,null,true);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicDto,true);
    }
    @PatchMapping(value = "/userApprove/{id}")
    public ResponseEntity<?> acceptanceTopic(@PathVariable String id){
        TopicDto topicDto= topicService.userApproveTopic(id);
        if(topicDto==null)
            return ResponseModel.responseBuilder("Topic not approved yet.", HttpStatus.OK,null,true);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicDto,true);
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getTopicNoPaging(){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getAll(),true);
    }
        @GetMapping(value = "/getTopicResult/{id}")
    public ResponseEntity<?> getTopicByResult(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicByResult(id),true);
    }
    @GetMapping(value = "/getTopicField/{id}")
    public ResponseEntity<?> getTopicByField(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicByField(id),true);
    }
    @GetMapping(value = "/getTopicStatus/{id}")
    public ResponseEntity<?> getTopicByStatus(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicByStatus(id),true);
    }
    @GetMapping(value = "/getTopicUser/{id}")
    public ResponseEntity<?> getTopicByUser(@PathVariable Integer id){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicByUser(id),true);
    }
    @GetMapping(value = "/getTopic/approve/organ/")
    public ResponseEntity<?> getTopicByApproveWithOrgan(@RequestParam int page,@RequestParam int size,
                                                        @RequestParam Integer organId){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.getTopicByApproveWithOrgan(page,size,organId),true);
    }
    @GetMapping(value = "/filter")
    public ResponseEntity<?> findTopicWithFilter(@RequestParam(defaultValue ="0") int page,@RequestParam(defaultValue = "5") int size,
                                                 @RequestParam(name="topic",defaultValue = "%") String topicName,
                                                 @RequestParam(name="user",defaultValue ="%" ) String userName,
                                                 @RequestParam(name = "organ",defaultValue = "%") String organName){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,topicService.findTopicWithFilter(page, size, topicName, userName, organName),true);
    }


}
