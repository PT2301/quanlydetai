package com.mta.topic_manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="create_date",nullable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date createDate;

    @Column(name="edit_date",nullable = false)
    @LastModifiedDate
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date editDate;

    @Column(name="create_by",nullable = false)
    @CreatedBy
    private String createBy;
    @Column(name="edit_by",nullable = false)
    @LastModifiedBy
    private String editBy;
}
