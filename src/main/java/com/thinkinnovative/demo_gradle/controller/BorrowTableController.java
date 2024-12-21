package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.BorrowTableDTO;
import com.thinkinnovative.demo_gradle.entity.BorrowTable;
import com.thinkinnovative.demo_gradle.entity.LibraryInformation;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.repository.BorrowTableRepository;
import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/borrow")
public class BorrowTableController {

   private final  BorrowTableRepository borrowTableRepository;
    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;
    //@Autowired
    public BorrowTableController(BorrowTableRepository borrowTableRepository, LibraryRepository libraryRepository, MemberRepository memberRepository) {
        this.borrowTableRepository = borrowTableRepository;
        this.libraryRepository = libraryRepository;
        this.memberRepository = memberRepository;
    }





    @PostMapping("/book")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowTableDTO borrowTableDTO)
    {
        Optional<LibraryInformation> bookOpt = libraryRepository.findById(borrowTableDTO.getBook());
        if (bookOpt.isEmpty()) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        Optional<MemberTable> memberOpt = memberRepository.findById(borrowTableDTO.getMember());
        if (memberOpt.isEmpty()) {
            return new ResponseEntity<>("member not found", HttpStatus.NOT_FOUND);
        }
        BorrowTable borrowTable = new BorrowTable();
        borrowTable.setBook(bookOpt.get());
        borrowTable.setMember(memberOpt.get());
        borrowTable.setBorrowDate(LocalDate.now());

        borrowTableRepository.save(borrowTable);

        return ResponseEntity.ok("The book borrowed successfully");
    }
}
