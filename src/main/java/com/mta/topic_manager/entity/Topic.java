package com.mta.topic_manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="topic")
public class Topic extends Base{
    @Column(name="start_date",nullable = false)
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date startDate;
    @Column(name="end_date",nullable = false)
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date endDate;
    @Column(name="expense",nullable = false)
    private long expense;
    @Column(name="delete",nullable = false)
    private boolean delete;

    @OneToMany(mappedBy = "topic")
    private List<TopicDoc> topicDocs;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="organ_id",nullable = false)
    private Organ organ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="topicField_id",nullable = false)
    private TopicField topicField;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="topicStatus_id",nullable = false)
    private TopicStatus topicStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="topicResult_id",nullable = false)
    private  TopicResult topicResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;






}
