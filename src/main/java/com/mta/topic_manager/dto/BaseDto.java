package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class BaseDto {
    private Integer id;
    private String name;
    private String createBy;
    private Date createDate;
    private String editBy;
    private Date editDate;
}
