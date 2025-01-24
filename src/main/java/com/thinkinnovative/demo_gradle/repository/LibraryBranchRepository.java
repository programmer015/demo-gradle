package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.DepartmentListDTO;
import com.thinkinnovative.demo_gradle.dto.LibraryBranchListDTO;
import com.thinkinnovative.demo_gradle.entity.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Integer> {

    @Query("SELECT new com.thinkinnovative.demo_gradle.dto.LibraryBranchListDTO(" +
            "l.branchId, l.branchCode, l.branchName, l.branchAddress, l.openingTime, l.closingTime, l.hours, l.year) FROM LibraryBranch l")
    List<LibraryBranchListDTO> findAllBranch();
}
