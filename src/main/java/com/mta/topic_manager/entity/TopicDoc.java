package com.mta.topic_manager.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="topic_document")
public class TopicDoc extends Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @Column(name = "newName")
    private String newName;
    @Column(name = "fileSize",nullable = false)
    private String fileSize;
    @ManyToOne
    @JoinColumn(name="document_id")
    private DocType docType;
    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;
}
