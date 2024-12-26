package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.BookDTO;
import com.thinkinnovative.demo_gradle.dto.MemberDTO;
import com.thinkinnovative.demo_gradle.dto.MemberListDTO;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberTable, Integer>{
    @Query("SELECT new com.thinkinnovative.demo_gradle.dto.MemberListDTO(" +
            "m.memberID, m.memberName, m.membershipDate) " +
            "FROM MemberTable m")
    List<MemberListDTO> findAllMembers();


}