package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.BorrowTable1DTO;
import com.thinkinnovative.demo_gradle.entity.BorrowTable1;
import com.thinkinnovative.demo_gradle.service.serviceImpl.BorrowTable1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowTable1Controller {

    BorrowTable1ServiceImpl borrowTable1Service;
    @Autowired
    public BorrowTable1Controller(BorrowTable1ServiceImpl borrowTable1Service) {
        this.borrowTable1Service = borrowTable1Service;
    }

   @PostMapping("/book")
    public String borrowBook(@RequestBody BorrowTable1DTO borrowTable1DTO)
    {
        BorrowTable1 alreadyPresent = borrowTable1Service.findBooksByBookidAndMemberid(borrowTable1DTO.getBookId(), borrowTable1DTO.getMemberId());
        if (alreadyPresent == null){
            return borrowTable1Service.borrowBook(borrowTable1DTO);
        }
        else {
            return "The book is already borrowed";
        }

    }

    @PostMapping("/bookReturn")
    public String returnBook(@RequestBody BorrowTable1DTO borrowTable1DTO)
    {
        BorrowTable1 alreadyPresent = borrowTable1Service.findBooksByBookidAndMemberid(borrowTable1DTO.getBookId(), borrowTable1DTO.getMemberId());
        if (alreadyPresent == null){
            //return borrowTable1Service.returnBook(alreadyPresent);
            return "The book is not borrowed";
        }
        else {
            return borrowTable1Service.returnBook(alreadyPresent);


        }

    }

    @PostMapping("/booksByMember")
    public List<BorrowTable1DTO> borrowBook(@RequestBody Map<String, Integer> request)
    {
        Integer memberID = request.get("memberID");
        return borrowTable1Service.borrowBookByMember(memberID);
    }



}
