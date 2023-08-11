package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicFieldDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.ITopicFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/field")
@CrossOrigin(origins = "*")
public class TopicFieldController {
    @Autowired
    private ITopicFieldService fieldService;

    @PostMapping
    public ResponseEntity<?> createFile(@RequestBody TopicFieldDto req){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,fieldService.createField(req),true);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateFile(@PathVariable Integer id,@RequestBody TopicFieldDto req ){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,fieldService.updateField(id,req),true);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id){
        fieldService.deleteField(id);
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,null,true);
    }
    @GetMapping("/name")
    public ResponseEntity<?> getFileByName(@RequestParam String name){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,fieldService.getFieldByName(name),true);
    }
    @GetMapping("/existsField")
    public ResponseEntity<?> existsFile(@RequestParam String name){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,fieldService.existsByName(name),true);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseModel.responseBuilder(MessageEnum.REQUEST_SUCCESS.getValue(), HttpStatus.OK,fieldService.getAll(),true);
    }
    
}
