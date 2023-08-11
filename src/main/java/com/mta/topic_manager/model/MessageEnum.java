package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum MessageEnum {
    REQUEST_SUCCESS("Request Success"),
    REQUEST_FAIL("Request Fail"),
    USER_DISABLED("User is disabled"),
    USER_UNAUTHORIZED("Can not authenticate user"),
    UPDATE_SUCCESS("Update Success"),
    DELETE_SUCCESS("Delete Success"),
    CREATE_SUCCESS("Create Success");

    private final String value;
}
