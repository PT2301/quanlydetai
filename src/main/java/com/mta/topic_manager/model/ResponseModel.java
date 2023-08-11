package com.mta.topic_manager.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseModel {
    public static <T> ResponseEntity responseBuilder(String responseMessage, HttpStatus responseStatus, T responseObject, boolean isSuccess) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", responseMessage);
        response.put("httpStatus", responseStatus);
        response.put("success", isSuccess);
        if (!isSuccess) {
            response.put("time", new Date());
        } else {
            response.put("object", responseObject);
        }
        return new ResponseEntity<>(response, responseStatus);
    }
}
