package com.dantakuti.dashboard.service;

import java.util.Date;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-18
 * @project dashboard
 */
public interface ApptBookedDateTimeService {

    public List<String> getAvailableTime(Date date);

    void register(Date appointmentDate, String appointmentTime);
}
