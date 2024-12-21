package com.thinkinnovative.demo_gradle.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="member_table")
public class MemberTable {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long memberID;

        @Column(name = "member_name", nullable = false)
        private String memberName;

        @Column(name = "membership_date", nullable = false)
        private LocalDate membershipDate;

    @OneToMany(mappedBy = "member")
    private List<BorrowTable> borrowRecords;

    public MemberTable() {

    }

    public MemberTable(Long memberID, String memberName, LocalDate membershipDate, List<BorrowTable> borrowRecords) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.membershipDate = membershipDate;
        this.borrowRecords = borrowRecords;
    }

    // Getters and Setters

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public List<BorrowTable> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(List<BorrowTable> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }




}
