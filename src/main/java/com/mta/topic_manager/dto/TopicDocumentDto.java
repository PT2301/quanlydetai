package com.mta.topic_manager.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TopicDocumentDto extends BaseDto {
    private String decription;
    private String newName;
    private String fileSize;
    private DocumentTypeDto documentType;
    private TopicDto topic;
}

