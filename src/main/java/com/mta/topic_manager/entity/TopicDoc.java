package com.mta.topic_manager.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="topic_document")
public class TopicDoc{
    @Id
    @Column(name="code")
    private String code;
    @Column(name="name",nullable = false,unique = true)
    private String name;
    @Column(name = "serverName",nullable = false,unique = true)
    private String serverName;
    @Column(name = "decription",nullable = false)
    private String decription;
    @Column(name = "fileSize",nullable = false)
    private String fileSize;

    @ManyToOne
    @JoinColumn(name="document_id")
    private DocType docType;
    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;


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
