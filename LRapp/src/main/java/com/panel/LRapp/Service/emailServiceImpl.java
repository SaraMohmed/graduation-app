package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class emailServiceImpl implements emailService{
    private JavaMailSender javaMailSender;

    @Autowired
    public emailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void setCodeByMail(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("glowgo32@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("code to reset password from Glow&Go App");
        simpleMailMessage.setText(Integer.toString(mail.getCode()));
        javaMailSender.send(simpleMailMessage);
    }
}
