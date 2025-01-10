package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.LibraryDTO;
import com.thinkinnovative.demo_gradle.entity.Library;
import com.thinkinnovative.demo_gradle.entity.LibraryBranch;
import com.thinkinnovative.demo_gradle.repository.Library1Repository;
import com.thinkinnovative.demo_gradle.repository.LibraryBranchRepository;
import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Library1ServiceImpl {
    private final Library1Repository libraryRepository;
    private final LibraryBranchRepository libraryBranchRepository;

//    public Library1ServiceImpl(LibraryRepository libraryRepository, LibraryBranchRepository libraryBranchRepository) {
//        this.libraryRepository = libraryRepository;
//        this.libraryBranchRepository = libraryBranchRepository;
//    }

    public void saveLibraryAndBranch(LibraryDTO dto) {
        // Create and save LibraryBranch
        LibraryBranch branch = LibraryBranch.builder()
                .branch_code(dto.getBranchCode())
                .branch_name(dto.getBranchName())
                .branch_address(dto.getBranchAddress())
                .openingTime(dto.getBranchOpeningTime())
                .closingTime(dto.getBranchClosingTime())
                .year(dto.getBranchYear())
                .build();
        branch.calculateHours(); // Calculate hours before saving
        LibraryBranch savedBranch = libraryBranchRepository.save(branch);

        // Create and save Library
        Library library = Library.builder()
                .libraryName(dto.getLibraryName())
                .libraryCode(dto.getLibraryCode())
                .address(dto.getLibraryAddress())
                .openingTime(dto.getLibraryOpeningTime())
                .closingTime(dto.getLibraryClosingTime())
                .totalBranches(dto.getLibraryTotalBranches())
                .branch(savedBranch) // Set the saved branch
                .build();
        library.calculateHours(); // Calculate hours before saving
        libraryRepository.save(library);
    }
}
