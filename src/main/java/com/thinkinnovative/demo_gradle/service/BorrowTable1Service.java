package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.BorrowTable1DTO;
import com.thinkinnovative.demo_gradle.entity.BorrowTable1;

import java.util.List;

public interface BorrowTable1Service {
    public String borrowBook(BorrowTable1DTO borrowTable1DTO); // this method will map the book and the member
    public List<BorrowTable1DTO> borrowBookByMember(Integer memberID);
    public BorrowTable1 findBooksByBookidAndMemberid(Integer bookid, Integer memberId);
    public String returnBook(BorrowTable1 borrowTable1);
}
