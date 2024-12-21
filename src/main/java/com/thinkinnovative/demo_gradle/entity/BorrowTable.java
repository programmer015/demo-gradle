package com.thinkinnovative.demo_gradle.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "borrow_table")
public class BorrowTable {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long borrowID;

        @ManyToOne
        @JoinColumn(name = "book_id", referencedColumnName = "bookid")
        private LibraryInformation book;

        @ManyToOne
        @JoinColumn(name = "member_id", referencedColumnName = "memberID")
        private MemberTable member;

        @Column(name = "borrow_date", nullable = false)
        private LocalDate borrowDate;


    @Column(name = "return_date")
        private LocalDate returnDate;

    public BorrowTable(Long borrowID, LibraryInformation book, MemberTable member, LocalDate borrowDate, LocalDate returnDate) {
        this.borrowID = borrowID;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowTable() {
    }

    // Getters and Setters
        public LocalDate getReturnDate() {
            return returnDate;
        }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public MemberTable getMember() {
        return member;
    }

    public void setMember(MemberTable member) {
        this.member = member;
    }

    public LibraryInformation getBook() {
        return book;
    }

    public void setBook(LibraryInformation book) {
        this.book = book;
    }

    public Long getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(Long borrowID) {
        this.borrowID = borrowID;
    }



}
