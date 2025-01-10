package com.thinkinnovative.demo_gradle.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryDTO {

    // Library fields
    private String libraryName;
    private String libraryCode;
    private String libraryAddress;
    private LocalTime libraryOpeningTime;
    private LocalTime libraryClosingTime;
    private Integer libraryTotalBranches;

    // Branch fields
    private String branchCode;
    private String branchName;
    private String branchAddress;
    private LocalTime branchOpeningTime;
    private LocalTime branchClosingTime;
    private Integer branchYear;

}
