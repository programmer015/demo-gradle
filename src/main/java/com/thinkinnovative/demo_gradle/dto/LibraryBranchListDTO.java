package com.thinkinnovative.demo_gradle.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryBranchListDTO {
    private Integer branchId;
    private String branchCode;
    private String branchName;
    private String branchAddress;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Integer hours;
    private Integer year;
}
