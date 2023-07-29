package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum GenderEnum {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");
    private final String value;
}
