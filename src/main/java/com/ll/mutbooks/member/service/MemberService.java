package com.ll.mutbooks.member.service;

import com.ll.mutbooks.base.email.EmailService;
import com.ll.mutbooks.member.entity.AuthLevel;
import com.ll.mutbooks.member.entity.Member;
import com.ll.mutbooks.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    // 회원 가입
    public Member join(Member member) throws MessagingException {
        validateDuplicateMember(member);

        Member saveMember = Member.builder()
                .username(member.getUsername())
                .password(passwordEncoder.encode(member.getPassword()))
                .nickname(member.getNickname())
                .email(member.getEmail())
                .authLevel(member.getNickname().length() == 0 ? AuthLevel.USER : AuthLevel.AUTHOR)
                .build();

        memberRepository.save(saveMember);
        emailService.sendMail(saveMember);

        return saveMember;
    }

    // 중복 회원 판별
    private void validateDuplicateMember(Member member) {
        Member members = memberRepository.findByUsernameOrEmail(member.getUsername(), member.getEmail());
        if (members != null) {
            throw new IllegalStateException("이미 가입된 회원이 존재합니다.");
        }
    }
}
