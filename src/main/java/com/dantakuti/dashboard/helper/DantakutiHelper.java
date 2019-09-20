package com.dantakuti.dashboard.helper;

import com.dantakuti.dashboard.document.BookingDetail;

/**
 * @author adarshbhattarai on 2019-09-20
 * @project dashboard
 */
public class DantakutiHelper {


    public static final String SUFFIX_AM="am";
    public static final String SUFFIX_PM="pm";

    public static String formatAMPMTime(BookingDetail bookingDetail) throws Exception{
        String bookingTime = bookingDetail.getAppointment().getAppointmentTime();
        String[] hourMin = bookingTime.split(":");
        bookingTime = hourMin[0];
        int time = Integer.parseInt(bookingTime);
        return (time>12?time-12:time)+":"+hourMin[1]+" "+(time>11?SUFFIX_PM:SUFFIX_AM);
    }
}
