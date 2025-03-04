package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.StatusTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTableRepository extends JpaRepository<StatusTable, Long> {

}
