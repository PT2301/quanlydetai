package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
