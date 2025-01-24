package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.LibraryBranchListDTO;
import com.thinkinnovative.demo_gradle.service.serviceImpl.LibraryBranchServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryBranchController {

    private final LibraryBranchServiceImpl libraryBranchService;

    @GetMapping("/listBranch")
    public List<LibraryBranchListDTO> listBranch()
    {
        return  libraryBranchService.listBranch();
    }
}
