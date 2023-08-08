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
@Table(name="organ")
public class Organ extends Base{
    @Column(name = "decription")
    private String decription;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "organ")
    private List<User> users;
}
