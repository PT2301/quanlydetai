package com.mta.topic_manager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@SuperBuilder

public class JwtResponse {
    private String token;
    private String type="Bearer ";
    private int id;
    private String email;
    private String name;
    private boolean status;
    private List<String> listRoles;
    private Date dateExpried;


    public JwtResponse(String token, int id, String email, String name, boolean status, List<String> listRoles, Date dateExpried) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.name = name;
        this.status = status;
        this.listRoles = listRoles;
        this.dateExpried = dateExpried;
    }

    public JwtResponse() {
    }
}
