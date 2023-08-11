package com.mta.topic_manager.entity;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="document_type")
public class DocType extends Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @Column(name = "tail",nullable = false,unique = true)
    private String tail;
    @OneToMany(mappedBy ="documentType")
    private List<TopicDoc> topicDocs;
}
