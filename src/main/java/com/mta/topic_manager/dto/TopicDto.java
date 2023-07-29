package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class TopicDto extends BaseDto{
    private Date startDate;
    private Date endDate;
    private Long expense;
    private boolean delete;
    private UserDto user;
    private TopicResultDto topicResult;
    private TopicStatusDto topicStatus;
    private TopicFiledDto topicFiled;


}
