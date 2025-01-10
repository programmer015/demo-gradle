package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.LibraryDTO;
import com.thinkinnovative.demo_gradle.service.LibraryService;
import com.thinkinnovative.demo_gradle.service.serviceImpl.Library1ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library1")
@RequiredArgsConstructor
public class Library1Controller {
    private final Library1ServiceImpl libraryService;

//    public Library1Controller(LibraryService libraryService) {
//        this.libraryService = libraryService;
//    }

    @PostMapping("/save")
    public ResponseEntity<String> saveLibraryAndBranch(@RequestBody LibraryDTO dto) {
        libraryService.saveLibraryAndBranch(dto);
        return ResponseEntity.ok("Library and Branch saved successfully!");
    }
}
