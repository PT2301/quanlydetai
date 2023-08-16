package com.mta.topic_manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="topic")
public class Topic{
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name",nullable = false,unique = true)
    private String name;
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


    @Column(name="create_date")
    @CreatedDate
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date createDate;
    @Column(name="edit_date")
    @LastModifiedDate
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date editDate;
    @Column(name="create_by")
    @CreatedBy
    private String createBy;
    @Column(name="edit_by")
    @LastModifiedBy
    private String editBy;

}
