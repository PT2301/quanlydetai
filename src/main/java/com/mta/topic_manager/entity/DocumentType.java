package com.mta.topic_manager.entity;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="document_type")
public class DocumentType extends Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @OneToMany(mappedBy ="documentType")
    private List<TopicDocument> topicDocuments;
}
