package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class DocTypeDto extends BaseDto<DocTypeDto>{
    private String decription;
    private String tail;
}
