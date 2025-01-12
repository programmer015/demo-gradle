package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.AddDepartmentDTO;
import com.thinkinnovative.demo_gradle.entity.Department;
import com.thinkinnovative.demo_gradle.entity.LibraryBranch;
import com.thinkinnovative.demo_gradle.repository.DepartmentRepository;
import com.thinkinnovative.demo_gradle.repository.LibraryBranchRepository;
import com.thinkinnovative.demo_gradle.service.AddDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements AddDepartmentService {

    private final LibraryBranchRepository libraryBranchRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public String addDepartment(AddDepartmentDTO dto) {

        Optional<LibraryBranch> optionallibraryBranch = libraryBranchRepository.findById(dto.getBranchId());
LibraryBranch libraryBranch = optionallibraryBranch.get();
        Department department = Department.builder()
                .department_name(dto.getDepartmentName())
                .department_code(dto.getDepartmentCode())
                .bookNumbers(dto.getBookNumbers())
                .branch(libraryBranch)
                .build();
                departmentRepository.save(department);
        return "Department is added and mapped to" + libraryBranch.getBranch_name();
    }
}