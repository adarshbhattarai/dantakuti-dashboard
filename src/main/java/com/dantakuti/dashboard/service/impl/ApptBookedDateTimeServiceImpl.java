package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.config.ApplicationProperties;
import com.dantakuti.dashboard.document.ApptBookedDateTime;
import com.dantakuti.dashboard.repository.ApptBookedDateTimeRepository;
import com.dantakuti.dashboard.service.ApptBookedDateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author adarshbhattarai on 2019-09-18
 * @project dashboard
 */
@Service
public class ApptBookedDateTimeServiceImpl implements ApptBookedDateTimeService {

    @Autowired
    ApptBookedDateTimeRepository apptBookedDateTimeRepository;

    @Autowired
    ApplicationProperties applicationProperties;

    @Override
    public List<String> getAvailableTime(Date date){
        ApptBookedDateTime bookedDateTime = apptBookedDateTimeRepository.findByDate(date);
        List<String> amTime = Arrays.asList(applicationProperties.getAppointmentTimeAm().split(","));
        List<String> pmTime = Arrays.asList(applicationProperties.getAppointmentTimePm().split(","));
        List<String> allTimes = new ArrayList<>();
        allTimes.addAll(pmTime);
        allTimes.addAll(amTime);
        if(bookedDateTime == null){
            return allTimes;
        }
        List<String> bookedTime = bookedDateTime.getTimes();

        return allTimes.stream().filter(i->!bookedTime.contains(i)).collect(Collectors.toList());

    }

    @Override
    public void register(Date appointmentDate, String appointmentTime) {
        ApptBookedDateTime bookedDateTime = apptBookedDateTimeRepository.findByDate(appointmentDate);

        if(bookedDateTime == null){
            bookedDateTime = new ApptBookedDateTime();
            bookedDateTime.setDate(appointmentDate);
        }

        if(bookedDateTime.getTimes() == null){
            bookedDateTime.setTimes(new ArrayList<>());
        }
        List<String> bookedTimes = bookedDateTime.getTimes();
        bookedTimes.add(appointmentTime);

        apptBookedDateTimeRepository.save(bookedDateTime);

    }

}
