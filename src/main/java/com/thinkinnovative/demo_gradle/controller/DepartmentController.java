package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.AddDepartmentDTO;
import com.thinkinnovative.demo_gradle.service.AddDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private final AddDepartmentService addDepartmentService;

    public String addDepartment(@RequestBody AddDepartmentDTO dto)
    {
        return addDepartmentService.addDepartment(dto);
    }


}
