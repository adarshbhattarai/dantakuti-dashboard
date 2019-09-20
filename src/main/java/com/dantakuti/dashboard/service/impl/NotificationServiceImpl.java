package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.config.ApplicationProperties;
import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.service.NotificationService;
import com.dantakuti.dashboard.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-10
 * @project dashboard
 */

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    EmailService emailService;

    @Autowired
    ApplicationProperties applicationProperties;

    @Override
    public boolean notifyUserByEmail(DantaUser user) throws MessagingException {
      if(applicationProperties.isNotificationEnabled()){

          emailService.sendHTMLMessage(user.getBookingDetails().get(user.getBookingDetails().size()-1),true);
      }
        return true;
    }

    @Override
    public boolean notifyAdmin(BookingDetail bookingDetail) throws MessagingException{

        if(applicationProperties.isNotificationEnabled()){

            emailService.sendHTMLMessage(bookingDetail,false);
        }

        return true;
    }

    @Override
    public void notifyAll(List<DantaUser> userList) throws MessagingException{
        for(DantaUser users : userList)
            notifyUserByEmail(users);
    }

}
