package com.mta.topic_manager.security.userscurity;

import com.mta.topic_manager.entity.User;
import com.mta.topic_manager.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("email not found");
        }
        return UserDetailsimpl.mapUserToUserDetails(user);
    }
}
