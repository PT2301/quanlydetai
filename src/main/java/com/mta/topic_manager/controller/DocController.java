package com.mta.topic_manager.controller;

import com.mta.topic_manager.dto.TopicDocDto;
import com.mta.topic_manager.model.MessageEnum;
import com.mta.topic_manager.model.ResponseModel;
import com.mta.topic_manager.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/doc")
@CrossOrigin(origins = "*")
public class DocController {
    @Autowired
    private IDocService docService;
    @PostMapping
    private ResponseEntity<?> createDoc(@RequestBody TopicDocDto docDto){
    return ResponseModel.responseBuilder(MessageEnum.CREATE_SUCCESS.getValue(), HttpStatus.OK,docService.createDoc(docDto),true);
    }
}
