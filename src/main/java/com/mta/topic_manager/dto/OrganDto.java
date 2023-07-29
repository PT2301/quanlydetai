package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrganDto extends BaseDto{
    private String decription;
    private String address;
    private String email;
}
