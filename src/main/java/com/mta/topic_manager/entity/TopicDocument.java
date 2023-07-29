package com.mta.topic_manager.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="topic_document")
public class TopicDocument extends Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @Column(name = "newName")
    private String newName;
    @Column(name = "fileSize",nullable = false)
    private String fileSize;
    @ManyToOne
    @JoinColumn(name="document_id")
    private DocumentType documentType;
    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;
}
