package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrganDto extends BaseDto<OrganDto>{
    private String decription;
    private String address;
    private String email;

}
