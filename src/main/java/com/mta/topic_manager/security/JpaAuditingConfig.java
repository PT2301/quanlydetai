package com.mta.topic_manager.security;

import com.mta.topic_manager.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")//config vc lay time va name ng tao tu dong
public class JpaAuditingConfig {
    @Autowired
    private IUserRepository userRepository;
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public  class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return Optional.ofNullable(username);
        }
    }
}
