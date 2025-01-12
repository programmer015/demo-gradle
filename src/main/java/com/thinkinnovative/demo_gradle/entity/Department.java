package com.thinkinnovative.demo_gradle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "department_code")
    private String department_code;

    @Column(name = "book_number")
    private Integer bookNumbers;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private LibraryBranch branch;
}
