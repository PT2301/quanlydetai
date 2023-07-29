package com.mta.topic_manager.dto.request;


import lombok.*;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SignInRequest {
    @NotBlank
    @Email
    @Size(min=10,max=30)
    private String email;
    @NotBlank
    @Size(min=8,max=30)
    private String password;
}
