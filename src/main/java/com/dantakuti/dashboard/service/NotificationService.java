package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.BookingDetail;
import com.dantakuti.dashboard.document.DantaUser;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-10
 * @project dashboard
 */
public interface NotificationService {

    public boolean notifyUserByEmail(DantaUser user) throws MessagingException;
    public boolean notifyAdmin(BookingDetail bookingDetail) throws  MessagingException;
    public void notifyAll(List<DantaUser> userList) throws  MessagingException;

}
