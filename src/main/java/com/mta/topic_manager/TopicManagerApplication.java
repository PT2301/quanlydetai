package com.mta.topic_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages={"com.mta.topic_manager"})
public class TopicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicManagerApplication.class, args);
    }

}
