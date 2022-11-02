package com.ll.mutbooks.base.email;

import com.ll.mutbooks.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Value("${mail.sender}")
    private String sender;

    @Async
    public void sendMail(Member member) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setSubject("MUTBOOKS 회원 가입을 축하합니다!");

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, false, "UTF-8");
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(member.getEmail());
        mimeMessageHelper.setText("<h1>%s님의 회원 가입을 축하합니다!!</h1>".formatted(member.getUsername()), true);
        javaMailSender.send(message);
    }
}
