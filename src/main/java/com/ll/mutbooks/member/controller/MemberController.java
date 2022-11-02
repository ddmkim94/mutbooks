package com.ll.mutbooks.member.controller;

import com.ll.mutbooks.member.entity.Member;
import com.ll.mutbooks.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String signUpForm() {
        return "/member/sign-up";
    }

    @PostMapping("/join")
    public String signUp(Member member) throws MessagingException {
        memberService.join(member);

        // 메일 발송
        return "redirect:/";
    }
}
