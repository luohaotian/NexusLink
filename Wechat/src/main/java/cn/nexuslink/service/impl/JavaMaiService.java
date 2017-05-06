package cn.nexuslink.service.impl;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by 罗浩 on 2017/5/6.
 */
@Service("javaMailService")
public class JavaMaiService {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private JavaMailSender javaMailSender;

    private static  String from = "863149924@qq.com";

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            javaMailSender.send(message);
            logger.info("已经向" + to + "发送了邮件！");
        } catch (Exception e) {
            logger.info("向"+to+"发送邮件时发生异常！");
        }
    }

    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(content, true);
            helper.setSubject(subject);

            javaMailSender.send(message);
            logger.info("邮件发送成功！");
        } catch (MessagingException e) {
            logger.info("发送邮件时出现异常！");
        }
    }



    //得到找回密码的html内容



}
