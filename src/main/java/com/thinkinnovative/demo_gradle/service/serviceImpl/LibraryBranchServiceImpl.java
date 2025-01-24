package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.LibraryBranchListDTO;
import com.thinkinnovative.demo_gradle.repository.LibraryBranchRepository;
import com.thinkinnovative.demo_gradle.service.LibraryBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LibraryBranchServiceImpl implements LibraryBranchService {

   private final LibraryBranchRepository libraryBranchRepository;

    @Override
    public List<LibraryBranchListDTO> listBranch() {
        return libraryBranchRepository.findAllBranch();
    }
}
