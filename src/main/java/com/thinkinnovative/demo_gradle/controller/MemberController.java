package com.thinkinnovative.demo_gradle.controller;

import com.thinkinnovative.demo_gradle.dto.MemberDTO;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/member")
public class MemberController {
    MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @PostMapping("/addMember")
    public ResponseEntity<String>addMember(@RequestBody MemberDTO memberDTO)
    {
        MemberTable memberTable = new MemberTable();
        memberTable.setMemberName(memberDTO.getMemberName());
        memberTable.setMembershipDate(LocalDate.now());
        memberRepository.save(memberTable);
        return ResponseEntity.ok("Member added succedsfully in library");
    }

    @GetMapping("/getMember")
    public ResponseEntity<?>getMember()
    {
        return ResponseEntity.ok(memberRepository.findAllMembers());
    }
}
