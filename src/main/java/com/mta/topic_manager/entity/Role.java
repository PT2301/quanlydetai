package com.mta.topic_manager.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mta.topic_manager.model.RoleEnum;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name",nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
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

    @Column(name="decription")
    private String decription;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
