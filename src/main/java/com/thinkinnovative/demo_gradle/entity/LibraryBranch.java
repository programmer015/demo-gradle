package com.thinkinnovative.demo_gradle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "branch")
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branch_id;

    @Column(name = "branch_code")
    private String branch_code;

    @Column(name = "branch_name")
    private String branch_name;

    @Column(name = "branch_address")
    private String branch_address;

    @Column(name = "open_time")
    private LocalTime openingTime;

    @Column(name = "close_time")
    private LocalTime closingTime;

    @Column(name = "hours", nullable = false)
    private Integer hours;
    @Column(name = "year")
    private Integer year;

//    @OneToMany(mappedBy = "branch",  cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Department> department = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void calculateHours() {
        if (openingTime != null && closingTime != null) {
            this.hours = (int) Duration.between(openingTime, closingTime).toHours();
        }
    }
}
