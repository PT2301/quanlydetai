package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByName(String name);
    Optional<User> findById(Integer id);
    @Query(value = "select u from User u where u.organ.name like %:organ% and :role in u.roles and u.status=true")
    Page<User> getUserByOrgan(@Param("organ") String organ,@Param("role") String role, Pageable p);


}
