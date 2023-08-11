package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicResultDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.ITopicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/result")
@CrossOrigin(origins = "*")
public class TopicResultController {
    @Autowired
    private ITopicResultService resultService;
    @PostMapping
    public ResponseEntity<?> createResult(@RequestBody TopicResultDto req){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,resultService.createResult(req),true);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateResult(@PathVariable Integer id,@RequestBody TopicResultDto req){

        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,resultService.updateResult(id,req),true);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Integer id){
        resultService.deleteResult(id);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping("/name")
    public ResponseEntity<?> getResultByName(@RequestParam(name = "name") String name){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,resultService.getResultByName(name),true);
    }
    @GetMapping("/existsResult")
    public ResponseEntity<?> existsResult(@RequestParam String name){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,resultService.existsByName(name),true);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,resultService.getAll(),true);
    }

}
