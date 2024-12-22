package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.BorrowTable1DTO;

public interface BorrowTable1Service {
    public String borrowBook(BorrowTable1DTO borrowTable1DTO); // this method will map the book and the member
}
