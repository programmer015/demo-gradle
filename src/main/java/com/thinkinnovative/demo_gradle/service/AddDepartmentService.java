package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.AddDepartmentDTO;
import com.thinkinnovative.demo_gradle.dto.DepartmentListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddDepartmentService {

    public String addDepartment(AddDepartmentDTO dto);
    public Page<DepartmentListDTO> findAllDepartments(Integer branchid, Pageable pageable);
    public DepartmentListDTO findByDepartmentId(Integer departmentId);
    public DepartmentListDTO findByDepartmentName(String departmentName);
}
