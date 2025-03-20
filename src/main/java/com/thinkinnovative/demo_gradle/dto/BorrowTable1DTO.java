package com.thinkinnovative.demo_gradle.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class BorrowTable1DTO {
    private Integer bookId;
    private String bookName;
    //@JsonIgnore
    private Integer memberId;
    private String memberName;
    private LocalDate date;
    public BorrowTable1DTO(Integer bookId, String bookName, LocalDate date) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }


}
