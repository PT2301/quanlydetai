package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.TopicResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITopicResultRepository extends JpaRepository<TopicResult,Integer> {
    boolean existsByName(String name);
    Optional<TopicResult> findByName(String name);
}
