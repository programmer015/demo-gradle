package com.thinkinnovative.demo_gradle.dto;

import com.thinkinnovative.demo_gradle.entity.MemberTable;
import lombok.Data;

@Data
public class AuthRequestDTO {
    private String username;
    private String password;
    private String email;
    private String role;
    private Integer memberId;
}
