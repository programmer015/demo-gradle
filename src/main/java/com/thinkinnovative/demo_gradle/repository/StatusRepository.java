package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.StatusInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusInformation, Long> {
}
