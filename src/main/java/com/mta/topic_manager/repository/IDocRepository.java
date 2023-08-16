package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.TopicDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocRepository extends JpaRepository<TopicDoc,String> {
}
