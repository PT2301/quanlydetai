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
@Table(name="topic_field")
public class TopicField extends  Base {
    @Column(name = "decription",nullable = false)
    private String decription;
    @OneToMany(mappedBy = "topicField")
    private List<Topic> topics;

}
