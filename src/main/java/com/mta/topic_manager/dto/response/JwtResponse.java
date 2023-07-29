package com.mta.topic_manager.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type="Bearer ";
    private String id;
    private String email;
    private String name;
    private List<String> listRoles;

    public JwtResponse(String token,String id, String email, String name, List<String> listRoles) {
        this.token = token;
        this.id=id;
        this.email = email;
        this.name = name;
        this.listRoles = listRoles;
    }
}
