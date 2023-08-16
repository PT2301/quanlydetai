package com.mta.topic_manager.security.userscurity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mta.topic_manager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailsimpl implements UserDetails {
    private int id;
    private String email;
    private String name;
    @JsonIgnore
    private String password;
    private boolean status;
    private Collection<? extends  GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    //tu thong tin user chuyen sang thong tin userdetail
    public static UserDetails mapUserToUserDetails (User user){
        List<GrantedAuthority> listAuthorities= user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserDetailsimpl(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPass(),
                user.isStatus(),
                listAuthorities);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
