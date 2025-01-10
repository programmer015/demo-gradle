package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Integer> {

}
