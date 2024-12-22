package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.BorrowTable1DTO;
import com.thinkinnovative.demo_gradle.entity.BorrowTable1;
import com.thinkinnovative.demo_gradle.entity.LibraryInformation;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.repository.BorrowTable1Repository;
import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import com.thinkinnovative.demo_gradle.service.BorrowTable1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowTable1ServiceImpl implements BorrowTable1Service {

    LibraryRepository libraryRepository;
    BorrowTable1Repository borrowTable1Repository;
    MemberRepository memberRepository;
    @Autowired
    public BorrowTable1ServiceImpl(LibraryRepository libraryRepository, BorrowTable1Repository borrowTable1Repository, MemberRepository memberRepository) {
        this.libraryRepository = libraryRepository;
        this.borrowTable1Repository = borrowTable1Repository;
        this.memberRepository = memberRepository;
    }


    @Override
    public String borrowBook(BorrowTable1DTO borrowTable1DTO) {
        BorrowTable1 borrowTable1 = new BorrowTable1();

        try {


            Optional<LibraryInformation> library = libraryRepository.findById(Long.valueOf(borrowTable1DTO.getBookId()));
            if (library.isEmpty()) {
                return "Book with ID " + borrowTable1DTO.getBookId() + " not found.";
            }
            LibraryInformation library1 = library.get();
            // Check stock availability
            if (library1.getStock() <= 0) {
                return "The book with ID " + borrowTable1DTO.getBookId() + " is out of stock.";

            }


            borrowTable1.setBook(library.get());
            Optional<MemberTable> member = memberRepository.findById(Long.valueOf(borrowTable1DTO.getMemberId()));
            if (member.isEmpty()) {
                return "Member with ID " + borrowTable1DTO.getMemberId() + " not found.";
            }
            library1.setStock(library1.getStock() - 1);
            libraryRepository.save(library1);
            //borrowTable1.setBook(library.get());
            borrowTable1.setMember(member.get());
            borrowTable1.setBorrowDate(LocalDate.now());
            borrowTable1Repository.save(borrowTable1);

            return "The book borrowed successfully";
        }
        catch (Exception e)
        {
           // e.printStackTrace();
            return "An error occurred while borrowing the book: " + e.getMessage();
        }
    }
}
