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
@Table(name="organ")
public class Organ extends Base{
    @Column(name = "discription")
    private String discription;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "organ")
    private List<User> users;
}
