package com.dantakuti.dashboard.service.email;

import com.dantakuti.dashboard.document.BookingDetail;

import javax.mail.MessagingException;

/**
 * @author adarshbhattarai on 2019-09-15
 * @project dashboard
 */
public interface EmailService {

    public void sendHTMLMessage(BookingDetail bookingDetail, boolean notifyUser) throws MessagingException;

}
