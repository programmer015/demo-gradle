package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.QueueDTO;
import com.thinkinnovative.demo_gradle.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepository extends JpaRepository <Queue, Integer> {

    @Query("SELECT new com.thinkinnovative.demo_gradle.dto.QueueDTO(" +
                    "q.queue_id, q.member_id, q.position)" +
                 "FROM Queue q WHERE q.libraryInformation.bookID = :bookID")
    List<QueueDTO> findByQueueIdOrderByAsec(@Param("bookID") Integer bookID);


    //List<QueueDTO> findByQueueIdOrderByAsec(@Param("bookID") Integer bookID);



}
