package com.mta.topic_manager.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="topic_status")
public class TopicStatus extends Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @OneToMany(mappedBy = "topicStatus")
    private List<Topic> topics;
}
