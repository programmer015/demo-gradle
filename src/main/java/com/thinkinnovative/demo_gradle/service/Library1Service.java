package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.LibraryDTO;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public interface Library1Service {

    public void saveLibraryAndBranch(LibraryDTO dto);
}
