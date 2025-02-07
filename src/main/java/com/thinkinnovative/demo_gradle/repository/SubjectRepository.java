package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
