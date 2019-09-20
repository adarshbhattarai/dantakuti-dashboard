package com.dantakuti.dashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author adarshbhattarai on 2019-06-30
 * @project dashboard
 */
@Configuration
public class ApplicationProperties {

    @Value("${jwt.token.secret}")
    private String secretKey;

    @Value("${datakuti.email.id}")
    private String datakutiEmailId;

    @Value("${email.user.subject}")
    private String emailUserSubject;

    @Value("${email.admin.subject}")
    private String emailAdminSubject;

    @Value("${datakuti.noreply.email.id}")
    private String noReplyEmail;

    @Value("${dantakuti.appointment.availabletimes.am}")
    private String appointmentTimeAm;

    @Value("${dantakuti.appointment.availabletimes.pm}")
    private String appointmentTimePm;

    @Value("${email.notification.enabled}")
    private boolean notificationEnabled;

    public String getEmailUserSubject() {
        return emailUserSubject;
    }

    public void setEmailUserSubject(String emailUserSubject) {
        this.emailUserSubject = emailUserSubject;
    }

    public String getEmailAdminSubject() {
        return emailAdminSubject;
    }

    public void setEmailAdminSubject(String emailAdminSubject) {
        this.emailAdminSubject = emailAdminSubject;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDatakutiEmailId() {
        return datakutiEmailId;
    }

    public void setDatakutiEmailId(String datakutiEmailId) {
        this.datakutiEmailId = datakutiEmailId;
    }

    public String getNoReplyEmail() {
        return noReplyEmail;
    }

    public void setNoReplyEmail(String noReplyEmail) {
        this.noReplyEmail = noReplyEmail;
    }

    public String getAppointmentTimeAm() {
        return appointmentTimeAm;
    }

    public void setAppointmentTimeAm(String appointmentTimeAm) {
        this.appointmentTimeAm = appointmentTimeAm;
    }

    public String getAppointmentTimePm() {
        return appointmentTimePm;
    }

    public void setAppointmentTimePm(String appointmentTimePm) {
        this.appointmentTimePm = appointmentTimePm;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
}