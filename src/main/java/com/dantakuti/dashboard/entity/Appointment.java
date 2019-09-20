package com.dantakuti.dashboard.entity;

import java.util.Date;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
public class Appointment {


    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    private Date appointmentDate;
    private String appointmentTime;
    private Date bookingDate;
}
