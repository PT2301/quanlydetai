package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepository extends JpaRepository<Topic,Integer> {
}
