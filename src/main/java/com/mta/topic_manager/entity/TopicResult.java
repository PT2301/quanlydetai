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
@Table(name="topic_result")
public class TopicResult extends  Base{
    @Column(name = "decription",nullable = false)
    private String decription;
    @OneToMany(mappedBy = "topicResult")
    private List<Topic> topics;
}
