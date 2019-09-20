package com.dantakuti.dashboard.service.email.impl;

import com.dantakuti.dashboard.config.ApplicationProperties;
import com.dantakuti.dashboard.constants.DantaAppConstants;
import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.service.email.EmailService;
import com.dantakuti.dashboard.service.email.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author adarshbhattarai on 2019-09-15
 * @project dashboard
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ApplicationProperties properties;

    @Autowired
    MailContentBuilder mailContentBuilder;


    public void sendHTMLMessage(BookingDetail bookingDetail, boolean notifyUser) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(properties.getNoReplyEmail());
        if(notifyUser)
            prepareUserEmail(helper, bookingDetail);
        else
            prepareAdminEmail(helper, bookingDetail);
        javaMailSender.send(message);
        System.out.println("Message Sent");
    }

    private void prepareAdminEmail(MimeMessageHelper helper, BookingDetail bookingDetail) throws MessagingException {

        helper.setTo(properties.getDatakutiEmailId());
        helper.setSubject(properties.getEmailAdminSubject());
        String content = mailContentBuilder.build(bookingDetail,DantaAppConstants.ADMIN_EMAIL_TEMPLATE);
        helper.setText(content,true);
    }

    private void prepareUserEmail(MimeMessageHelper helper, BookingDetail bookingDetail) throws MessagingException {

        helper.setTo(bookingDetail.getEmail());
        helper.setSubject(properties.getEmailUserSubject());
        String content = mailContentBuilder.build(bookingDetail, DantaAppConstants.USER_EMAIL_TEMPLATE);
        helper.setText(content,true);
    }

}
