package com.mta.topic_manager.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TopicStatusDto extends BaseDto<TopicStatusDto>{
    private String decription;
}
