package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.BorrowTableDTO;
import com.thinkinnovative.demo_gradle.entity.BorrowTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowTableRepository extends JpaRepository<BorrowTable, Long> {
}
