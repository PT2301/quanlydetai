package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITopicRepository extends JpaRepository<Topic,String> {
    List<Topic> findByTopicResult(TopicResult a);
    List<Topic> findByTopicStatus(TopicStatus a);
    List<Topic> findByTopicField(TopicField a);
    List<Topic> findByUser(User a);
//    Page<Topic> findByOrgan(Organ organ, Pageable p);
    @Query(value = "select t from Topic  t where t.organ=:organ and t.delete=false")
    Page<Topic> findByOrgan(@Param("organ") Organ organ, Pageable p);
    @Query(value ="select  t from Topic t where t.name like %:topic% and t.user.name like %:user% and t.organ.name like %:organ% and t.delete=false" )
    Page<Topic> findTopicWithFilter(@Param("topic") String topicName,
                                    @Param("user") String userName,
                                    @Param("organ") String organName,
                                    Pageable p);

}
