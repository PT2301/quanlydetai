package com.mta.topic_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDto extends BaseDto<UserDto>{
 private String email;
 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 private String pass;
 private Date birth;
 private String gender;
 private boolean status;
 private OrganDto organ;
 private Set<RoleDto> roles;
 private Set<DegreeDto> degrees;
}
