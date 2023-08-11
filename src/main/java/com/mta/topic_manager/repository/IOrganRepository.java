package com.mta.topic_manager.repository;

import com.mta.topic_manager.entity.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrganRepository extends JpaRepository<Organ,Integer> {
    Optional<Organ> findById(Integer id);
}
