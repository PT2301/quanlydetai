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
@Table(name="degree")
public class Degree extends Base {
    @Column(name="decription")
    private String decription;
    @ManyToMany(mappedBy = "degrees")
    private List<User> users;

}
