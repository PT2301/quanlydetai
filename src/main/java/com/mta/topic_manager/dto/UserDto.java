package com.mta.topic_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
public class UserDto extends BaseDto{
 private String email;
 private String pass;
 private Date birth;
 private String gender;
 private String status;
 private OrganDto organ;
 private Set<RoleDto> role;
 private DegreeDto degree;
}
