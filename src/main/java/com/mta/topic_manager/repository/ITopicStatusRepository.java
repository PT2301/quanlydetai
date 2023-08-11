package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.TopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITopicStatusRepository extends JpaRepository<TopicStatus,Integer> {
    Optional<TopicStatus> findByName(String name);
    boolean existsByName(String name);
}
