package com.mta.topic_manager.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {
    public String id;
    public String name;
    private Date startDate;
    private Date endDate;
    private Long expense;
    private boolean delete;
    private UserDto user;
    private OrganDto organ;
    private TopicResultDto topicResult;
    private TopicStatusDto topicStatus;
    private TopicFieldDto topicField;

    private String createBy;
    private Date createDate;
    private String editBy;
    private Date editDate;


}
