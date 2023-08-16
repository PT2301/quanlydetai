package com.mta.topic_manager.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TopicDocDto{
    private String code;
    private String name;
    private String serverName;
    private String decription;
    private String fileSize;

    private DocTypeDto docType;
    private TopicDto topic;

    private String createBy;
    private Date createDate;
    private String editBy;
    private Date editDate;
}

