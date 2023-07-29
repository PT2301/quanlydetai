package com.mta.topic_manager.entity;

import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User extends Base{
    @Column(name="email",nullable = false,unique = false)
    private String email;
    @Column(name="pass",nullable = false)
    private String pass;
    @Column(name="birth")
    private Date birth;
    @Column(name="gender")
    private String gender;
    @Column(name="status",nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "user")
    private List<Topic> topics;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="organ_id",nullable = false)
    private Organ organ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_degree",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "degree_id",referencedColumnName = "id"))
    private List<Degree> degrees;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roles;
}
