package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString

public class TopicResultDto extends BaseDto<TopicResultDto>{
    private String decription;
}
