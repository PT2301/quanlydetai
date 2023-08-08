package com.mta.topic_manager.dto.request;

import com.mta.topic_manager.dto.DegreeDto;
import com.mta.topic_manager.dto.OrganDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 10,max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 8,max = 30)
    private String password;
    @NotBlank
    @Size(min = 5)
    private String name;
    @NotNull
    private OrganDto organ;
    @NotNull
    private Date birth;
    @NotNull
    private String gender;
    private Set<DegreeDto> degree;
    @NotEmpty
    private Set<String> roles;
}

