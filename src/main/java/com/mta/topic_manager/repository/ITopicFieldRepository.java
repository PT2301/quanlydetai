package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.TopicField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITopicFieldRepository extends JpaRepository<TopicField,Integer> {
    boolean existsByName(String name);
    Optional<TopicField> findByName(String name);
}
