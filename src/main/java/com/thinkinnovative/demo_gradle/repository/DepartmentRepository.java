package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department, Integer> {
}
