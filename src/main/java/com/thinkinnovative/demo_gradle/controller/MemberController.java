package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.MemberDTO;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberRepository memberRepository;

//    public MemberController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }


    @PostMapping("/addMember")
    public ResponseEntity<String>addMember(@RequestBody MemberDTO memberDTO)
    {
//        MemberTable memberTable = new MemberTable();
//        memberTable.setMemberName(memberDTO.getMemberName());
//        memberTable.setMembershipDate(LocalDate.now());
//        memberRepository.save(memberTable);

        MemberTable email = memberRepository.findMemberEntityByEmail(memberDTO.getEmail());
        if (email != null)
        {
            return ResponseEntity.ok("Email is already present");
        }
        else {
            MemberTable memberTable = MemberTable.builder()
                    .memberName(memberDTO.getMemberName())
                    .email(memberDTO.getEmail())
                    .membershipDate(LocalDate.now())
                    .build();
            memberRepository.save(memberTable);
            return ResponseEntity.ok("Member added successfully in library");
        }
    }

    @GetMapping("/getMember")
    public ResponseEntity<?>getMember()
    {
        return ResponseEntity.ok(memberRepository.findAllMembers());
    }
}
