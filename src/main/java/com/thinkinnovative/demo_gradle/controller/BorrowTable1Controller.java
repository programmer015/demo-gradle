package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.BorrowTable1DTO;
import com.thinkinnovative.demo_gradle.service.serviceImpl.BorrowTable1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return borrowTable1Service.borrowBook(borrowTable1DTO);
    }



}
